/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;
import org.zamia.SourceFile;

@SuppressWarnings("nls")
public final class TKNand extends Token
{
    public TKNand(int line, int pos, SourceFile sf)
    {
        super ("nand", line, pos, sf);
    }

    @Override
    public Object clone()
    {
      return new TKNand(getLine(), getPos(), getSource());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTKNand(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TKNand text.");
    }
}
