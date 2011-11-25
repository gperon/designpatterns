/*
 * @(#)FunctionTest.java   2011-11-01
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

import metsker.designpatterns.structural.decorator.Arithmetic;
import metsker.designpatterns.structural.decorator.Constant;
import metsker.designpatterns.structural.decorator.Function;
import metsker.designpatterns.structural.decorator.Scale;

/**
 *  A few tests of Function wrappers.
 */
public class FunctionTest extends TestCase {
    double fuzz = 0.00001;

    /**
     * Method description
     *
     */
    public void testConstant() {
        Constant c = new Constant(42);
        assertEquals(42, c.f(0), fuzz);
        assertEquals(42, c.f(0.5), fuzz);
        assertEquals(42, c.f(1), fuzz);
    }

    /**
     * Method description
     *
     */
    public void testScale() {
        Function c = new Scale(0, 100);    // let Celsius go 0 to 100
        Function f = new Scale(new Constant(0), c, new Constant(100), new Constant(32),
                               new Constant(212));
        assertEquals(32.0, f.f(0), fuzz);
        assertEquals(-40, f.f(-0.4), fuzz);
        assertEquals(212, f.f(1), fuzz);
    }

    /**
     * Method description
     *
     */
    public void testArithmetic() {
        Function f = new Arithmetic('+', new Constant(3), new Constant(4));
        assertEquals(7, f.f(0), fuzz);
        assertEquals(7, f.f(0.5), fuzz);
        assertEquals(7, f.f(1), fuzz);
    }
}
