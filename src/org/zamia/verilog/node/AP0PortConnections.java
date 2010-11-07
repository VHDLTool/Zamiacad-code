/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AP0PortConnections extends PPortConnections
{
    private PPortConnection _portConnection_;

    public AP0PortConnections()
    {
        // Constructor
    }

    public AP0PortConnections(
        @SuppressWarnings("hiding") PPortConnection _portConnection_)
    {
        // Constructor
        setPortConnection(_portConnection_);

    }

    @Override
    public Object clone()
    {
        return new AP0PortConnections(
            cloneNode(this._portConnection_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAP0PortConnections(this);
    }

    public PPortConnection getPortConnection()
    {
        return this._portConnection_;
    }

    public void setPortConnection(PPortConnection node)
    {
        if(this._portConnection_ != null)
        {
            this._portConnection_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._portConnection_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._portConnection_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._portConnection_ == child)
        {
            this._portConnection_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._portConnection_ == oldChild)
        {
            setPortConnection((PPortConnection) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
