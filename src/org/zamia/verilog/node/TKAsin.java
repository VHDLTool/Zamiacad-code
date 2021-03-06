/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;
import org.zamia.SourceFile;

@SuppressWarnings("nls")
public final class TKAsin extends Token
{
    public TKAsin(int line, int pos, SourceFile sf)
    {
        super ("asin", line, pos, sf);
    }

    @Override
    public Object clone()
    {
      return new TKAsin(getLine(), getPos(), getSource());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTKAsin(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TKAsin text.");
    }
}
