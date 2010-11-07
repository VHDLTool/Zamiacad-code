/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AInitialConstruct extends PInitialConstruct
{
    private TKInitial _kInitial_;
    private PStatement _statement_;

    public AInitialConstruct()
    {
        // Constructor
    }

    public AInitialConstruct(
        @SuppressWarnings("hiding") TKInitial _kInitial_,
        @SuppressWarnings("hiding") PStatement _statement_)
    {
        // Constructor
        setKInitial(_kInitial_);

        setStatement(_statement_);

    }

    @Override
    public Object clone()
    {
        return new AInitialConstruct(
            cloneNode(this._kInitial_),
            cloneNode(this._statement_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAInitialConstruct(this);
    }

    public TKInitial getKInitial()
    {
        return this._kInitial_;
    }

    public void setKInitial(TKInitial node)
    {
        if(this._kInitial_ != null)
        {
            this._kInitial_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._kInitial_ = node;
    }

    public PStatement getStatement()
    {
        return this._statement_;
    }

    public void setStatement(PStatement node)
    {
        if(this._statement_ != null)
        {
            this._statement_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._statement_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._kInitial_)
            + toString(this._statement_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._kInitial_ == child)
        {
            this._kInitial_ = null;
            return;
        }

        if(this._statement_ == child)
        {
            this._statement_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._kInitial_ == oldChild)
        {
            setKInitial((TKInitial) newChild);
            return;
        }

        if(this._statement_ == oldChild)
        {
            setStatement((PStatement) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
