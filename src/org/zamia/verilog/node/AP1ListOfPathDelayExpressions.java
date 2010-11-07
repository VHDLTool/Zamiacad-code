/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AP1ListOfPathDelayExpressions extends PListOfPathDelayExpressions
{
    private PMintypmaxExpression _mintypmaxExpression_;

    public AP1ListOfPathDelayExpressions()
    {
        // Constructor
    }

    public AP1ListOfPathDelayExpressions(
        @SuppressWarnings("hiding") PMintypmaxExpression _mintypmaxExpression_)
    {
        // Constructor
        setMintypmaxExpression(_mintypmaxExpression_);

    }

    @Override
    public Object clone()
    {
        return new AP1ListOfPathDelayExpressions(
            cloneNode(this._mintypmaxExpression_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAP1ListOfPathDelayExpressions(this);
    }

    public PMintypmaxExpression getMintypmaxExpression()
    {
        return this._mintypmaxExpression_;
    }

    public void setMintypmaxExpression(PMintypmaxExpression node)
    {
        if(this._mintypmaxExpression_ != null)
        {
            this._mintypmaxExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mintypmaxExpression_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._mintypmaxExpression_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._mintypmaxExpression_ == child)
        {
            this._mintypmaxExpression_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._mintypmaxExpression_ == oldChild)
        {
            setMintypmaxExpression((PMintypmaxExpression) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
