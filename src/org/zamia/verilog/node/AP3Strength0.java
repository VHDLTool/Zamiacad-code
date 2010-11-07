/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AP3Strength0 extends PStrength0
{
    private TKWeak0 _kWeak0_;

    public AP3Strength0()
    {
        // Constructor
    }

    public AP3Strength0(
        @SuppressWarnings("hiding") TKWeak0 _kWeak0_)
    {
        // Constructor
        setKWeak0(_kWeak0_);

    }

    @Override
    public Object clone()
    {
        return new AP3Strength0(
            cloneNode(this._kWeak0_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAP3Strength0(this);
    }

    public TKWeak0 getKWeak0()
    {
        return this._kWeak0_;
    }

    public void setKWeak0(TKWeak0 node)
    {
        if(this._kWeak0_ != null)
        {
            this._kWeak0_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._kWeak0_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._kWeak0_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._kWeak0_ == child)
        {
            this._kWeak0_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._kWeak0_ == oldChild)
        {
            setKWeak0((TKWeak0) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
