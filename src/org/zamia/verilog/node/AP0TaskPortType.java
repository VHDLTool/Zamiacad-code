/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AP0TaskPortType extends PTaskPortType
{
    private TKInteger _kInteger_;

    public AP0TaskPortType()
    {
        // Constructor
    }

    public AP0TaskPortType(
        @SuppressWarnings("hiding") TKInteger _kInteger_)
    {
        // Constructor
        setKInteger(_kInteger_);

    }

    @Override
    public Object clone()
    {
        return new AP0TaskPortType(
            cloneNode(this._kInteger_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAP0TaskPortType(this);
    }

    public TKInteger getKInteger()
    {
        return this._kInteger_;
    }

    public void setKInteger(TKInteger node)
    {
        if(this._kInteger_ != null)
        {
            this._kInteger_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._kInteger_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._kInteger_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._kInteger_ == child)
        {
            this._kInteger_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._kInteger_ == oldChild)
        {
            setKInteger((TKInteger) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
