/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AP2BinaryModulePathOperator extends PBinaryModulePathOperator
{
    private TTLand _tLand_;

    public AP2BinaryModulePathOperator()
    {
        // Constructor
    }

    public AP2BinaryModulePathOperator(
        @SuppressWarnings("hiding") TTLand _tLand_)
    {
        // Constructor
        setTLand(_tLand_);

    }

    @Override
    public Object clone()
    {
        return new AP2BinaryModulePathOperator(
            cloneNode(this._tLand_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAP2BinaryModulePathOperator(this);
    }

    public TTLand getTLand()
    {
        return this._tLand_;
    }

    public void setTLand(TTLand node)
    {
        if(this._tLand_ != null)
        {
            this._tLand_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tLand_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._tLand_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tLand_ == child)
        {
            this._tLand_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._tLand_ == oldChild)
        {
            setTLand((TTLand) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
