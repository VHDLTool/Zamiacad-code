/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AP4EventTriggerExpr extends PEventTriggerExpr
{
    private TTLbracket _tLbracket_;
    private PExpression _expression_;
    private TTRbracket _tRbracket_;
    private PEventTriggerExpr _eventTriggerExpr_;

    public AP4EventTriggerExpr()
    {
        // Constructor
    }

    public AP4EventTriggerExpr(
        @SuppressWarnings("hiding") TTLbracket _tLbracket_,
        @SuppressWarnings("hiding") PExpression _expression_,
        @SuppressWarnings("hiding") TTRbracket _tRbracket_,
        @SuppressWarnings("hiding") PEventTriggerExpr _eventTriggerExpr_)
    {
        // Constructor
        setTLbracket(_tLbracket_);

        setExpression(_expression_);

        setTRbracket(_tRbracket_);

        setEventTriggerExpr(_eventTriggerExpr_);

    }

    @Override
    public Object clone()
    {
        return new AP4EventTriggerExpr(
            cloneNode(this._tLbracket_),
            cloneNode(this._expression_),
            cloneNode(this._tRbracket_),
            cloneNode(this._eventTriggerExpr_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAP4EventTriggerExpr(this);
    }

    public TTLbracket getTLbracket()
    {
        return this._tLbracket_;
    }

    public void setTLbracket(TTLbracket node)
    {
        if(this._tLbracket_ != null)
        {
            this._tLbracket_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tLbracket_ = node;
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

    public TTRbracket getTRbracket()
    {
        return this._tRbracket_;
    }

    public void setTRbracket(TTRbracket node)
    {
        if(this._tRbracket_ != null)
        {
            this._tRbracket_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tRbracket_ = node;
    }

    public PEventTriggerExpr getEventTriggerExpr()
    {
        return this._eventTriggerExpr_;
    }

    public void setEventTriggerExpr(PEventTriggerExpr node)
    {
        if(this._eventTriggerExpr_ != null)
        {
            this._eventTriggerExpr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._eventTriggerExpr_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._tLbracket_)
            + toString(this._expression_)
            + toString(this._tRbracket_)
            + toString(this._eventTriggerExpr_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tLbracket_ == child)
        {
            this._tLbracket_ = null;
            return;
        }

        if(this._expression_ == child)
        {
            this._expression_ = null;
            return;
        }

        if(this._tRbracket_ == child)
        {
            this._tRbracket_ = null;
            return;
        }

        if(this._eventTriggerExpr_ == child)
        {
            this._eventTriggerExpr_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._tLbracket_ == oldChild)
        {
            setTLbracket((TTLbracket) newChild);
            return;
        }

        if(this._expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
            return;
        }

        if(this._tRbracket_ == oldChild)
        {
            setTRbracket((TTRbracket) newChild);
            return;
        }

        if(this._eventTriggerExpr_ == oldChild)
        {
            setEventTriggerExpr((PEventTriggerExpr) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
