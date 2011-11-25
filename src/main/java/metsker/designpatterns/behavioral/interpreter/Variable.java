/*
 * @(#)Variable.java   2011-11-01
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
 *  Record a name that can be used to assign and look up a
 *  machine.
 */
public class Variable extends Term {
    protected String name;
    protected Term value;

    /**
     *  Construct a variable with the provided name.
     *  @param name the variable's name
     */
    public Variable(String name) {
        this.name = name;
    }

    /**
     *  @return this variable's name.
     */
    public String getName() {
        return name;
    }

    /**
     *  Set the value of this variable.
     *  @param term the value of this variable
     */
    public void assign(Term term) {
        this.value = term;
    }

    /**
     *  @return true if the provided object equals this one.
     *  @param o an object to compare to
     */
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Variable)) {
            return false;
        }
        Variable v = (Variable) o;

        return name.equals(v.name);
    }

    /**
     *  @return a hash code for this object.
     */
    public int hashCode() {
        return name.hashCode();
    }

    /**
     *  @return the machine that this variable refers to in
     *  the provided context.
     */
    public Machine eval() {
        return value.eval();
    }

    /**
     *  @return a string description of this variable.
     */
    public String toString() {
        return name + ": " + value;
    }
}
