/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AP3BlockItemDeclaration extends PBlockItemDeclaration
{
    private TKReal _kReal_;
    private PListOfBlockRealIdentifiers _listOfBlockRealIdentifiers_;
    private TTSemicolon _tSemicolon_;

    public AP3BlockItemDeclaration()
    {
        // Constructor
    }

    public AP3BlockItemDeclaration(
        @SuppressWarnings("hiding") TKReal _kReal_,
        @SuppressWarnings("hiding") PListOfBlockRealIdentifiers _listOfBlockRealIdentifiers_,
        @SuppressWarnings("hiding") TTSemicolon _tSemicolon_)
    {
        // Constructor
        setKReal(_kReal_);

        setListOfBlockRealIdentifiers(_listOfBlockRealIdentifiers_);

        setTSemicolon(_tSemicolon_);

    }

    @Override
    public Object clone()
    {
        return new AP3BlockItemDeclaration(
            cloneNode(this._kReal_),
            cloneNode(this._listOfBlockRealIdentifiers_),
            cloneNode(this._tSemicolon_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAP3BlockItemDeclaration(this);
    }

    public TKReal getKReal()
    {
        return this._kReal_;
    }

    public void setKReal(TKReal node)
    {
        if(this._kReal_ != null)
        {
            this._kReal_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._kReal_ = node;
    }

    public PListOfBlockRealIdentifiers getListOfBlockRealIdentifiers()
    {
        return this._listOfBlockRealIdentifiers_;
    }

    public void setListOfBlockRealIdentifiers(PListOfBlockRealIdentifiers node)
    {
        if(this._listOfBlockRealIdentifiers_ != null)
        {
            this._listOfBlockRealIdentifiers_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._listOfBlockRealIdentifiers_ = node;
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
            + toString(this._kReal_)
            + toString(this._listOfBlockRealIdentifiers_)
            + toString(this._tSemicolon_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._kReal_ == child)
        {
            this._kReal_ = null;
            return;
        }

        if(this._listOfBlockRealIdentifiers_ == child)
        {
            this._listOfBlockRealIdentifiers_ = null;
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
        if(this._kReal_ == oldChild)
        {
            setKReal((TKReal) newChild);
            return;
        }

        if(this._listOfBlockRealIdentifiers_ == oldChild)
        {
            setListOfBlockRealIdentifiers((PListOfBlockRealIdentifiers) newChild);
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
