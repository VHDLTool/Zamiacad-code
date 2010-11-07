/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AP8StatementNoShortIf extends PStatementNoShortIf
{
    private PProceduralTimingControlStatementNsf _proceduralTimingControlStatementNsf_;

    public AP8StatementNoShortIf()
    {
        // Constructor
    }

    public AP8StatementNoShortIf(
        @SuppressWarnings("hiding") PProceduralTimingControlStatementNsf _proceduralTimingControlStatementNsf_)
    {
        // Constructor
        setProceduralTimingControlStatementNsf(_proceduralTimingControlStatementNsf_);

    }

    @Override
    public Object clone()
    {
        return new AP8StatementNoShortIf(
            cloneNode(this._proceduralTimingControlStatementNsf_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAP8StatementNoShortIf(this);
    }

    public PProceduralTimingControlStatementNsf getProceduralTimingControlStatementNsf()
    {
        return this._proceduralTimingControlStatementNsf_;
    }

    public void setProceduralTimingControlStatementNsf(PProceduralTimingControlStatementNsf node)
    {
        if(this._proceduralTimingControlStatementNsf_ != null)
        {
            this._proceduralTimingControlStatementNsf_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._proceduralTimingControlStatementNsf_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._proceduralTimingControlStatementNsf_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._proceduralTimingControlStatementNsf_ == child)
        {
            this._proceduralTimingControlStatementNsf_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._proceduralTimingControlStatementNsf_ == oldChild)
        {
            setProceduralTimingControlStatementNsf((PProceduralTimingControlStatementNsf) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
