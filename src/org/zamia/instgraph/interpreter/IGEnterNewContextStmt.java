/* 
 * Copyright 2010 by the authors indicated in the @author tags. 
 * All rights reserved. 
 * 
 * See the LICENSE file for details.
 * 
 */
package org.zamia.instgraph.interpreter;

import org.zamia.ErrorReport;
import org.zamia.SourceLocation;
import org.zamia.ZamiaException;
import org.zamia.vhdl.ast.VHDLNode.ASTErrorMode;
import org.zamia.zdb.ZDB;


/**
 * 
 * @author Guenter Bartsch
 * 
 */
@SuppressWarnings("serial")
public class IGEnterNewContextStmt extends IGStmt {

	public IGEnterNewContextStmt(SourceLocation aLocation, ZDB aZDB) {
		super(aLocation, aZDB);
	}

	@Override
	public ReturnStatus execute(IGInterpreterRuntimeEnv aRuntime, ASTErrorMode aErrorMode, ErrorReport aReport) throws ZamiaException {
		aRuntime.enterContext();
		return ReturnStatus.CONTINUE;
	}
	
	@Override
	public String toString() {
		return "ENTER CONTEXT";
	}

}
