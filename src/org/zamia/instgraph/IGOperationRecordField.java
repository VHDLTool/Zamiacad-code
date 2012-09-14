/* 
 * Copyright 2010 by the authors indicated in the @author tags. 
 * All rights reserved. 
 * 
 * See the LICENSE file for details.
 * 
 */
package org.zamia.instgraph;

import org.zamia.SourceLocation;
import org.zamia.ZamiaException;
import org.zamia.instgraph.IGItemAccess.AccessType;
import org.zamia.instgraph.IGObject.OIDir;
import org.zamia.instgraph.interpreter.IGInterpreterCode;
import org.zamia.instgraph.interpreter.IGRecordFieldOpStmt;
import org.zamia.util.HashSetArray;
import org.zamia.zdb.ZDB;

/**
 * 
 * @author Guenter Bartsch
 * 
 */

@SuppressWarnings("serial")
public class IGOperationRecordField extends IGUnitaryOperation {

	private IGRecordField fRF;

	public IGOperationRecordField(IGRecordField aRF, IGOperation aOp, IGType aType, SourceLocation aSrc, ZDB aZDB) {
		super(aOp, aType, aSrc, aZDB);
		fRF = aRF;
	}

	@Override
	protected void appendCode(boolean aFromInside, IGInterpreterCode aCode) throws ZamiaException {
		aCode.add(new IGRecordFieldOpStmt(fRF, computeSourceLocation(), getZDB()));
	}	

	@Override
	public String toString() {
		return getOperand() + "." + fRF.getId();
	}

	public IGRecordField getRecordField() {
		return fRF;
	}

}
