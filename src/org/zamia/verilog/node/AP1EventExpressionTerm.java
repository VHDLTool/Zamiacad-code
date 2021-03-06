/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AP1EventExpressionTerm extends PEventExpressionTerm
{
    private TKPosedge _kPosedge_;
    private PExpression _expression_;

    public AP1EventExpressionTerm()
    {
        // Constructor
    }

    public AP1EventExpressionTerm(
        @SuppressWarnings("hiding") TKPosedge _kPosedge_,
        @SuppressWarnings("hiding") PExpression _expression_)
    {
        // Constructor
        setKPosedge(_kPosedge_);

        setExpression(_expression_);

    }

    @Override
    public Object clone()
    {
        return new AP1EventExpressionTerm(
            cloneNode(this._kPosedge_),
            cloneNode(this._expression_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAP1EventExpressionTerm(this);
    }

    public TKPosedge getKPosedge()
    {
        return this._kPosedge_;
    }

    public void setKPosedge(TKPosedge node)
    {
        if(this._kPosedge_ != null)
        {
            this._kPosedge_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._kPosedge_ = node;
    }

    public PExpression getExpression()
    {
        return this._expression_;
    }

    public void setExpression(PExpression node)
    {
        if(this._expression_ != null)
        {
            this._expression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._kPosedge_)
            + toString(this._expression_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._kPosedge_ == child)
        {
            this._kPosedge_ = null;
            return;
        }

        if(this._expression_ == child)
        {
            this._expression_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._kPosedge_ == oldChild)
        {
            setKPosedge((TKPosedge) newChild);
            return;
        }

        if(this._expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
