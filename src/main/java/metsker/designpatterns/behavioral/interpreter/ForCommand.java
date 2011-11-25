/*
 * @(#)ForCommand.java   2011-11-01
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
import java.util.List;

import metsker.designpatterns.util.machine.Machine;
import metsker.designpatterns.util.machine.MachineComponent;
import metsker.designpatterns.util.machine.MachineComposite;

/**
 * This class represents a "for" loop that will execute its body for each
 * machine in a provided composite, assigning a variable to a different machine
 * in each pass through the loop.
 */
public class ForCommand extends Command {
    protected MachineComponent root;
    protected Variable variable;
    protected Command body;

    /**
     * Construct a "for" interpreter that will execute the provided body,
     * looping through the machines in a context, assigning the provided
     * variable to each machine.
     *
     * @param mc
     * @param v the variable to set for each loop
     * @param body the body of the for command
     */
    public ForCommand(MachineComponent mc, Variable v, Command body) {
        this.root = mc;
        this.variable = v;
        this.body = body;
    }

    /**
     * For each machine in the context, assign this object's variable to the
     * machine, and execute this object's body.
     */
    public void execute() {
        execute(root);
    }

    private void execute(MachineComponent mc) {
        if (mc instanceof Machine) {
            Machine m = (Machine) mc;
            variable.assign(new Constant(m));
            body.execute();

            return;
        }
        MachineComposite comp = (MachineComposite) mc;
        List children = comp.getComponents();
        for (int i = 0; i < children.size(); i++) {
            MachineComponent child = (MachineComponent) children.get(i);
            execute(child);
        }
    }
}
