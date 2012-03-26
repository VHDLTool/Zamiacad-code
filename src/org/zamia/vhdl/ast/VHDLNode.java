/*
 * Copyright 2006-2010 by the authors indicated in the @author tags.
 * All rights reserved.
 *
 * See the LICENSE file for details.
 *
 * Created by guenter on Feb 27, 2006
 * 
 */

package org.zamia.vhdl.ast;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Level;
import org.zamia.ASTNode;
import org.zamia.ERManager;
import org.zamia.ErrorReport;
import org.zamia.SourceLocation;
import org.zamia.ZamiaException;
import org.zamia.ZamiaException.ExCat;
import org.zamia.ZamiaLogger;
import org.zamia.ZamiaProject;
import org.zamia.analysis.ReferenceSearchResult;
import org.zamia.analysis.ReferenceSite.RefType;
import org.zamia.analysis.ast.ASTDeclarationSearch;
import org.zamia.analysis.ast.ASTReferencesSearch.ObjectCat;
import org.zamia.analysis.ast.SearchJob;
import org.zamia.instgraph.IGContainer;
import org.zamia.instgraph.IGElaborationEnv;
import org.zamia.instgraph.IGItem;
import org.zamia.instgraph.IGObject;
import org.zamia.instgraph.IGOperationObject;
import org.zamia.util.HashSetArray;

/**
 * 
 * base class for all VHDL AST nodes
 * 
 * @author Guenter Bartsch
 * 
 */

@SuppressWarnings("serial")
public abstract class VHDLNode extends ASTNode {

	public enum ASTErrorMode {
		EXCEPTION, RETURN_NULL
	};

	public static final boolean QUICK_ERROR_REPORTING = true;

	public VHDLNode(VHDLNode aParent, long aLocation) {

		super(aParent);

		setStartLine((int) (aLocation & 0xFFFFFFFF));
		setStartCol((int) (aLocation >> 32));
	}

	public VHDLNode(long aLocation) {
		this(null, aLocation);
	}

	public SourceLocation getLocation() {
		if (fSource != null) {
			return new SourceLocation(fSource, fStartLine, fStartCol);
		}
		if (fParent != null) {
			SourceLocation pl = fParent.getLocation();
			if (pl != null) {
				return new SourceLocation(pl.fSF, fStartLine, fStartCol);
			}
		}
		return null;
	}

	
	// overwritten in DesignUnit
	public String getLibId() {

		ASTNode parent = getParent();

		if (parent instanceof VHDLNode)
			return ((VHDLNode) parent).getLibId();
		return null;
	}

	// overwritten in DesignUnit
	public DesignUnit getDesignUnit() {

		ASTNode parent = getParent();

		if (parent instanceof VHDLNode)
			return ((VHDLNode) parent).getDesignUnit();

		return null;
	}

	@Override
	public void setParent(ASTNode aParent) {
		setParent(aParent, false);
	}

	public void setParent(VHDLNode aParent, boolean aForce) {

		if (!aForce && fParent != null)
			return;

		fParent = aParent;
	}

	public abstract int getNumChildren();

	public abstract VHDLNode getChild(int aIdx);

	// should be overwritten by ios which have declarations
	public DeclarativeItem findDeclaration(String aId, ZamiaProject aZPrj) {
		if (ASTDeclarationSearch.dump) {
			logger.debug("SA: findDeclaration ('%s'), this=%s", aId, toString());
		}
		ASTNode p = getParent();
		if (p instanceof VHDLNode)
			return ((VHDLNode) p).findDeclaration(aId, aZPrj);
		return null;
	}

	public static void printSpaces(PrintStream aOut, int aN) {
		for (int i = 0; i < aN; i++)
			aOut.print(" ");
	}

	public static void printIndented(String aStr, int aIndent, PrintStream aOut) {
		for (int i = 0; i < aIndent; i++)
			aOut.print(" ");
		aOut.print(aStr);
	}

	public static void printlnIndented(String aStr, int aIndent, PrintStream aOut) {
		printIndented(aStr, aIndent, aOut);
		aOut.println();
	}

	// FIXME: make abstract, implement in all subclasses
	public void dumpVHDL(int aIndent, PrintStream aOut) throws ZamiaException {
		throw new ZamiaException("Don't know how to dump vhdl for " + this);
	}

	@SuppressWarnings("rawtypes")
	public static void dump(PrintStream aOut, VHDLNode aObj, int aIndent, HashSet<Object> aDumpedObjects) {

		if (aDumpedObjects.contains(aObj))
			return;
		aDumpedObjects.add(aObj);

		Class cls = aObj.getClass();

		while (!Object.class.equals(cls)) {
			Field[] fields = cls.getDeclaredFields();
			int n = fields.length;
			for (int i = 0; i < n; i++) {
				Field field = fields[i];
				field.setAccessible(true);

				String id = field.getName();
				if (id.equals("parent") || id.equals("context") || id.equals("uid") || id.equals("counter") || id.equals("cnt") || id.contains("OP") || id.contains("CAT")
						|| id.contains("log"))
					continue;

				printSpaces(aOut, aIndent);
				aOut.print(field.getName());

				try {
					Object value = field.get(aObj);

					if (value instanceof VHDLNode) {
						VHDLNode io = (VHDLNode) value;
						aOut.println(": " + io.getClass().getName() + " { #" + io.getCnt());
						dump(aOut, (VHDLNode) value, aIndent + 2, aDumpedObjects);
						printSpaces(aOut, aIndent);
						aOut.print(field.getName());
						aOut.println(" } #" + io.getCnt());
					} else if (value instanceof List) {
						List list = (List) value;

						aOut.println(": " + list.getClass().getName() + " [ ");

						int m = list.size();
						for (int j = 0; j < m; j++) {
							Object o = list.get(j);

							printSpaces(aOut, aIndent + 2);
							aOut.println("[" + j + "]");

							if (o instanceof VHDLNode) {
								VHDLNode io = (VHDLNode) o;
								printSpaces(aOut, aIndent + 2);
								aOut.println(": " + io.getClass().getName() + " { #" + io.getCnt());
								dump(aOut, io, aIndent + 4, aDumpedObjects);
							} else {
								printSpaces(aOut, aIndent + 2);
								aOut.println(" = " + value);
							}
						}
						printSpaces(aOut, aIndent);
						aOut.print(field.getName());
						aOut.println(" ]");
					} else {
						aOut.println(" = " + value);
					}

				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			cls = cls.getSuperclass();
		}

		if (aIndent == 2) {
			aOut.println();
			aOut.println("# objects dumped: " + aDumpedObjects.size());
		}
	}

	@SuppressWarnings("rawtypes")
	public static void sanityCheck(PrintStream aOut, VHDLNode aObj, HashSet<Object> aCheckedObjects) {

		if (aCheckedObjects.contains(aObj))
			return;
		aCheckedObjects.add(aObj);

		Class cls = aObj.getClass();

		while (!Object.class.equals(cls)) {
			Field[] fields = cls.getDeclaredFields();
			int n = fields.length;
			for (int i = 0; i < n; i++) {
				Field field = fields[i];
				field.setAccessible(true);

				String id = field.getName();

				if (id.equals("parent"))
					continue;

				try {
					Object value = field.get(aObj);

					if (value instanceof OperationLiteral)
						continue;

					if (value instanceof VHDLNode) {
						VHDLNode io = (VHDLNode) value;

						if (io.getParent() != aObj) {
							System.out.println("Error: io " + io + " (cnt " + io.getCnt() + ") does not point to parent " + aObj + " (cnt=" + aObj.getCnt() + ")");
						}

						sanityCheck(aOut, io, aCheckedObjects);
					} else if (value instanceof List) {
						List list = (List) value;

						int m = list.size();
						for (int j = 0; j < m; j++) {
							Object o = list.get(j);

							if (o instanceof VHDLNode) {
								VHDLNode io = (VHDLNode) o;

								if (io instanceof OperationLiteral)
									continue;

								if (io.getParent() != aObj) {
									System.out.println("Error: io " + io + " (cnt " + io.getCnt() + ") does not point to parent " + aObj + " (cnt=" + aObj.getCnt() + ")");
								}

								sanityCheck(aOut, io, aCheckedObjects);
							}
						}
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			cls = cls.getSuperclass();
		}
	}

	// convenience

	public void dumpObjectTree(ZamiaLogger aZL, Level aLevel) {

		aZL.log(aLevel, "");
		aZL.log(aLevel, "-----------------------------------------------");
		aZL.log(aLevel, "Object tree of IO " + this + ": ");

		ASTNode io = this;
		int count = 0;
		while (count < 20) {

			aZL.log(aLevel, "%3d : %8h : %20s : %s\n", count, io.hashCode(), io.getLocation(), io.getClass());
			aZL.log(aLevel, "    " + io);
			count++;
			io = io.getParent();
			if (io == null)
				break;
		}

		aZL.log(aLevel, "Object tree of IO " + this + " ends here ");
		aZL.log(aLevel, "-----------------------------------------------");
	}

	public abstract void findReferences(String aId, ObjectCat aCategory, RefType aRefType, int aDepth, ZamiaProject aZPrj, IGContainer aContainer, IGElaborationEnv aCache,
			ReferenceSearchResult aResult, ArrayList<SearchJob> aTODO) throws ZamiaException;

	public static IGItem tryToGenerateIGOperation(IGItem aItem, IGContainer aContainer, SourceLocation aSrc) {

		if (aItem instanceof IGObject) {
			return new IGOperationObject((IGObject) aItem, aSrc, aContainer.getZDB());
		}

		return aItem;
	}

	/**
	 * Used in CompletionProcessor
	 * 
	 * to be overwritten by subclasses if they have declarations
	 * 
	 * @param aIndentifiers
	 * @param aZPrj
	 *            TODO
	 */
	public void collectIdentifiers(HashSetArray<String> aIndentifiers, ZamiaProject aZPrj) {

		ASTNode parent = getParent();

		if (parent instanceof VHDLNode)
			((VHDLNode) parent).collectIdentifiers(aIndentifiers, aZPrj);
	}

	/*
	 * convenience error reporting functions
	 */

	public void reportError(ZamiaException aException) {

		aException.setCat(ExCat.INTERMEDIATE);

		ERManager erm = null;

		ZamiaProject zprj = getZPrj();
		if (zprj != null) {
			erm = zprj.getERM();
		}

		SourceLocation location = aException.getLocation();
		if (location == null) {
			location = getLocation();
			aException = new ZamiaException(aException.getMessage(), location);
		}

		if (erm != null) {
			erm.addError(aException);
		} else {
			logger.error("Error: %s: %s", aException.getLocation(), aException.getMessage());
		}
	}

	public ZamiaProject getZPrj() {
		DesignUnit du = getDesignUnit();
		if (du != null) {
			return du.getZPrj();
		}
		return null;
	}

	public void reportError(String aMessage) {
		reportError(new ZamiaException(ExCat.INTERMEDIATE, true, aMessage, this));
	}

	public void reportWarning(String aMessage) {
		reportError(new ZamiaException(ExCat.INTERMEDIATE, false, aMessage, this));
	}

	public void reportError(String aFormat, Object... aArgs) {

		String msg = String.format(aFormat, aArgs);

		//String msg = formatter.format(aFormat, aArgs);
		//System.out.printf("H");

		reportError(msg);
	}

	public void reportWarning(String aFormat, Object... aArgs) {
		String msg = String.format(aFormat, aArgs);
		reportWarning(msg);
	}

	// utility functions for new postponed error reporting
	protected void reportError(String aMsg, SourceLocation aLocation, ASTErrorMode aErrorMode, ErrorReport aReport) throws ZamiaException {
		if (aErrorMode == ASTErrorMode.EXCEPTION) {

			if (aReport != null) {
				aReport.append(aMsg, aLocation);
				aReport.log();
			} else {
				logger.debug("Error report: %s: %s", aLocation, aMsg);
			}

			throw new ZamiaException(aMsg, aLocation);
		}
		aReport.append(aMsg, aLocation);
	}

	protected void reportError(String aMsg, ASTErrorMode aErrorMode, ErrorReport aReport) throws ZamiaException {
		reportError(aMsg, getLocation(), aErrorMode, aReport);
	}

	protected void reportError(String aMsg, VHDLNode aObj, ASTErrorMode aErrorMode, ErrorReport aReport) throws ZamiaException {
		reportError(aMsg, aObj.getLocation(), aErrorMode, aReport);
	}

}
