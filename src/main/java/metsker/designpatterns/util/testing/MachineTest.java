/*
 * @(#)MachineTest.java   2011-11-01
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

import metsker.designpatterns.util.machine.Fuser;
import metsker.designpatterns.util.machine.Machine;
import metsker.designpatterns.util.machine.MachineComponent;
import metsker.designpatterns.util.machine.MachineComposite;
import metsker.designpatterns.util.machine.OozinozFactory;

/**
 *  Test the MachineComponent hierarchy, especially its ability
 *  to tell whether or not an object model is cyclic.
 */
public class MachineTest extends TestCase {

    /**
     *  @return a normal little tree with 3 leaves.
     */
    public static MachineComposite tree() {
        Machine m1 = new Fuser(1);
        Machine m2 = new Fuser(2);
        Machine m3 = new Fuser(3);
        MachineComposite m23 = new MachineComposite(23);
        m23.add(m2);
        m23.add(m3);
        MachineComposite m123 = new MachineComposite(123);
        m123.add(m1);
        m123.add(m23);

        return m123;
    }

    /**
     *  @return a tiny process flow that shows a composite that is
     *  not a tree: m1->m2->m3->m1
     */
    public static MachineComponent cycle() {
        MachineComposite m1 = new MachineComposite(1);
        MachineComposite m2 = new MachineComposite(2);
        MachineComposite m3 = new MachineComposite(3);
        m1.add(m2);
        m2.add(m3);
        m3.add(m1);

        return m1;
    }

    /**
     *  @return a tiny machine composite that shows a composite that is
     *  not a tree: An acyclic non-tree m1->m2, m3; m3-> m2.
     */
    public static MachineComponent nonTree() {
        MachineComposite m1 = new MachineComposite(1);
        MachineComposite m3 = new MachineComposite(3);
        Machine m2 = new Fuser(2);
        m1.add(m2);
        m1.add(m3);
        m3.add(m2);

        return m1;
    }

    /**
     * Method description
     *
     */
    public void testCanCountLeaves() {
        assertEquals(3, tree().getMachineCount());
    }

    /**
     * Method description
     *
     */
    public void testThatCycleIsNotATree() {
        assertFalse(cycle().isTree());
        assertFalse(nonTree().isTree());
        assertTrue(tree().isTree());
        assertFalse(OozinozFactory.plant().isTree());
    }

    /**
     * Method description
     *
     */
    public void testThatAMachineIsATree() {
        assertTrue(new Fuser(1).isTree());
    }
}
