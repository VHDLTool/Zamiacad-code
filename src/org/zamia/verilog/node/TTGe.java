/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;
import org.zamia.SourceFile;

@SuppressWarnings("nls")
public final class TTGe extends Token
{
    public TTGe(int line, int pos, SourceFile sf)
    {
        super (">=", line, pos, sf);
    }

    @Override
    public Object clone()
    {
      return new TTGe(getLine(), getPos(), getSource());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTTGe(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TTGe text.");
    }
}
