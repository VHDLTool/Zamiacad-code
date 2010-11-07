/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;
import org.zamia.SourceFile;

@SuppressWarnings("nls")
public final class TKPathpulses extends Token
{
    public TKPathpulses(int line, int pos, SourceFile sf)
    {
        super ("PATHPULSE$", line, pos, sf);
    }

    @Override
    public Object clone()
    {
      return new TKPathpulses(getLine(), getPos(), getSource());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTKPathpulses(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TKPathpulses text.");
    }
}
