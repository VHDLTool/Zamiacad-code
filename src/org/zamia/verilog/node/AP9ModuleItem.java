/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AP9ModuleItem extends PModuleItem
{
    private PAlwaysConstruct _alwaysConstruct_;

    public AP9ModuleItem()
    {
        // Constructor
    }

    public AP9ModuleItem(
        @SuppressWarnings("hiding") PAlwaysConstruct _alwaysConstruct_)
    {
        // Constructor
        setAlwaysConstruct(_alwaysConstruct_);

    }

    @Override
    public Object clone()
    {
        return new AP9ModuleItem(
            cloneNode(this._alwaysConstruct_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAP9ModuleItem(this);
    }

    public PAlwaysConstruct getAlwaysConstruct()
    {
        return this._alwaysConstruct_;
    }

    public void setAlwaysConstruct(PAlwaysConstruct node)
    {
        if(this._alwaysConstruct_ != null)
        {
            this._alwaysConstruct_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._alwaysConstruct_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._alwaysConstruct_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._alwaysConstruct_ == child)
        {
            this._alwaysConstruct_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._alwaysConstruct_ == oldChild)
        {
            setAlwaysConstruct((PAlwaysConstruct) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
