/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;
import org.zamia.SourceFile;

@SuppressWarnings("nls")
public final class TKRealtime extends Token
{
    public TKRealtime(int line, int pos, SourceFile sf)
    {
        super ("realtime", line, pos, sf);
    }

    @Override
    public Object clone()
    {
      return new TKRealtime(getLine(), getPos(), getSource());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTKRealtime(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TKRealtime text.");
    }
}
