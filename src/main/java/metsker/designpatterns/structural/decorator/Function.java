/*
 * @(#)Function.java   2011-11-01
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
 * This abstract superclass defines the role of a function that wraps itself
 * around (or "decorates") another function.
 *
 * The signature of function methods in this hierarchy is "double f(double time)".
 * Each class defines this function in a way that is consistent with the class
 * name.
 *
 * The "time" argument is a value from 0 to 1 that represents a normalized
 * notion of time. For example, in the arc of a parabola, time goes 0 to 1 as x
 * goes 0 to the base of the arc and y goes 0 to the apogee (at t = .5) and back
 * to 0.
 */
public abstract class Function {
    protected Function[] sources;

    /**
     * Construct a function that decorates the provided source function.
     *
     * @param f
     *            the source function that this function wraps
     */
    public Function(Function f) {
        this(new Function[] { f });
    }

    /**
     * Construct a function that decorates the provided source functions.
     *
     * @param sources
     *            the source functions that this function wraps
     */
    public Function(Function[] sources) {
        this.sources = sources;
    }

    /**
     * The function that subclasses must implement -- see the subclasses for
     * examples.
     *
     * @param t
     *            normalized time, a value between 0 and 1
     * @return a function value
     */
    public abstract double f(double t);

    /**
     * @return a textual representation of this function.
     */
    public String toString() {
        String name = this.getClass().toString();
        StringBuffer buf = new StringBuffer(name);
        if (sources.length > 0) {
            buf.append('(');
            for (int i = 0; i < sources.length; i++) {
                if (i > 0) {
                    buf.append(", ");
                }
                buf.append(sources[i]);
            }
            buf.append(')');
        }

        return buf.toString();
    }
}
