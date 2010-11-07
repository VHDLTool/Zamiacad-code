/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AP2UnaryModulePathOperator extends PUnaryModulePathOperator
{
    private TTAnd _tAnd_;

    public AP2UnaryModulePathOperator()
    {
        // Constructor
    }

    public AP2UnaryModulePathOperator(
        @SuppressWarnings("hiding") TTAnd _tAnd_)
    {
        // Constructor
        setTAnd(_tAnd_);

    }

    @Override
    public Object clone()
    {
        return new AP2UnaryModulePathOperator(
            cloneNode(this._tAnd_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAP2UnaryModulePathOperator(this);
    }

    public TTAnd getTAnd()
    {
        return this._tAnd_;
    }

    public void setTAnd(TTAnd node)
    {
        if(this._tAnd_ != null)
        {
            this._tAnd_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tAnd_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._tAnd_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tAnd_ == child)
        {
            this._tAnd_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._tAnd_ == oldChild)
        {
            setTAnd((TTAnd) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
