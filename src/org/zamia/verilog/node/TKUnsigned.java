/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;
import org.zamia.SourceFile;

@SuppressWarnings("nls")
public final class TKUnsigned extends Token
{
    public TKUnsigned(int line, int pos, SourceFile sf)
    {
        super ("unsigned", line, pos, sf);
    }

    @Override
    public Object clone()
    {
      return new TKUnsigned(getLine(), getPos(), getSource());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTKUnsigned(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TKUnsigned text.");
    }
}
