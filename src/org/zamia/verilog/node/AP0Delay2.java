/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AP0Delay2 extends PDelay2
{
    private TTHash _tHash_;
    private PDelayValue _delayValue_;

    public AP0Delay2()
    {
        // Constructor
    }

    public AP0Delay2(
        @SuppressWarnings("hiding") TTHash _tHash_,
        @SuppressWarnings("hiding") PDelayValue _delayValue_)
    {
        // Constructor
        setTHash(_tHash_);

        setDelayValue(_delayValue_);

    }

    @Override
    public Object clone()
    {
        return new AP0Delay2(
            cloneNode(this._tHash_),
            cloneNode(this._delayValue_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAP0Delay2(this);
    }

    public TTHash getTHash()
    {
        return this._tHash_;
    }

    public void setTHash(TTHash node)
    {
        if(this._tHash_ != null)
        {
            this._tHash_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tHash_ = node;
    }

    public PDelayValue getDelayValue()
    {
        return this._delayValue_;
    }

    public void setDelayValue(PDelayValue node)
    {
        if(this._delayValue_ != null)
        {
            this._delayValue_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._delayValue_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._tHash_)
            + toString(this._delayValue_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tHash_ == child)
        {
            this._tHash_ = null;
            return;
        }

        if(this._delayValue_ == child)
        {
            this._delayValue_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._tHash_ == oldChild)
        {
            setTHash((TTHash) newChild);
            return;
        }

        if(this._delayValue_ == oldChild)
        {
            setDelayValue((PDelayValue) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
