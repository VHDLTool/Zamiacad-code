/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;
import org.zamia.SourceFile;

@SuppressWarnings("nls")
public final class TKTri extends Token
{
    public TKTri(int line, int pos, SourceFile sf)
    {
        super ("tri", line, pos, sf);
    }

    @Override
    public Object clone()
    {
      return new TKTri(getLine(), getPos(), getSource());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTKTri(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TKTri text.");
    }
}
