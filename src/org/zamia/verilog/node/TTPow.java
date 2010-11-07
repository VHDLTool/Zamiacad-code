/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;
import org.zamia.SourceFile;

@SuppressWarnings("nls")
public final class TTPow extends Token
{
    public TTPow(int line, int pos, SourceFile sf)
    {
        super ("**", line, pos, sf);
    }

    @Override
    public Object clone()
    {
      return new TTPow(getLine(), getPos(), getSource());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTTPow(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TTPow text.");
    }
}
