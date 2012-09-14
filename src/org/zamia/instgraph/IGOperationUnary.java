/* 
 * Copyright 2009 by the authors indicated in the @author tags. 
 * All rights reserved. 
 * 
 * See the LICENSE file for details.
 * 
 * Created by Guenter Bartsch on Apr 11, 2009
 */
package org.zamia.instgraph;

import org.zamia.SourceLocation;
import org.zamia.ZamiaException;
import org.zamia.instgraph.IGItemAccess.AccessType;
import org.zamia.instgraph.IGObject.OIDir;
import org.zamia.instgraph.interpreter.IGInterpreterCode;
import org.zamia.instgraph.interpreter.IGStmt;
import org.zamia.instgraph.interpreter.IGUnaryOpStmt;
import org.zamia.util.HashSetArray;
import org.zamia.zdb.ZDB;

/**
 * 
 * @author Guenter Bartsch
 * 
 */
@SuppressWarnings("serial")
public class IGOperationUnary extends IGUnitaryOperation {

	public enum UnaryOp {
		NEG, NOT, ABS, BUF
	};

	private UnaryOp fFunc;

	public IGOperationUnary(IGOperation aArg, UnaryOp aFunc, IGType aType, SourceLocation aSrc, ZDB aZDB) {
		super(aArg, aType, aSrc, aZDB);
		fFunc = aFunc;
	}

	@Override
	protected void appendCode(boolean aFromInside, IGInterpreterCode aCode) throws ZamiaException {
		aCode.add(new IGUnaryOpStmt(fFunc, computeSourceLocation(), getZDB()));
	}

	public IGOperation getA() {
		return getOperand();
	}

	public UnaryOp getUnaryOp() {
		return fFunc;
	}

	@Override
	public String toString() {
		return fFunc + " " + getA().toString();
	}

}
