/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AWaitStatementNsf extends PWaitStatementNsf
{
    private TKWait _kWait_;
    private TTLparen _tLparen_;
    private PExpression _expression_;
    private TTRparen _tRparen_;
    private PStatementNsfOrNull _statementNsfOrNull_;

    public AWaitStatementNsf()
    {
        // Constructor
    }

    public AWaitStatementNsf(
        @SuppressWarnings("hiding") TKWait _kWait_,
        @SuppressWarnings("hiding") TTLparen _tLparen_,
        @SuppressWarnings("hiding") PExpression _expression_,
        @SuppressWarnings("hiding") TTRparen _tRparen_,
        @SuppressWarnings("hiding") PStatementNsfOrNull _statementNsfOrNull_)
    {
        // Constructor
        setKWait(_kWait_);

        setTLparen(_tLparen_);

        setExpression(_expression_);

        setTRparen(_tRparen_);

        setStatementNsfOrNull(_statementNsfOrNull_);

    }

    @Override
    public Object clone()
    {
        return new AWaitStatementNsf(
            cloneNode(this._kWait_),
            cloneNode(this._tLparen_),
            cloneNode(this._expression_),
            cloneNode(this._tRparen_),
            cloneNode(this._statementNsfOrNull_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAWaitStatementNsf(this);
    }

    public TKWait getKWait()
    {
        return this._kWait_;
    }

    public void setKWait(TKWait node)
    {
        if(this._kWait_ != null)
        {
            this._kWait_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._kWait_ = node;
    }

    public TTLparen getTLparen()
    {
        return this._tLparen_;
    }

    public void setTLparen(TTLparen node)
    {
        if(this._tLparen_ != null)
        {
            this._tLparen_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tLparen_ = node;
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

    public TTRparen getTRparen()
    {
        return this._tRparen_;
    }

    public void setTRparen(TTRparen node)
    {
        if(this._tRparen_ != null)
        {
            this._tRparen_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tRparen_ = node;
    }

    public PStatementNsfOrNull getStatementNsfOrNull()
    {
        return this._statementNsfOrNull_;
    }

    public void setStatementNsfOrNull(PStatementNsfOrNull node)
    {
        if(this._statementNsfOrNull_ != null)
        {
            this._statementNsfOrNull_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._statementNsfOrNull_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._kWait_)
            + toString(this._tLparen_)
            + toString(this._expression_)
            + toString(this._tRparen_)
            + toString(this._statementNsfOrNull_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._kWait_ == child)
        {
            this._kWait_ = null;
            return;
        }

        if(this._tLparen_ == child)
        {
            this._tLparen_ = null;
            return;
        }

        if(this._expression_ == child)
        {
            this._expression_ = null;
            return;
        }

        if(this._tRparen_ == child)
        {
            this._tRparen_ = null;
            return;
        }

        if(this._statementNsfOrNull_ == child)
        {
            this._statementNsfOrNull_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._kWait_ == oldChild)
        {
            setKWait((TKWait) newChild);
            return;
        }

        if(this._tLparen_ == oldChild)
        {
            setTLparen((TTLparen) newChild);
            return;
        }

        if(this._expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
            return;
        }

        if(this._tRparen_ == oldChild)
        {
            setTRparen((TTRparen) newChild);
            return;
        }

        if(this._statementNsfOrNull_ == oldChild)
        {
            setStatementNsfOrNull((PStatementNsfOrNull) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
