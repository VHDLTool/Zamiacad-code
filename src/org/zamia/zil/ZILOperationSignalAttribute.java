/* 
 * Copyright 2009 by the authors indicated in the @author tags. 
 * All rights reserved. 
 * 
 * See the LICENSE file for details.
 * 
 */
package org.zamia.zil;

import org.zamia.ZamiaException;
import org.zamia.rtl.RTLSignal;
import org.zamia.util.HashSetArray;
import org.zamia.vhdl.ast.VHDLNode;
import org.zamia.zil.interpreter.ZILInterpreterCode;
import org.zamia.zil.interpreter.ZILSignalAttributeStmt;
import org.zamia.zil.synthesis.Bindings;
import org.zamia.zil.synthesis.VariableRemapping;


/**
 * 
 * @author Guenter Bartsch
 * 
 */
public class ZILOperationSignalAttribute extends ZILOperation {

	public enum SAOp {DELAYED, STABLE, QUIET, TRANSACTION, EVENT, ACTIVE, LAST_EVENT, LAST_ACTIVE, LAST_VALUE, DRIVING, DRIVING_VALUE};

	private long fTime;
	private ZILSignal fSignal;
	private SAOp fOperation;

	public ZILOperationSignalAttribute(SAOp aOperation, ZILSignal aSignal, long aTime, ZILType aType, ZILIContainer aContainer, VHDLNode aSrc) {
		super(aType, aContainer, aSrc);
		fSignal = aSignal;
		fTime = aTime;
		fOperation = aOperation;
	}

	public void dump(int aIndent) {
		logger.debug(aIndent, "%s", toString());
	}

	@Override
	public String toString() {
		return "OperationSignalAttribute (operation="+fOperation+", signal=" + fSignal + ", time=" + fTime + ")";
	}

	@Override
	protected void doElaborate(RTLSignal aResult, Bindings aLastBindings, RTLCache aCache) throws ZamiaException {
		// FIXME: implement
		throw new RuntimeException ("Not implemented method called.");
	}

	@Override
	public ZILClock getClock() throws ZamiaException {
		// FIXME: implement
		throw new RuntimeException ("Not implemented method called.");

	}

	@Override
	public ZILOperation resolveVariables(Bindings aVR, ZILSequenceOfStatements aSOS, RTLCache aCache) throws ZamiaException {
		// FIXME: implement
		throw new RuntimeException ("Not implemented method called.");
//		Operation a = this.a.resolveVariables(vr_, sos_, cache_);
//		return new OperationNot(a, null, location);
	}

	@Override
	public void generateCode(ZILInterpreterCode aCode, RTLCache aCache) throws ZamiaException {
		
		ZILType t = getType();
		ZILTypePhysical tt = t instanceof ZILTypePhysical ? (ZILTypePhysical) t : null;
		
		aCode.add(new ZILSignalAttributeStmt(fOperation, fSignal.elaborate(null, aCache), fTime, tt, getSrc()));
	}


	@Override
	public boolean isSynthesizable() throws ZamiaException {
		// FIXME: implement
		throw new RuntimeException ("Not implemented method called.");
	}

	@Override
	public ZILOperation inlineSubprograms(VariableRemapping vr_, ZILSequenceOfStatements sos_, RTLCache cache_) throws ZamiaException {
		return new ZILOperationSignalAttribute(fOperation, fSignal, fTime, getType(), sos_.getContainer(), getSrc());
	}

	@Override
	public boolean isConstant() throws ZamiaException {
		// FIXME: implement
		throw new RuntimeException ("Not implemented method called.");
	}

	@Override
	public int getNumOperands() {
		return 0;
	}

	@Override
	public ZILOperation getOperand(int aIdx) {
		return null;
	}

	@Override
	public void computeReadSignals(HashSetArray<ZILSignal> aReadSignals) {
		aReadSignals.add(fSignal);
	}

	public SAOp getOperation() {
		return fOperation;
	}

	public ZILSignal getSignal() {
		return fSignal;
	}
}
