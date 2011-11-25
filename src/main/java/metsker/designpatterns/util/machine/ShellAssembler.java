/*
 * @(#)ShellAssembler.java   2011-11-01
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



package metsker.designpatterns.util.machine;

import metsker.designpatterns.util.planning.MachinePlanner;
import metsker.designpatterns.util.planning.ShellPlanner;

/**
 * A shell assembler assemebles stars, gunpowder and paper casing into an aerial
 * shell.
 *
 * @author Steven J. Metsker
 *
 */
public class ShellAssembler extends Machine {

    /**
     * Create an assembler with the given id and with the supplied parent
     * machine.
     *
     * @param id
     *            the identity of this shell assembler
     * @param parent
     *            the composite this machine belongs to
     */
    public ShellAssembler(int id, MachineComponent parent) {
        super(id, parent);
    }

    /**
     * Create an assembler with the given id.
     *
     * @param id
     *            the identity of this shell assembler
     */
    public ShellAssembler(int id) {
        super(id);
    }

    /**
     * Create an assembler with the given id and with access to the mediator
     * that will control bin/machine relations.
     *
     * @param id
     *            the identity of this shell assembler
     * @param Mediator
     *            the mediator that controls this machine's relation to bins
     */
    protected ShellAssembler(int id, TubMediator mediator) {
        this(id, mediator, null);
    }

    /**
     * Create an assembler with the given id, with access to the mediator that
     * will control bin/machine relations, and with the supplied parent machine.
     *
     * @param id
     *            the identity of this shell assembler
     * @param mediator
     * @param parent
     *            the composite this machine belongs to
     */
    public ShellAssembler(int id, TubMediator mediator, MachineComponent parent) {
        super(id, mediator, parent);
    }

    /**
     * @return a planner that knows how shell assemblers operate
     */
    public MachinePlanner createPlanner() {
        return new ShellPlanner(this);
    }
}
