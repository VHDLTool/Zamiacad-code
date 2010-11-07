/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.zamia.verilog.node;

import java.util.*;
import org.zamia.verilog.analysis.*;

@SuppressWarnings("nls")
public final class AP0PrimaryHierarchicalIdentifier extends PPrimaryHierarchicalIdentifier
{
    private PIdentifier _identifier_;
    private final LinkedList<PBracketRange> _bracketRange_ = new LinkedList<PBracketRange>();

    public AP0PrimaryHierarchicalIdentifier()
    {
        // Constructor
    }

    public AP0PrimaryHierarchicalIdentifier(
        @SuppressWarnings("hiding") PIdentifier _identifier_,
        @SuppressWarnings("hiding") List<PBracketRange> _bracketRange_)
    {
        // Constructor
        setIdentifier(_identifier_);

        setBracketRange(_bracketRange_);

    }

    @Override
    public Object clone()
    {
        return new AP0PrimaryHierarchicalIdentifier(
            cloneNode(this._identifier_),
            cloneList(this._bracketRange_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAP0PrimaryHierarchicalIdentifier(this);
    }

    public PIdentifier getIdentifier()
    {
        return this._identifier_;
    }

    public void setIdentifier(PIdentifier node)
    {
        if(this._identifier_ != null)
        {
            this._identifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identifier_ = node;
    }

    public LinkedList<PBracketRange> getBracketRange()
    {
        return this._bracketRange_;
    }

    public void setBracketRange(List<PBracketRange> list)
    {
        this._bracketRange_.clear();
        this._bracketRange_.addAll(list);
        for(PBracketRange e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._identifier_)
            + toString(this._bracketRange_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        if(this._bracketRange_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._identifier_ == oldChild)
        {
            setIdentifier((PIdentifier) newChild);
            return;
        }

        for(ListIterator<PBracketRange> i = this._bracketRange_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PBracketRange) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}
