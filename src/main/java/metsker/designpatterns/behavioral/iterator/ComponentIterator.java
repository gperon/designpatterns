/*
 * @(#)ComponentIterator.java   2011-11-01
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
import java.util.*;

/**
 * This is the abstract superclass of enumerators that can walk across leaf nodes
 * and composite nodes in a composite structure.
 */
public abstract class ComponentIterator implements Iterator {
    protected Object head;
    protected Set visited;
    protected boolean returnInterior = true;

    /**
     * Create an enumerator over a node in a composite.
     *
     * @param head
     * @param visited a set to track visited nodes
     */
    public ComponentIterator(Object head, Set visited) {
        this.head = head;
        this.visited = visited;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public boolean shouldShowInterior() {
        return returnInterior;
    }

    /**
     * Method description
     *
     *
     * @param value
     */
    public void setShowInterior(boolean value) {
        returnInterior = value;
    }

    /**
     * @return the current depth of the iteration (number of nodes above the
     *         current node)
     */
    public abstract int getDepth();

    /**
     * Method description
     *
     */
    public void remove() {
        throw new UnsupportedOperationException("ComponentIterator.Remove");
    }
}
