/*
 * @(#)ProcessStep.java   2011-11-01
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
import java.util.Set;

import metsker.designpatterns.behavioral.iterator.ComponentIterator;
import metsker.designpatterns.behavioral.iterator.LeafIterator;

/**
 * Represent an individual process step.
 */
public class ProcessStep extends ProcessComponent {

    /**
     * Create a step with the given name.
     *
     * @param name
     *            the name of this process step
     */
    public ProcessStep(String name) {
        super(name);
    }

    /**
     * This hook lets visitors add behaviors to the process composite. The point
     * here is to call back the visitor indicating the type of this node, namely
     * ProcessStep.
     *
     * @param v
     */
    public void accept(ProcessVisitor v) {
        v.visit(this);
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
        return new LeafIterator(this, visited);
    }

    /**
     * @return the number of steps in this step, namely 1.
     * @param visited
     *            components already visited while traversing this component
     */
    public int getStepCount(Set visited) {
        visited.add(name);

        return 1;
    }
}
