/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AP0ShowcancelledDeclaration extends PShowcancelledDeclaration
{
    private TKShowcancelled _kShowcancelled_;
    private PListOfPathDescriptors _listOfPathDescriptors_;
    private TTSemicolon _tSemicolon_;

    public AP0ShowcancelledDeclaration()
    {
        // Constructor
    }

    public AP0ShowcancelledDeclaration(
        @SuppressWarnings("hiding") TKShowcancelled _kShowcancelled_,
        @SuppressWarnings("hiding") PListOfPathDescriptors _listOfPathDescriptors_,
        @SuppressWarnings("hiding") TTSemicolon _tSemicolon_)
    {
        // Constructor
        setKShowcancelled(_kShowcancelled_);

        setListOfPathDescriptors(_listOfPathDescriptors_);

        setTSemicolon(_tSemicolon_);

    }

    @Override
    public Object clone()
    {
        return new AP0ShowcancelledDeclaration(
            cloneNode(this._kShowcancelled_),
            cloneNode(this._listOfPathDescriptors_),
            cloneNode(this._tSemicolon_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAP0ShowcancelledDeclaration(this);
    }

    public TKShowcancelled getKShowcancelled()
    {
        return this._kShowcancelled_;
    }

    public void setKShowcancelled(TKShowcancelled node)
    {
        if(this._kShowcancelled_ != null)
        {
            this._kShowcancelled_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._kShowcancelled_ = node;
    }

    public PListOfPathDescriptors getListOfPathDescriptors()
    {
        return this._listOfPathDescriptors_;
    }

    public void setListOfPathDescriptors(PListOfPathDescriptors node)
    {
        if(this._listOfPathDescriptors_ != null)
        {
            this._listOfPathDescriptors_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._listOfPathDescriptors_ = node;
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
            + toString(this._kShowcancelled_)
            + toString(this._listOfPathDescriptors_)
            + toString(this._tSemicolon_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._kShowcancelled_ == child)
        {
            this._kShowcancelled_ = null;
            return;
        }

        if(this._listOfPathDescriptors_ == child)
        {
            this._listOfPathDescriptors_ = null;
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
        if(this._kShowcancelled_ == oldChild)
        {
            setKShowcancelled((TKShowcancelled) newChild);
            return;
        }

        if(this._listOfPathDescriptors_ == oldChild)
        {
            setListOfPathDescriptors((PListOfPathDescriptors) newChild);
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
