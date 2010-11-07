/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class ABinNumber extends PNumber
{
    private TBinaryNumber _binaryNumber_;

    public ABinNumber()
    {
        // Constructor
    }

    public ABinNumber(
        @SuppressWarnings("hiding") TBinaryNumber _binaryNumber_)
    {
        // Constructor
        setBinaryNumber(_binaryNumber_);

    }

    @Override
    public Object clone()
    {
        return new ABinNumber(
            cloneNode(this._binaryNumber_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseABinNumber(this);
    }

    public TBinaryNumber getBinaryNumber()
    {
        return this._binaryNumber_;
    }

    public void setBinaryNumber(TBinaryNumber node)
    {
        if(this._binaryNumber_ != null)
        {
            this._binaryNumber_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._binaryNumber_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._binaryNumber_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._binaryNumber_ == child)
        {
            this._binaryNumber_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._binaryNumber_ == oldChild)
        {
            setBinaryNumber((TBinaryNumber) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
