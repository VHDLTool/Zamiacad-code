/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AModulePathConditionalExpression extends PModulePathConditionalExpression
{
    private PModulePathExpression1 _e1_;
    private TTQuestion _tQuestion_;
    private PModulePathExpression _e2_;
    private TTColon _tColon_;
    private PModulePathExpression _e3_;

    public AModulePathConditionalExpression()
    {
        // Constructor
    }

    public AModulePathConditionalExpression(
        @SuppressWarnings("hiding") PModulePathExpression1 _e1_,
        @SuppressWarnings("hiding") TTQuestion _tQuestion_,
        @SuppressWarnings("hiding") PModulePathExpression _e2_,
        @SuppressWarnings("hiding") TTColon _tColon_,
        @SuppressWarnings("hiding") PModulePathExpression _e3_)
    {
        // Constructor
        setE1(_e1_);

        setTQuestion(_tQuestion_);

        setE2(_e2_);

        setTColon(_tColon_);

        setE3(_e3_);

    }

    @Override
    public Object clone()
    {
        return new AModulePathConditionalExpression(
            cloneNode(this._e1_),
            cloneNode(this._tQuestion_),
            cloneNode(this._e2_),
            cloneNode(this._tColon_),
            cloneNode(this._e3_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAModulePathConditionalExpression(this);
    }

    public PModulePathExpression1 getE1()
    {
        return this._e1_;
    }

    public void setE1(PModulePathExpression1 node)
    {
        if(this._e1_ != null)
        {
            this._e1_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._e1_ = node;
    }

    public TTQuestion getTQuestion()
    {
        return this._tQuestion_;
    }

    public void setTQuestion(TTQuestion node)
    {
        if(this._tQuestion_ != null)
        {
            this._tQuestion_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tQuestion_ = node;
    }

    public PModulePathExpression getE2()
    {
        return this._e2_;
    }

    public void setE2(PModulePathExpression node)
    {
        if(this._e2_ != null)
        {
            this._e2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._e2_ = node;
    }

    public TTColon getTColon()
    {
        return this._tColon_;
    }

    public void setTColon(TTColon node)
    {
        if(this._tColon_ != null)
        {
            this._tColon_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tColon_ = node;
    }

    public PModulePathExpression getE3()
    {
        return this._e3_;
    }

    public void setE3(PModulePathExpression node)
    {
        if(this._e3_ != null)
        {
            this._e3_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._e3_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._e1_)
            + toString(this._tQuestion_)
            + toString(this._e2_)
            + toString(this._tColon_)
            + toString(this._e3_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._e1_ == child)
        {
            this._e1_ = null;
            return;
        }

        if(this._tQuestion_ == child)
        {
            this._tQuestion_ = null;
            return;
        }

        if(this._e2_ == child)
        {
            this._e2_ = null;
            return;
        }

        if(this._tColon_ == child)
        {
            this._tColon_ = null;
            return;
        }

        if(this._e3_ == child)
        {
            this._e3_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._e1_ == oldChild)
        {
            setE1((PModulePathExpression1) newChild);
            return;
        }

        if(this._tQuestion_ == oldChild)
        {
            setTQuestion((TTQuestion) newChild);
            return;
        }

        if(this._e2_ == oldChild)
        {
            setE2((PModulePathExpression) newChild);
            return;
        }

        if(this._tColon_ == oldChild)
        {
            setTColon((TTColon) newChild);
            return;
        }

        if(this._e3_ == oldChild)
        {
            setE3((PModulePathExpression) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
