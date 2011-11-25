/*
 * @(#)ProcessComposite.java   2011-11-01
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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import metsker.designpatterns.behavioral.iterator.ComponentIterator;
import metsker.designpatterns.behavioral.iterator.CompositeIterator;

/**
 * Represent either an alternation or a sequence of process steps.
 */
public abstract class ProcessComposite extends ProcessComponent {
    protected List subprocesses;

    /**
     * Create a process composite with the given name.
     * @param name this process composite's name
     */
    public ProcessComposite(String name) {
        this(name, new ArrayList());
    }

    /**
     * Create a composite with the given name and containing the given
     * subprocesses.
     * @param name the identity of this composite
     * @param existingProcesses the children of this composite
     */
    public ProcessComposite(String name, ProcessComponent[] existingProcesses) {
        super(name);
        subprocesses = new ArrayList();
        for (int i = 0; i < existingProcesses.length; i++) {
            subprocesses.add(existingProcesses[i]);
        }
    }

    /**
     * Create a composite with the given name and containing the given
     * subprocesses.
     * @param name the identity of this composite
     * @param subprocesses the children of this composite
     */
    public ProcessComposite(String name, List subprocesses) {
        super(name);
        this.subprocesses = subprocesses;
    }

    /**
     * @return the children of this composite.
     */
    public List getChildren() {
        return subprocesses;
    }

    /**
     * Add the given component as a child.
     * @param c the component to add
     */
    public void add(ProcessComponent c) {
        subprocesses.add(c);
    }

    /**
     * Method description
     *
     *
     * @param visited
     *
     * @return
     */
    public ComponentIterator iterator(Set visited) {
        return new CompositeIterator(this, subprocesses, visited);
    }

    /**
     * @return the number of steps (leaf nodes) in the tree that this composite
     *         represents.
     * @param visited components already visited while traversing this component
     */
    public int getStepCount(Set visited) {
        visited.add(getName());
        int count = 0;
        for (int i = 0; i < subprocesses.size(); i++) {
            ProcessComponent pc = (ProcessComponent) subprocesses.get(i);
            if (!visited.contains(pc.getName())) {
                count += pc.getStepCount(visited);
            }
        }

        return count;
    }
}
