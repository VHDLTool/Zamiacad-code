/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;
import org.zamia.SourceFile;

@SuppressWarnings("nls")
public final class TTNxor extends Token
{
    public TTNxor(String text, int line, int pos, SourceFile sf)
    {
        super (text, line, pos, sf);
    }

    @Override
    public Object clone()
    {
      return new TTNxor(getText(), getLine(), getPos(), getSource());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTTNxor(this);
    }
}
