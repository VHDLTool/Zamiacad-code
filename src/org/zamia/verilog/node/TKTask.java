/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;
import org.zamia.SourceFile;

@SuppressWarnings("nls")
public final class TKTask extends Token
{
    public TKTask(int line, int pos, SourceFile sf)
    {
        super ("task", line, pos, sf);
    }

    @Override
    public Object clone()
    {
      return new TKTask(getLine(), getPos(), getSource());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTKTask(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TKTask text.");
    }
}
