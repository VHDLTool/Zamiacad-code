/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;
import org.zamia.SourceFile;

@SuppressWarnings("nls")
public final class TKDefault extends Token
{
    public TKDefault(int line, int pos, SourceFile sf)
    {
        super ("default", line, pos, sf);
    }

    @Override
    public Object clone()
    {
      return new TKDefault(getLine(), getPos(), getSource());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTKDefault(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TKDefault text.");
    }
}
