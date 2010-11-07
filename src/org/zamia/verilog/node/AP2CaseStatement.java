/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import java.util.*;
import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AP2CaseStatement extends PCaseStatement
{
    private TKCasex _kCasex_;
    private TTLparen _tLparen_;
    private PExpression _expression_;
    private TTRparen _tRparen_;
    private PCaseItem _i1_;
    private final LinkedList<PCaseItem> _i2_ = new LinkedList<PCaseItem>();
    private TKEndcase _kEndcase_;

    public AP2CaseStatement()
    {
        // Constructor
    }

    public AP2CaseStatement(
        @SuppressWarnings("hiding") TKCasex _kCasex_,
        @SuppressWarnings("hiding") TTLparen _tLparen_,
        @SuppressWarnings("hiding") PExpression _expression_,
        @SuppressWarnings("hiding") TTRparen _tRparen_,
        @SuppressWarnings("hiding") PCaseItem _i1_,
        @SuppressWarnings("hiding") List<PCaseItem> _i2_,
        @SuppressWarnings("hiding") TKEndcase _kEndcase_)
    {
        // Constructor
        setKCasex(_kCasex_);

        setTLparen(_tLparen_);

        setExpression(_expression_);

        setTRparen(_tRparen_);

        setI1(_i1_);

        setI2(_i2_);

        setKEndcase(_kEndcase_);

    }

    @Override
    public Object clone()
    {
        return new AP2CaseStatement(
            cloneNode(this._kCasex_),
            cloneNode(this._tLparen_),
            cloneNode(this._expression_),
            cloneNode(this._tRparen_),
            cloneNode(this._i1_),
            cloneList(this._i2_),
            cloneNode(this._kEndcase_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAP2CaseStatement(this);
    }

    public TKCasex getKCasex()
    {
        return this._kCasex_;
    }

    public void setKCasex(TKCasex node)
    {
        if(this._kCasex_ != null)
        {
            this._kCasex_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._kCasex_ = node;
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

    public PCaseItem getI1()
    {
        return this._i1_;
    }

    public void setI1(PCaseItem node)
    {
        if(this._i1_ != null)
        {
            this._i1_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._i1_ = node;
    }

    public LinkedList<PCaseItem> getI2()
    {
        return this._i2_;
    }

    public void setI2(List<PCaseItem> list)
    {
        this._i2_.clear();
        this._i2_.addAll(list);
        for(PCaseItem e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    public TKEndcase getKEndcase()
    {
        return this._kEndcase_;
    }

    public void setKEndcase(TKEndcase node)
    {
        if(this._kEndcase_ != null)
        {
            this._kEndcase_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._kEndcase_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._kCasex_)
            + toString(this._tLparen_)
            + toString(this._expression_)
            + toString(this._tRparen_)
            + toString(this._i1_)
            + toString(this._i2_)
            + toString(this._kEndcase_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._kCasex_ == child)
        {
            this._kCasex_ = null;
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

        if(this._i1_ == child)
        {
            this._i1_ = null;
            return;
        }

        if(this._i2_.remove(child))
        {
            return;
        }

        if(this._kEndcase_ == child)
        {
            this._kEndcase_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._kCasex_ == oldChild)
        {
            setKCasex((TKCasex) newChild);
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

        if(this._i1_ == oldChild)
        {
            setI1((PCaseItem) newChild);
            return;
        }

        for(ListIterator<PCaseItem> i = this._i2_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PCaseItem) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._kEndcase_ == oldChild)
        {
            setKEndcase((TKEndcase) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
