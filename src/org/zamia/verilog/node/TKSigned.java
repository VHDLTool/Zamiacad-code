/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;
import org.zamia.SourceFile;

@SuppressWarnings("nls")
public final class TKSigned extends Token
{
    public TKSigned(int line, int pos, SourceFile sf)
    {
        super ("signed", line, pos, sf);
    }

    @Override
    public Object clone()
    {
      return new TKSigned(getLine(), getPos(), getSource());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTKSigned(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TKSigned text.");
    }
}
