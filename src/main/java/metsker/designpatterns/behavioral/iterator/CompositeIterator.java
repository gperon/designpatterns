/*
 * @(#)CompositeIterator.java   2011-11-01
 * 
 * Copyright (c) 2011 Giorgio Peron giorgio.peron@gmail.com
 * All Rights Reserved. 
 *
 * Redistribution and use of this script, with or without modification, is
 * permitted provided that the following conditions are met:
 *
 * 1. Redistributions of this script must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ''AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO
 * EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */



package metsker.designpatterns.behavioral.iterator;

/*
* Copyright (c) 2001, 2005. Steven J. Metsker.
*
* Steve Metsker makes no representations or warranties about
* the fitness of this software for any particular purpose,
* including the implied warranty of merchantability.
*
* Please use this software as you wish with the sole
* restriction that you may not claim that you wrote it.
 */
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import metsker.designpatterns.util.process.ProcessComponent;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>    
 */
public class CompositeIterator extends ComponentIterator {
    protected Object peek;
    protected Iterator children;
    protected ComponentIterator subiterator;

    /**
     * Constructs ...
     *
     *
     * @param head
     * @param components
     * @param visited
     */
    public CompositeIterator(Object head, List components, Set visited) {
        super(head, visited);
        children = components.iterator();
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getDepth() {
        if (subiterator != null) {
            return subiterator.getDepth() + 1;
        }

        return 0;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public boolean hasNext() {
        if (peek == null) {
            peek = next();
        }

        return peek != null;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Object next() {
        if (peek != null) {
            Object result = peek;
            peek = null;

            return result;
        }
        if (!visited.contains(head)) {
            visited.add(head);
            if (shouldShowInterior()) {
                return head;
            }
        }

        return nextDescendant();
    }

    /*
     * Usually just return the subiterator's next element. But if the
     * subiterator doesn't exist or doesn't have a next element, create an
     * iterator for the next child. (If there is no next child, just return
     * null.) Create an iterator for this child and return this iterator's next
     * element.
     */
    protected Object nextDescendant() {
        while (true) {
            if (subiterator != null) {
                if (subiterator.hasNext()) {
                    return subiterator.next();
                }
            }
            if (!children.hasNext()) {
                return null;
            }
            ProcessComponent pc = (ProcessComponent) children.next();
            if (!visited.contains(pc)) {
                subiterator = pc.iterator(visited);
                subiterator.setShowInterior(shouldShowInterior());
            }
        }
    }
}
