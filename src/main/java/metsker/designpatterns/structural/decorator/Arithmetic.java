/*
 * @(#)Arithmetic.java   2011-11-01
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



package metsker.designpatterns.structural.decorator;

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

/**
 * Wrap an arithmetic function around a pair of supplied sources.
 */
public class Arithmetic extends Function {
    protected char op;

    /**
     * Construct an arithmetic function that decorates the provided source
     * functions.
     *
     *
     * @param op
     * @param f1
     *            Another function wrapper
     * @param f2
     *            Yet another function wrapper
     */
    public Arithmetic(char op, Function f1, Function f2) {
        super(new Function[] { f1, f2 });
        this.op = op;
    }

    /**
     * @return an arithmetic operation (as indicated in the constructor) applied
     *         to the source functions' values at time t.
     * @param t
     *            time
     */
    public double f(double t) {
        switch (op) {
            case '+' :
                return sources[0].f(t) + sources[1].f(t);

            case '-' :
                return sources[0].f(t) - sources[1].f(t);

            case '*' :
                return sources[0].f(t) * sources[1].f(t);

            case '/' :
                return sources[0].f(t) / sources[1].f(t);

            default :
                return 0;
        }
    }
}
