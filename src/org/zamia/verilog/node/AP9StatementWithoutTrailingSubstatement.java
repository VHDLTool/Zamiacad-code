/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AP9StatementWithoutTrailingSubstatement extends PStatementWithoutTrailingSubstatement
{
    private PTaskEnable _taskEnable_;

    public AP9StatementWithoutTrailingSubstatement()
    {
        // Constructor
    }

    public AP9StatementWithoutTrailingSubstatement(
        @SuppressWarnings("hiding") PTaskEnable _taskEnable_)
    {
        // Constructor
        setTaskEnable(_taskEnable_);

    }

    @Override
    public Object clone()
    {
        return new AP9StatementWithoutTrailingSubstatement(
            cloneNode(this._taskEnable_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAP9StatementWithoutTrailingSubstatement(this);
    }

    public PTaskEnable getTaskEnable()
    {
        return this._taskEnable_;
    }

    public void setTaskEnable(PTaskEnable node)
    {
        if(this._taskEnable_ != null)
        {
            this._taskEnable_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._taskEnable_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._taskEnable_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._taskEnable_ == child)
        {
            this._taskEnable_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._taskEnable_ == oldChild)
        {
            setTaskEnable((PTaskEnable) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
