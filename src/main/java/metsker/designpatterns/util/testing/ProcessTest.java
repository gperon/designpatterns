/*
 * @(#)ProcessTest.java   2011-11-01
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



package metsker.designpatterns.util.testing;

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
import junit.framework.TestCase;

import metsker.designpatterns.util.process.ProcessComponent;
import metsker.designpatterns.util.process.ProcessSequence;
import metsker.designpatterns.util.process.ProcessStep;
import metsker.designpatterns.util.process.ShellProcess;

/**
 *  Test the ProcessComponent hierarchy, especially its ability
 *  to model cyclic processes.
 */
public class ProcessTest extends TestCase {

    /**
     *  @return a tiny process flow that shows a composite that is
     *  not a tree (but also not a cycle, by the way). In this flow
     *  A contains C and B, B contains C.
     */
    public static ProcessComponent abc() {
        ProcessSequence a = new ProcessSequence("a");
        ProcessSequence b = new ProcessSequence("b");
        ProcessStep c = new ProcessStep("c");
        a.add(c);
        a.add(b);
        b.add(c);

        return a;
    }

    /**
     *  @return a tiny process flow that shows a composite that is
     *  not a tree. In this flow A contains B, B contains C,
     *  and C contains A.
     */
    public static ProcessComponent cycle() {
        ProcessSequence a = new ProcessSequence("a");
        ProcessSequence b = new ProcessSequence("b");
        ProcessSequence c = new ProcessSequence("c");
        a.add(b);
        b.add(c);
        c.add(a);

        return a;
    }

    /**
     * Method description
     *
     */
    public void testCountOfCycle() {
        assertEquals(0, cycle().getStepCount());
    }

    /**
     * Method description
     *
     */
    public void testStepCountForEmptyProcess() {
        ProcessSequence nil = new ProcessSequence("nil");
        assertEquals(0, nil.getStepCount());
    }

    /**
     * Method description
     *
     */
    public void testStepCountForOneStepProcess() {
        ProcessStep uno = new ProcessStep("uno");
        assertEquals(1, uno.getStepCount());
    }

    /**
     * Method description
     *
     */
    public void testShampooProcess_ShampooRinseRepeat() {
        ProcessStep shampoo = new ProcessStep("shampoo");
        ProcessStep rinse = new ProcessStep("rinse");
        ProcessSequence once = new ProcessSequence("once");
        once.add(shampoo);
        once.add(rinse);
        ProcessSequence instructions = new ProcessSequence("instructions");
        instructions.add(once);
        instructions.add(once);
        assertEquals(2, instructions.getStepCount());
    }

    /**
     * Method description
     *
     */
    public void testStepCountForAerialShellProcess() {
        assertEquals(4, ShellProcess.make().getStepCount());
    }

    /**
     * Method description
     *
     */
    public void testStepCountForNonTreeDirectedAcyclicGraph() {
        assertEquals(1, abc().getStepCount());
    }

    //
    // abc
    // / \
    // a   bc
    // / \
    // b   c
    //

    /**
     * Method description
     *
     */
    public void testSimpleTree() {
        ProcessStep a = new ProcessStep("a");
        ProcessStep b = new ProcessStep("b");
        ProcessStep c = new ProcessStep("c");
        ProcessSequence bc = new ProcessSequence("bc");
        bc.add(b);
        bc.add(c);
        ProcessSequence abc = new ProcessSequence("abc");
        abc.add(a);
        abc.add(bc);
        assertEquals(3, abc.getStepCount());
    }
}
