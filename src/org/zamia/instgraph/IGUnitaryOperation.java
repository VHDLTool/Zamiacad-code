/* 
 * Copyright 2009 by the authors indicated in the @author tags. 
 * All rights reserved. 
 * 
 * See the LICENSE file for details.
 * 
 * Created by Guenter Bartsch on Apr 10, 2009
 */
package org.zamia.instgraph;

import org.zamia.SourceLocation;
import org.zamia.ZamiaException;
import org.zamia.instgraph.IGItemAccess.AccessType;
import org.zamia.instgraph.IGObject.OIDir;
import org.zamia.instgraph.interpreter.IGInterpreterCode;
import org.zamia.util.HashSetArray;
import org.zamia.zdb.ZDB;


/**
 * 
 * @author Guenter Bartsch
 * 
 */
@SuppressWarnings("serial")
public abstract class IGUnitaryOperation extends IGOperation {

	private IGOperation fOp;

	public IGUnitaryOperation(IGOperation aOp, IGType aType, SourceLocation aSrc, ZDB aZDB) {
		super(aType, aSrc, aZDB);
		fOp = aOp;
	}

	@Override
	public void computeAccessedItems(boolean aLeftSide, IGItem aFilterItem, AccessType aFilterType, int aDepth, HashSetArray<IGItemAccess> aAccessedItems) {
		fOp.computeAccessedItems(aLeftSide, aFilterItem, aFilterType, aDepth, aAccessedItems);
	}

	@Override
	public void generateCode(boolean aFromInside, IGInterpreterCode aCode) throws ZamiaException {
		fOp.generateCode(aFromInside, aCode);
		appendCode(aFromInside, aCode);
	}
	abstract protected void appendCode(boolean aFromInside, IGInterpreterCode aCode) throws ZamiaException;

	@Override
	public OIDir getDirection() throws ZamiaException {
		return fOp.getDirection();
	}

	@Override
	public int getNumOperands() {
		return 1;
	}

	@Override
	public IGOperation getOperand(int aIdx) {
		return fOp;
	}

	public IGOperation getOperand() {
		return fOp;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(op=" + fOp + ")";
	}

	
}
