/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AP1ProceduralTimingControl extends PProceduralTimingControl
{
    private PEventControl _eventControl_;

    public AP1ProceduralTimingControl()
    {
        // Constructor
    }

    public AP1ProceduralTimingControl(
        @SuppressWarnings("hiding") PEventControl _eventControl_)
    {
        // Constructor
        setEventControl(_eventControl_);

    }

    @Override
    public Object clone()
    {
        return new AP1ProceduralTimingControl(
            cloneNode(this._eventControl_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAP1ProceduralTimingControl(this);
    }

    public PEventControl getEventControl()
    {
        return this._eventControl_;
    }

    public void setEventControl(PEventControl node)
    {
        if(this._eventControl_ != null)
        {
            this._eventControl_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._eventControl_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._eventControl_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._eventControl_ == child)
        {
            this._eventControl_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._eventControl_ == oldChild)
        {
            setEventControl((PEventControl) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
