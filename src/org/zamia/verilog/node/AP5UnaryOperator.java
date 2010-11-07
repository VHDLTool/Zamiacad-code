/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AP5UnaryOperator extends PUnaryOperator
{
    private TTNand _tNand_;

    public AP5UnaryOperator()
    {
        // Constructor
    }

    public AP5UnaryOperator(
        @SuppressWarnings("hiding") TTNand _tNand_)
    {
        // Constructor
        setTNand(_tNand_);

    }

    @Override
    public Object clone()
    {
        return new AP5UnaryOperator(
            cloneNode(this._tNand_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAP5UnaryOperator(this);
    }

    public TTNand getTNand()
    {
        return this._tNand_;
    }

    public void setTNand(TTNand node)
    {
        if(this._tNand_ != null)
        {
            this._tNand_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tNand_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._tNand_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tNand_ == child)
        {
            this._tNand_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._tNand_ == oldChild)
        {
            setTNand((TTNand) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
