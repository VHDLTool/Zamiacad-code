/* 
 * Copyright 2009,2010 by the authors indicated in the @author tags. 
 * All rights reserved. 
 * 
 * See the LICENSE file for details.
 * 
 * Created by Guenter Bartsch on Jun 7, 2009
 */
package org.zamia.instgraph;

import org.zamia.SourceLocation;
import org.zamia.ZamiaException;
import org.zamia.instgraph.IGItemAccess.AccessType;
import org.zamia.instgraph.IGObject.OIDir;
import org.zamia.instgraph.IGType.TypeCat;
import org.zamia.instgraph.interpreter.IGAliasOpStmt;
import org.zamia.instgraph.interpreter.IGInterpreterCode;
import org.zamia.util.HashSetArray;
import org.zamia.zdb.ZDB;

/**
 * 
 * @author Guenter Bartsch
 * 
 */

@SuppressWarnings("serial")
public class IGOperationAlias extends IGUnitaryOperation {

	private String fId;

	public IGOperationAlias(IGOperation aOp, IGType aType, String aId, SourceLocation aLocation, ZDB aZDB) {
		super(aOp, aType != null ? aType : aOp.getType(), aLocation, aZDB);
		fId = aId;
	}

	@Override
	protected void appendCode(boolean aFromInside, IGInterpreterCode aCode) throws ZamiaException {
		IGType t = getType();
		if (t.getCat() == TypeCat.ARRAY) {
			aCode.add(new IGAliasOpStmt(t, computeSourceLocation(), getZDB()));
		}
	}

	@Override
	public String getId() {
		return fId;
	}

	@Override
	public void setId(String aId) {
		throw new RuntimeException("Alias.setID(name) is not implemented, sorry");
	}

}
