/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;
import org.zamia.SourceFile;

@SuppressWarnings("nls")
public final class TKTri1 extends Token
{
    public TKTri1(int line, int pos, SourceFile sf)
    {
        super ("tri1", line, pos, sf);
    }

    @Override
    public Object clone()
    {
      return new TKTri1(getLine(), getPos(), getSource());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTKTri1(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TKTri1 text.");
    }
}
