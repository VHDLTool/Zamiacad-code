/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;
import org.zamia.SourceFile;

@SuppressWarnings("nls")
public final class TKMax extends Token
{
    public TKMax(int line, int pos, SourceFile sf)
    {
        super ("max", line, pos, sf);
    }

    @Override
    public Object clone()
    {
      return new TKMax(getLine(), getPos(), getSource());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTKMax(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TKMax text.");
    }
}
