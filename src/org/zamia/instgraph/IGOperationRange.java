/* 
 * Copyright 2010 by the authors indicated in the @author tags. 
 * All rights reserved. 
 * 
 * See the LICENSE file for details.
 * 
 * Created by Guenter Bartsch on Jan 22, 2010
 */

package org.zamia.instgraph;

import org.zamia.SourceLocation;
import org.zamia.ZamiaException;
import org.zamia.instgraph.IGItemAccess.AccessType;
import org.zamia.instgraph.IGObject.OIDir;
import org.zamia.instgraph.interpreter.IGInterpreterCode;
import org.zamia.instgraph.interpreter.IGRangeOpStmt;
import org.zamia.instgraph.interpreter.IGRangeOpStmt.IGRangeOp;
import org.zamia.util.HashSetArray;
import org.zamia.zdb.ZDB;

/**
 * 
 * @author Guenter Bartsch
 * 
 */
@SuppressWarnings("serial")
public class IGOperationRange extends IGUnitaryOperation {

	private IGOperation fRange;

	public IGOperationRange(IGOperation aRange, IGOperation aOp, IGType aType, SourceLocation aSrc, ZDB aZDB) {
		super(aOp, aType, aSrc, aZDB);
		fRange = aRange;
	}

	@Override
	public void appendCode(boolean aFromInside, IGInterpreterCode aCode) throws ZamiaException {
		fRange.generateCode(aFromInside, aCode);
		aCode.add(new IGRangeOpStmt(IGRangeOp.APPLY, getType(), computeSourceLocation(), getZDB()));
	}

	@Override
	public int getNumOperands() {
		return 2;
	}

	@Override
	public IGOperation getOperand(int aIdx) {
		switch (aIdx) {
		case 0:
			return getOperand();
		case 1:
			return fRange;
		}
		return null;
	}

	@Override
	public void computeAccessedItems(boolean aLeftSide, IGItem aFilterItem, AccessType aFilterType, int aDepth, HashSetArray<IGItemAccess> aAccessedItems) {
		getOperand().computeAccessedItems(aLeftSide, aFilterItem, aFilterType, aDepth, aAccessedItems);
		fRange.computeAccessedItems(false, aFilterItem, aFilterType, aDepth, aAccessedItems);
	}

	@Override
	public String toString() {
		return getOperand().toString() + "(" + fRange + ")";
	}

	public IGOperation getRange() {
		return fRange;
	}

}
