/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;
import org.zamia.SourceFile;

@SuppressWarnings("nls")
public final class TKStimeskew extends Token
{
    public TKStimeskew(int line, int pos, SourceFile sf)
    {
        super ("$timeskew", line, pos, sf);
    }

    @Override
    public Object clone()
    {
      return new TKStimeskew(getLine(), getPos(), getSource());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTKStimeskew(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TKStimeskew text.");
    }
}
