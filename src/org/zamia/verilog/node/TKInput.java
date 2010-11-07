/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;
import org.zamia.SourceFile;

@SuppressWarnings("nls")
public final class TKInput extends Token
{
    public TKInput(int line, int pos, SourceFile sf)
    {
        super ("input", line, pos, sf);
    }

    @Override
    public Object clone()
    {
      return new TKInput(getLine(), getPos(), getSource());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTKInput(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TKInput text.");
    }
}
