/*
 * @(#)ProcessComponent.java   2011-11-01
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



package metsker.designpatterns.util.process;

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
import java.util.HashSet;
import java.util.Set;

import metsker.designpatterns.behavioral.iterator.ComponentIterator;

/**
 * Objects of this class represent either individual process steps or
 * compositions of process steps. A process is essentially a recipe for
 * manufacturing something, notably fireworks.
 */
public abstract class ProcessComponent {
    protected String name;

    /**
     * Create a process component with the given name.
     *
     * @param name
     *            this process component's name
     */
    public ProcessComponent(String name) {
        this.name = name;
    }

    /**
     * Accept a "visitor".
     *
     * @param v
     *            the visitor
     */
    public abstract void accept(ProcessVisitor v);

    /**
     * @return the component's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public ComponentIterator iterator() {
        return iterator(new HashSet());
    }

    /**
     * Method description
     *
     *
     * @param visited
     *
     * @return
     */
    public abstract ComponentIterator iterator(Set visited);

    /**
     * @return the number of leaf node steps in this composite.
     */
    public int getStepCount() {
        return getStepCount(new HashSet());
    }

    /**
     * @return the number of leaf node steps in this composite.
     * @param visited
     *            components already visited while traversing this component
     */
    public abstract int getStepCount(Set visited);

    /**
     * @return a textual representation of this component.
     */
    public String toString() {
        return name;
    }
}
