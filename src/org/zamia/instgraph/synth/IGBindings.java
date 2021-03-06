/*
 * Copyright 2005-2011 by the authors indicated in the @author tags.
 * All rights reserved.
 *
 * See the LICENSE file for details.
 *
*/

package org.zamia.instgraph.synth;

import java.util.HashSet;
import java.util.Set;

import org.zamia.SourceLocation;
import org.zamia.ZamiaException;
import org.zamia.ZamiaLogger;
import org.zamia.instgraph.IGOperationUnary.UnaryOp;
import org.zamia.instgraph.synth.model.IGSMExprEngine;
import org.zamia.instgraph.synth.model.IGSMExprNode;
import org.zamia.instgraph.synth.model.IGSMExprNodeClockEdge;
import org.zamia.rtl.RTLSignal;
import org.zamia.rtl.RTLValue;
import org.zamia.rtl.RTLValue.BitValue;
import org.zamia.util.HashMapArray;

/**
 * 
 * @author Guenter Bartsch
 * 
 */

public class IGBindings {

	public final static ZamiaLogger logger = ZamiaLogger.getInstance();

	private final HashMapArray<RTLSignal, IGBinding> fBindings;

	public IGBindings() {
		fBindings = new HashMapArray<RTLSignal, IGBinding>();
	}

	public int getNumBindings() {
		return fBindings.size();
	}

	public IGBinding getBinding(int aIdx) {
		return fBindings.get(aIdx);
	}

	public IGBinding getBinding(RTLSignal aSignal) {
		return fBindings.get(aSignal);
	}

	public void setBinding(RTLSignal aSignal, IGBinding aBinding) {
		fBindings.put(aSignal, aBinding);
	}

	public void dumpBindings() {

		logger.debug("Bindings dump for Bindings@" + hashCode());

		int n = getNumBindings();
		for (int i = 0; i < n; i++) {
			IGBinding b = getBinding(i);
			b.dump();
		}
	}

	public void synthesize(IGSynth aSynth) throws ZamiaException {

		IGSMExprEngine ee = aSynth.getEE();

		int n = getNumBindings();
		for (int i = 0; i < n; i++) {
			IGBinding b = getBinding(i);

			SourceLocation l = b.getBinding().fLocation;

			IGSMExprNode ec = b.computeCombinedEnable(aSynth);

			logger.debug("IGBindings: Combined enable for %s is %s", b.getTarget(), ec);

			// compute async enable

			Set<IGSMExprNodeClockEdge> clks = new HashSet<IGSMExprNodeClockEdge>();

			ec.findClockEdges(clks);

			int nClks = clks.size();
			if (nClks > 1) {
				throw new ZamiaException("Multiple clocks are not supported.", l);
			}

			final RTLSignal clk = nClks == 0 ? null : clks.iterator().next().getSignal();

			IGSMExprNode aE = clk != null ? ec.replaceClockEdge(clk, aSynth.getBitValue(BitValue.BV_0), aSynth) : ec;

			logger.debug("IGBindings: Async enable for %s is %s", b.getTarget(), aE);

			// compute async data

			RTLValue aEsv = aE.getStaticValue();
			RTLSignal aD = null;
			
			if ((aEsv == null) || (aEsv.getBit() != BitValue.BV_0)) {
				aD = b.synthesizeASyncData(aE, clk, aSynth);
			}

			// compute sync enable

			IGSMExprNode e = clk != null ? ec.replaceClockEdge(clk, aSynth.getBitValue(BitValue.BV_1), aSynth) : null;

			RTLSignal d = null;

			if (e != null) {

				IGSMExprNode aEn = ee.unary(UnaryOp.NOT, aE, l);

				e = ee.restrict(e, aEn, aSynth, l);

				logger.debug("IGBindings: Sync enable for %s is %s", b.getTarget(), e);

				d = b.synthesizeSyncData(aEn, clk, aSynth);

			}

			if (e == null && aE.getStaticValue() != null) {

				aSynth.sigjoin(aD, b.getTarget(), l);

			} else {

				RTLSignal se = e != null ? e.synthesize(aSynth) : null;
				
				RTLSignal sae = aE.synthesize(aSynth);
				
				RTLSignal tmp = aSynth.placeReg(sae, aD, se, d, clk, l);

				aSynth.sigjoin(tmp, b.getTarget(), l);

			}
		}
	}

}