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
import org.zamia.instgraph.interpreter.IGTypeConversionStmt;
import org.zamia.util.HashSetArray;
import org.zamia.zdb.ZDB;

/**
 * 
 * @author Guenter Bartsch
 * 
 */
@SuppressWarnings("serial")
public class IGOperationTypeConversion extends IGUnitaryOperation {

	public IGOperationTypeConversion(IGOperation aOp, IGType aType, SourceLocation aSrc, ZDB aZDB) {
		super(aOp, aType, aSrc, aZDB);
	}

	protected void appendCode(boolean aFromInside, IGInterpreterCode aCode) throws ZamiaException {
		aCode.add(new IGTypeConversionStmt(getType(), computeSourceLocation(), getZDB()));
	}

}
