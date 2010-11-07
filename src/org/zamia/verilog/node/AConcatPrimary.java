/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AConcatPrimary extends PPrimary
{
    private PConcatenation _concatenation_;

    public AConcatPrimary()
    {
        // Constructor
    }

    public AConcatPrimary(
        @SuppressWarnings("hiding") PConcatenation _concatenation_)
    {
        // Constructor
        setConcatenation(_concatenation_);

    }

    @Override
    public Object clone()
    {
        return new AConcatPrimary(
            cloneNode(this._concatenation_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAConcatPrimary(this);
    }

    public PConcatenation getConcatenation()
    {
        return this._concatenation_;
    }

    public void setConcatenation(PConcatenation node)
    {
        if(this._concatenation_ != null)
        {
            this._concatenation_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._concatenation_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._concatenation_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._concatenation_ == child)
        {
            this._concatenation_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._concatenation_ == oldChild)
        {
            setConcatenation((PConcatenation) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
