/*
 * @(#)RakeVisitor.java   2011-11-01
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


package metsker.designpatterns.behavioral.visitor;

import metsker.designpatterns.util.machine.Machine;
import metsker.designpatterns.util.machine.MachineComponent;
import metsker.designpatterns.util.machine.MachineComposite;
import metsker.designpatterns.util.machine.MachineVisitor;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * This class uses the visitor mechanics of the machine hierarchy to add a
 * behavior that finds all the leaf-node machines in a composite.
 *
 * @author Steven J. Metsker
 * @see com.oozinoz.applications.ShowRakeVisitor
 */
public class RakeVisitor implements MachineVisitor {
    private Set leaves;

    /**
     * Find all the leaf-node machines in a composite.
     *
     * @param mc
     * @return
     */
    public Set getLeaves(MachineComponent mc) {
        leaves = new HashSet();
        mc.accept(this);

        return leaves;
    }

    /**
     * Add this machine to the set of leaf nodes.
     *
     * @param m
     */
    public void visit(Machine m) {
        leaves.add(m);
    }

    /**
     * Visit all the children of the provided composite to see if they are leaf
     * nodes.
     *
     * @param mc
     */
    public void visit(MachineComposite mc) {
        Iterator iter = mc.getComponents().iterator();
        while (iter.hasNext()) {
            ((MachineComponent) iter.next()).accept(this);
        }
    }
}
