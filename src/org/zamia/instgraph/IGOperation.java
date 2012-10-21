/* 
 * Copyright 2009,2011 by the authors indicated in the @author tags. 
 * All rights reserved. 
 * 
 * See the LICENSE file for details.
 * 
 * Created by Guenter Bartsch on Apr 11, 2009
 */
package org.zamia.instgraph;

import java.io.IOException;
import java.io.ObjectOutputStream;

import org.python.antlr.PythonParser.assert_stmt_return;
import org.zamia.ErrorReport;
import org.zamia.SourceLocation;
import org.zamia.ZamiaException;
import org.zamia.instgraph.IGItemAccess.AccessType;
import org.zamia.instgraph.IGObject.OIDir;
import org.zamia.instgraph.IGOperationAttribute.AttrOp;
import org.zamia.instgraph.interpreter.IGInterpreterCode;
import org.zamia.instgraph.interpreter.IGInterpreterRuntimeEnv;
import org.zamia.instgraph.interpreter.IGStackFrame;
import org.zamia.instgraph.interpreter.IGStmt.ReturnStatus;
import org.zamia.util.HashSetArray;
import org.zamia.vhdl.ast.VHDLNode.ASTErrorMode;
import org.zamia.zdb.ZDB;

/**
 * 
 * @author Guenter Bartsch
 * 
 */

@SuppressWarnings("serial")
public abstract class IGOperation extends IGItem {

	private long fTypeDBID;

	private transient IGType fType;

	public IGOperation(IGType aType, SourceLocation aSrc, ZDB aZDB) {
		super(aSrc, aZDB);

		//		if (aType == null) {
		//			logger.error("IGOperation: Internal error: Creating a null=typed operation.");
		//		}

		fType = aType;
	}

	public abstract void generateCode(boolean aFromInside, IGInterpreterCode aCode) throws ZamiaException;

	public void generateCodeTransparentForLineCoverage(boolean aFromInside, IGInterpreterCode aCode) throws ZamiaException {
		aCode.muteExecCount();
		generateCode(aFromInside, aCode);
		aCode.unmuteExecCount();
	}

	public IGStaticValue computeStaticValue(IGInterpreterRuntimeEnv aEnv, ASTErrorMode aErrorMode, ErrorReport aReport) throws ZamiaException {
		//IGInterpreterCode ic = new IGInterpreterCode("Constant computation for " + this, computeSourceLocation());
		IGInterpreterCode ic = new IGInterpreterCode("Constant computation", computeSourceLocation());

		generateCode(true, ic);

		//		System.out.println("===================================================================");
		//		System.out.println("IGOperation: computeActualConstant(): Code for operation: " + this + ":");
		//		ic.dump(System.out);
		//		System.out.println("===================================================================");

		/*
		 * execute the code in the end we should find the return
		 * value on the stack
		 */

		aEnv.enterContext();

		try {
			ReturnStatus status = aEnv.call(ic, aErrorMode, aReport);
			if (status == ReturnStatus.ERROR) {
				return null;
			}

			status = aEnv.resume(aErrorMode, aReport);
			if (status == ReturnStatus.ERROR) {
				return null;
			}

			aEnv.rts();
		} finally {
			aEnv.exitContext();
		}

		IGStackFrame sf = aEnv.pop();
		if (sf == null) {
			return null;
		}
		IGStaticValue res = sf.getValue();
		return res;
	}

	public abstract int getNumOperands();

	public abstract IGOperation getOperand(int aIdx);

	@Override
	public IGItem getChild(int aIdx) {
		return getOperand(aIdx);
	}

	@Override
	public int getNumChildren() {
		return getNumOperands();
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		if (fTypeDBID == 0) {
			fTypeDBID = save(fType);
			fType = null; // we have to drop the reference so GC will be able to free the memory
		}
		out.defaultWriteObject();
	}

	public IGType getType() {
		if (fType != null) {
			return fType;
		}
		IGType type = (IGType) getZDB().load(fTypeDBID);
		return type;
	}

	public abstract OIDir getDirection() throws ZamiaException;

	public abstract void computeAccessedItems(boolean aLeftSide, IGItem aFilterItem, AccessType aFilterType, int aDepth, HashSetArray<IGItemAccess> aAccessedItems);

	/*
	 * 
	 * expression utilities - automatic static constant propagation
	 * 
	 */

	public IGOperation optimize(IGInterpreterRuntimeEnv aEnv) throws ZamiaException {
		if (aEnv == null) {
			return this;
		}
		ErrorReport report = new ErrorReport();
		IGStaticValue sv = computeStaticValue(aEnv, ASTErrorMode.RETURN_NULL, report);
		if (sv != null) {
			return sv;
		}
		return this;
	}

	/*
	 * 
	 * range utilities
	 * 
	 */

	private IGType checkType(SourceLocation aSrc) throws ZamiaException {
		IGType t = getType();
		if (!t.isRange()) {
			throw new ZamiaException("Range expected here.", aSrc);
		}
		return t;
	}
	
	public IGOperation getRangeLeft(SourceLocation aSrc) throws ZamiaException {
		IGType t = checkType(aSrc);
		return new IGOperationAttribute(AttrOp.LEFT, this, null, t.getBaseType(), aSrc, getZDB());
	}

	public IGOperation getRangeRight(SourceLocation aSrc) throws ZamiaException {
		IGType t = checkType(aSrc);
		return new IGOperationAttribute(AttrOp.RIGHT, this, null, t.getBaseType(), aSrc, getZDB());
	}

	public IGOperation getRangeAscending(IGContainer aContainer, SourceLocation aSrc) throws ZamiaException {
		IGType t = checkType(aSrc);
		return new IGOperationAttribute(AttrOp.ASCENDING, this, null, aContainer.findBoolType(), aSrc, getZDB());
	}

	public IGOperation getRange(boolean max, IGContainer aContainer, SourceLocation aSrc) throws ZamiaException {
		IGType t = checkType(aSrc);
		
		IGOperation left = max ? getRangeRight(aSrc) : getRangeLeft(aSrc);
		IGOperation right = max ? getRangeLeft(aSrc) : getRangeRight(aSrc);
		IGOperation ascending = getRangeAscending(aContainer, aSrc);

		return new IGOperationPhi(ascending, left, right, t.getBaseType(), aSrc, getZDB());
		
	}

	public IGOperation getRangeMin(IGContainer aContainer, SourceLocation aSrc) throws ZamiaException {
		return getRange(false, aContainer, aSrc);
	}
	public IGOperation getRangeMax(IGContainer aContainer, SourceLocation aSrc) throws ZamiaException {
		return getRange(true, aContainer, aSrc);
	}

	/**
	 * Generate human-readable string representation of this statement
	 * to be overwritten by subclasses
	 * 
	 * @return
	 */
	public String toHRString() {
		return toString();
	}
}
