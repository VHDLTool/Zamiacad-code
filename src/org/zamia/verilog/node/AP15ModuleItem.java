/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AP15ModuleItem extends PModuleItem
{
    private PSpecparamDeclaration _specparamDeclaration_;

    public AP15ModuleItem()
    {
        // Constructor
    }

    public AP15ModuleItem(
        @SuppressWarnings("hiding") PSpecparamDeclaration _specparamDeclaration_)
    {
        // Constructor
        setSpecparamDeclaration(_specparamDeclaration_);

    }

    @Override
    public Object clone()
    {
        return new AP15ModuleItem(
            cloneNode(this._specparamDeclaration_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAP15ModuleItem(this);
    }

    public PSpecparamDeclaration getSpecparamDeclaration()
    {
        return this._specparamDeclaration_;
    }

    public void setSpecparamDeclaration(PSpecparamDeclaration node)
    {
        if(this._specparamDeclaration_ != null)
        {
            this._specparamDeclaration_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._specparamDeclaration_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._specparamDeclaration_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._specparamDeclaration_ == child)
        {
            this._specparamDeclaration_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._specparamDeclaration_ == oldChild)
        {
            setSpecparamDeclaration((PSpecparamDeclaration) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
