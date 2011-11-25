/*
 * @(#)Constant.java   2011-11-01
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



package metsker.designpatterns.behavioral.interpreter;

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
import metsker.designpatterns.util.machine.Machine;

/**
 *  Represent a specific machine.
 */
public class Constant extends Term {
    protected Machine machine;

    /**
     *  Construct a term that always referst to a specific
     *  machine.
     *
     * @param machine
     */
    public Constant(Machine machine) {
        this.machine = machine;
    }

    /**
     *  @return true if the provided object equals this one.
     *  @param obj an object to compare to
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj.getClass() == this.getClass())) {
            return false;
        }
        Constant that = (Constant) obj;

        return this.machine.equals(that.machine);
    }

    /**
     *  @return a hash code for this object.
     */
    public int hashCode() {
        return machine.hashCode();
    }

    /**
     *  @return the machine that this term wraps.
     */
    public Machine eval() {
        return machine;
    }

    /**
     *  @return a string description of this constant.
     */
    public String toString() {
        return machine.toString();
    }
}
