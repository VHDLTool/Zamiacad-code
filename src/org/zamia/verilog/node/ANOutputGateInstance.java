/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class ANOutputGateInstance extends PNOutputGateInstance
{
    private PNameOfGateInstance _nameOfGateInstance_;
    private TTLparen _tLparen_;
    private PTerminals _terminals_;
    private TTRparen _tRparen_;

    public ANOutputGateInstance()
    {
        // Constructor
    }

    public ANOutputGateInstance(
        @SuppressWarnings("hiding") PNameOfGateInstance _nameOfGateInstance_,
        @SuppressWarnings("hiding") TTLparen _tLparen_,
        @SuppressWarnings("hiding") PTerminals _terminals_,
        @SuppressWarnings("hiding") TTRparen _tRparen_)
    {
        // Constructor
        setNameOfGateInstance(_nameOfGateInstance_);

        setTLparen(_tLparen_);

        setTerminals(_terminals_);

        setTRparen(_tRparen_);

    }

    @Override
    public Object clone()
    {
        return new ANOutputGateInstance(
            cloneNode(this._nameOfGateInstance_),
            cloneNode(this._tLparen_),
            cloneNode(this._terminals_),
            cloneNode(this._tRparen_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANOutputGateInstance(this);
    }

    public PNameOfGateInstance getNameOfGateInstance()
    {
        return this._nameOfGateInstance_;
    }

    public void setNameOfGateInstance(PNameOfGateInstance node)
    {
        if(this._nameOfGateInstance_ != null)
        {
            this._nameOfGateInstance_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._nameOfGateInstance_ = node;
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

    public PTerminals getTerminals()
    {
        return this._terminals_;
    }

    public void setTerminals(PTerminals node)
    {
        if(this._terminals_ != null)
        {
            this._terminals_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._terminals_ = node;
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

    @Override
    public String toString()
    {
        return ""
            + toString(this._nameOfGateInstance_)
            + toString(this._tLparen_)
            + toString(this._terminals_)
            + toString(this._tRparen_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._nameOfGateInstance_ == child)
        {
            this._nameOfGateInstance_ = null;
            return;
        }

        if(this._tLparen_ == child)
        {
            this._tLparen_ = null;
            return;
        }

        if(this._terminals_ == child)
        {
            this._terminals_ = null;
            return;
        }

        if(this._tRparen_ == child)
        {
            this._tRparen_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._nameOfGateInstance_ == oldChild)
        {
            setNameOfGateInstance((PNameOfGateInstance) newChild);
            return;
        }

        if(this._tLparen_ == oldChild)
        {
            setTLparen((TTLparen) newChild);
            return;
        }

        if(this._terminals_ == oldChild)
        {
            setTerminals((PTerminals) newChild);
            return;
        }

        if(this._tRparen_ == oldChild)
        {
            setTRparen((TTRparen) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
