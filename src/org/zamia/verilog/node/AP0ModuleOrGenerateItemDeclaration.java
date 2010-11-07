/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AP0ModuleOrGenerateItemDeclaration extends PModuleOrGenerateItemDeclaration
{
    private PNetDeclaration _netDeclaration_;

    public AP0ModuleOrGenerateItemDeclaration()
    {
        // Constructor
    }

    public AP0ModuleOrGenerateItemDeclaration(
        @SuppressWarnings("hiding") PNetDeclaration _netDeclaration_)
    {
        // Constructor
        setNetDeclaration(_netDeclaration_);

    }

    @Override
    public Object clone()
    {
        return new AP0ModuleOrGenerateItemDeclaration(
            cloneNode(this._netDeclaration_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAP0ModuleOrGenerateItemDeclaration(this);
    }

    public PNetDeclaration getNetDeclaration()
    {
        return this._netDeclaration_;
    }

    public void setNetDeclaration(PNetDeclaration node)
    {
        if(this._netDeclaration_ != null)
        {
            this._netDeclaration_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._netDeclaration_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._netDeclaration_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._netDeclaration_ == child)
        {
            this._netDeclaration_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._netDeclaration_ == oldChild)
        {
            setNetDeclaration((PNetDeclaration) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
