/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;
import org.zamia.SourceFile;

@SuppressWarnings("nls")
public final class TKTriand extends Token
{
    public TKTriand(int line, int pos, SourceFile sf)
    {
        super ("triand", line, pos, sf);
    }

    @Override
    public Object clone()
    {
      return new TKTriand(getLine(), getPos(), getSource());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTKTriand(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TKTriand text.");
    }
}
