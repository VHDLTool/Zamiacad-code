/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AP0FunctionPortList extends PFunctionPortList
{
    private PFunctionPortListItem _functionPortListItem_;
    private TTComma _tComma_;
    private PFunctionPortList _functionPortList_;

    public AP0FunctionPortList()
    {
        // Constructor
    }

    public AP0FunctionPortList(
        @SuppressWarnings("hiding") PFunctionPortListItem _functionPortListItem_,
        @SuppressWarnings("hiding") TTComma _tComma_,
        @SuppressWarnings("hiding") PFunctionPortList _functionPortList_)
    {
        // Constructor
        setFunctionPortListItem(_functionPortListItem_);

        setTComma(_tComma_);

        setFunctionPortList(_functionPortList_);

    }

    @Override
    public Object clone()
    {
        return new AP0FunctionPortList(
            cloneNode(this._functionPortListItem_),
            cloneNode(this._tComma_),
            cloneNode(this._functionPortList_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAP0FunctionPortList(this);
    }

    public PFunctionPortListItem getFunctionPortListItem()
    {
        return this._functionPortListItem_;
    }

    public void setFunctionPortListItem(PFunctionPortListItem node)
    {
        if(this._functionPortListItem_ != null)
        {
            this._functionPortListItem_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._functionPortListItem_ = node;
    }

    public TTComma getTComma()
    {
        return this._tComma_;
    }

    public void setTComma(TTComma node)
    {
        if(this._tComma_ != null)
        {
            this._tComma_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tComma_ = node;
    }

    public PFunctionPortList getFunctionPortList()
    {
        return this._functionPortList_;
    }

    public void setFunctionPortList(PFunctionPortList node)
    {
        if(this._functionPortList_ != null)
        {
            this._functionPortList_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._functionPortList_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._functionPortListItem_)
            + toString(this._tComma_)
            + toString(this._functionPortList_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._functionPortListItem_ == child)
        {
            this._functionPortListItem_ = null;
            return;
        }

        if(this._tComma_ == child)
        {
            this._tComma_ = null;
            return;
        }

        if(this._functionPortList_ == child)
        {
            this._functionPortList_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._functionPortListItem_ == oldChild)
        {
            setFunctionPortListItem((PFunctionPortListItem) newChild);
            return;
        }

        if(this._tComma_ == oldChild)
        {
            setTComma((TTComma) newChild);
            return;
        }

        if(this._functionPortList_ == oldChild)
        {
            setFunctionPortList((PFunctionPortList) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
