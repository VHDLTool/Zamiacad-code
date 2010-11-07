/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AP1PathDeclaration extends PPathDeclaration
{
    private PEdgeSensitivePathDeclaration _edgeSensitivePathDeclaration_;
    private TTSemicolon _tSemicolon_;

    public AP1PathDeclaration()
    {
        // Constructor
    }

    public AP1PathDeclaration(
        @SuppressWarnings("hiding") PEdgeSensitivePathDeclaration _edgeSensitivePathDeclaration_,
        @SuppressWarnings("hiding") TTSemicolon _tSemicolon_)
    {
        // Constructor
        setEdgeSensitivePathDeclaration(_edgeSensitivePathDeclaration_);

        setTSemicolon(_tSemicolon_);

    }

    @Override
    public Object clone()
    {
        return new AP1PathDeclaration(
            cloneNode(this._edgeSensitivePathDeclaration_),
            cloneNode(this._tSemicolon_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAP1PathDeclaration(this);
    }

    public PEdgeSensitivePathDeclaration getEdgeSensitivePathDeclaration()
    {
        return this._edgeSensitivePathDeclaration_;
    }

    public void setEdgeSensitivePathDeclaration(PEdgeSensitivePathDeclaration node)
    {
        if(this._edgeSensitivePathDeclaration_ != null)
        {
            this._edgeSensitivePathDeclaration_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._edgeSensitivePathDeclaration_ = node;
    }

    public TTSemicolon getTSemicolon()
    {
        return this._tSemicolon_;
    }

    public void setTSemicolon(TTSemicolon node)
    {
        if(this._tSemicolon_ != null)
        {
            this._tSemicolon_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tSemicolon_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._edgeSensitivePathDeclaration_)
            + toString(this._tSemicolon_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._edgeSensitivePathDeclaration_ == child)
        {
            this._edgeSensitivePathDeclaration_ = null;
            return;
        }

        if(this._tSemicolon_ == child)
        {
            this._tSemicolon_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._edgeSensitivePathDeclaration_ == oldChild)
        {
            setEdgeSensitivePathDeclaration((PEdgeSensitivePathDeclaration) newChild);
            return;
        }

        if(this._tSemicolon_ == oldChild)
        {
            setTSemicolon((TTSemicolon) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
