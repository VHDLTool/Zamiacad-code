/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;
import org.zamia.SourceFile;

@SuppressWarnings("nls")
public final class TKConfig extends Token
{
    public TKConfig(int line, int pos, SourceFile sf)
    {
        super ("config", line, pos, sf);
    }

    @Override
    public Object clone()
    {
      return new TKConfig(getLine(), getPos(), getSource());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTKConfig(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TKConfig text.");
    }
}
