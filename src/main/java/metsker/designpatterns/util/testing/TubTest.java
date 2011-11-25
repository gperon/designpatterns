/*
 * @(#)TubTest.java   2011-11-01
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
import metsker.designpatterns.util.machine.Fuser;
import metsker.designpatterns.util.machine.Machine;
import metsker.designpatterns.util.machine.Tub;
import metsker.designpatterns.util.machine.TubMediator;

import junit.framework.TestCase;

/**
 *  Test Machine/Tub relationships.
 */
public class TubTest extends TestCase {

    /**
     * Method description
     *
     */
    public void testAddTub() {
        TubMediator mediator = new TubMediator();
        Tub tub = new Tub("T402", mediator);
        Machine m1 = new Fuser(1, mediator);
        Machine m2 = new Fuser(2, mediator);
        // place the tub on m1
        tub.setLocation(m1);
        assertEquals(1, m1.getTubs().size());
        // move the tub by adding it to m2
        m2.addTub(tub);
        assertEquals(m2, tub.getLocation());
        assertEquals(0, m1.getTubs().size());
        assertEquals(1, m2.getTubs().size());
    }

    /**
     * Method description
     *
     */
    public void testLocationChange() {
        TubMediator mediator = new TubMediator();
        Tub t = new Tub("T403", mediator);
        Machine m1 = new Fuser(1001, mediator);
        Machine m2 = new Fuser(1002, mediator);
        t.setLocation(m1);
        assertTrue(m1.getTubs().contains(t));
        assertTrue(!m2.getTubs().contains(t));
        t.setLocation(m2);
        assertFalse(m1.getTubs().contains(t));
        assertTrue(m2.getTubs().contains(t));
    }
}
