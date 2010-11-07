/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;
import org.zamia.SourceFile;

@SuppressWarnings("nls")
public final class TKScalared extends Token
{
    public TKScalared(int line, int pos, SourceFile sf)
    {
        super ("scalared", line, pos, sf);
    }

    @Override
    public Object clone()
    {
      return new TKScalared(getLine(), getPos(), getSource());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTKScalared(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TKScalared text.");
    }
}
