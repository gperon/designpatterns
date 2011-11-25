/*
 * @(#)Machine.java   2011-11-01
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
import java.util.*;

import metsker.designpatterns.util.planning.BasicPlanner;
import metsker.designpatterns.util.planning.MachinePlanner;
import metsker.designpatterns.behavioral.iterator.ComponentIterator;
import metsker.designpatterns.behavioral.iterator.LeafIterator;
import metsker.designpatterns.util.Queue;

/**
 * Represent a machine in an Oozinoz factory.
 *
 * @author Steven J. Metsker
 *
 */
public abstract class Machine extends MachineComponent {
    protected Queue bins = new Queue();
    protected MachinePlanner planner;
    protected boolean isUp = true;
    protected TubMediator mediator;

    /**
     * Create a machine with the given id and with access to the mediator that
     * will control bin/machine relations.
     *
     * @param id
     *            the identity of this machine
     * @param Mediator
     *            the mediator that controls this machine's relation to bins
     */
    protected Machine(int id, TubMediator mediator) {
        this(id, mediator, null);
    }

    /**
     * Create a machine with the given id, with access to the mediator that will
     * control bin/machine relations, and with the supplied parent machine.
     *
     * @param id
     *            the identity of this machine
     * @param mediator
     * @param parent
     *            the composite this machine belongs to
     */
    public Machine(int id, TubMediator mediator, MachineComponent parent) {
        this(id, mediator, parent, null);
    }

    /**
     * Create a machine with the given id, with access to the mediator that will
     * control bin/machine relations, and with the supplied parent machine.
     *
     * @param id
     *            the identity of this machine
     * @param mediator
     * @param parent
     *            the composite this machine belongs to
     * @param responsible
     */
    public Machine(int id, TubMediator mediator, MachineComponent parent, Engineer responsible) {
        super(id, parent, responsible);
        this.mediator = mediator;
        initialize();
    }

    /**
     * Create a machine with the given id.
     *
     * @param id
     *            the identity of this machine
     */
    public Machine(int id) {
        super(id);
    }

    /**
     * Create a machine with the given id and with the supplied parent machine.
     *
     * @param id
     *            the identity of this machine
     * @param parent
     *            the composite this machine belongs to
     */
    public Machine(int id, MachineComponent parent) {
        super(id, parent);
        this.mediator = null;    // TBD
        initialize();
    }

    /**
     * Method description
     *
     */
    public void initialize() {
        bins = new Queue();
    }

    /**
     * Queue up a bin for processing at this machine.
     *
     *
     * @param b
     */
    public void load(Bin b) {
        bins.enqueue(b);
        System.out.println(toString() + " loading");
    }

    /**
     * Return an object that can plan for the operational behavior of this
     * machine.
     *
     * @return a planner for this machine
     */
    public MachinePlanner createPlanner() {
        return new BasicPlanner(this);
    }

    /**
     * Return the number of machines in this machine, namely 1
     *
     * @return one, since there's only one machine here
     */
    public int getMachineCount() {
        return 1;
    }

    /**
     * Return true if there are any bins on this machine
     *
     * @return true if there are any bins on this machine
     */
    public boolean hasMaterial() {
        return !bins.isEmpty();
    }

    /**
     * Ask this machine to shutdown.
     */
    public void shutdown() {
        System.out.println(toString() + " shutting down");
    }

    /**
     * Ask this machine to start up.
     */
    public void startup() {
        System.out.println(toString() + " starting up");
    }

    /**
     * Remove a material bin from this machine.
     *
     * @return the removed bin
     */
    public Bin unload() {
        if (bins.isEmpty()) {
            System.out.println(toString() + " already empty");

            return null;
        }
        Bin b = (Bin) bins.dequeue();
        System.out.println(toString() + " unloading");

        return b;
    }

    /**
     * This hook lets visitors add behaviors to the machine composite. The point
     * here is to call back the visitor indicating the type of this node, namely
     * Machine.
     *
     *
     * @param v
     */
    public void accept(MachineVisitor v) {
        v.visit(this);
    }

    /**
     * Place a tub of chemicals at this machine.
     *
     *
     * @param t
     */
    public void addTub(Tub t) {
        mediator.set(t, this);
    }

    /**
     * Return a planner for this machine.
     *
     * @return a planner for this machine
     */
    public MachinePlanner getPlanner() {
        if (planner == null) {
            planner = createPlanner();
        }

        return planner;
    }

    /**
     * Return the chemical tubs that are at this machine.
     *
     * @return the chemical tubs that are at this machine
     */
    public Set getTubs() {
        return mediator.getTubs(this);
    }

    /**
     * @param visited ignored
     * @return True; individual machines are always "trees"
     * @see MachineComponent#isTree()
     */
    protected boolean isTree(Set visited) {
        visited.add(this);

        return true;
    }

    /**
     * @return true if this machine is up
     */
    public boolean isUp() {
        return isUp;
    }

    /**
     *
     * @param visited
     * @return an iterator that will "iterate over" this machine, returning it
     *         once.
     */
    public ComponentIterator iterator(Set visited) {
        return new LeafIterator(this, visited);
    }

    /**
     * Record whether or not this machine is up.
     *
     * @param isUp
     *            whether or not this machine is up
     */
    public void setIsUp(boolean isUp) {
        this.isUp = isUp;
    }
}
