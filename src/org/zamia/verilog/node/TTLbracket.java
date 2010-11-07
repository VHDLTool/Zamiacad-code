/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;
import org.zamia.SourceFile;

@SuppressWarnings("nls")
public final class TTLbracket extends Token
{
    public TTLbracket(int line, int pos, SourceFile sf)
    {
        super ("[", line, pos, sf);
    }

    @Override
    public Object clone()
    {
      return new TTLbracket(getLine(), getPos(), getSource());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTTLbracket(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TTLbracket text.");
    }
}
