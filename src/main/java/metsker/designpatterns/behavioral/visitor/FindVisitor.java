/*
 * @(#)FindVisitor.java   2011-11-01
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

import java.util.*;

/**
 * This class uses the visitor mechanics of the machine hierarchy to add a
 * behavior that finds a particular machine within a machine composite.
 *
 * @author Steven J. Metsker
 * @see com.oozinoz.applications.ShowFindVisitor
 */
public class FindVisitor implements MachineVisitor {
    private int soughtId;
    private MachineComponent found;

    /**
     *
     * @param mc
     * @param id the id of the machine to find
     * @return a machine with the given id, within the given machine composite
     */
    public MachineComponent find(MachineComponent mc, int id) {
        found = null;
        soughtId = id;
        mc.accept(this);

        return found;
    }

    /**
     * Check a particular machine to see if it's the one that is sought.
     *
     * @param m
     */
    public void visit(Machine m) {
        if ((found == null) && (m.getId() == soughtId)) {
            found = m;
        }
    }

    /**
     * Check if the provided composite is the sought machine component. If not,
     * check this composite's children.
     *
     * @param mc
     */
    public void visit(MachineComposite mc) {
        if ((found == null) && (mc.getId() == soughtId)) {
            found = mc;

            return;
        }
        Iterator iter = mc.getComponents().iterator();
        while ((found == null) && iter.hasNext()) {
            ((MachineComponent) iter.next()).accept(this);
        }
    }
}
