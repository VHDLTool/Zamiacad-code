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
import org.zamia.zdb.ZDB;


/**
 * 
 * @author Guenter Bartsch
 * 
 */
@SuppressWarnings("serial")
public class IGRecordField extends IGContainerItem {

	private long fTypeDBID;

	public IGRecordField(IGType aType, String aId, SourceLocation aSrc, ZDB aZDB) {
		super(aId, aSrc, aZDB);
		fTypeDBID = save(aType);
	}

	public IGType getType() {
		return (IGType) getZDB().load(fTypeDBID);
	}

}
