/*
 * @(#)MachineComponent.java   2011-11-01
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

import metsker.designpatterns.behavioral.iterator.ComponentIterator;

/**
 * Objects of this class represent either individual machines or composites of
 * machines.
 *
 * @author Steven J. Metsker
 *
 */
public abstract class MachineComponent {
    protected int id = 0;
    protected String name;
    protected MachineComponent parent;
    protected Engineer responsible;

    /**
     * Create a machine component with the given id.
     * @param id this machine's identity
     */
    protected MachineComponent(int id) {
        this(id, null);
    }

    /**
     * Create a machine component with the given id and parent
     * @param id this machine's identity
     * @param parent the machine composite that this component belongs to
     */
    protected MachineComponent(int id, MachineComponent parent) {
        this(id, parent, null);
    }

    /**
     * Create a machine component with the given id and parent
     * @param id this machine's identity
     * @param parent the machine composite that this component belongs to
     */
    protected MachineComponent(int id, MachineComponent parent, Engineer responsible) {
        this.id = id;
        this.parent = parent;
        this.responsible = responsible;
    }

    /**
     *   @param visitor a visitor that will add some sort of behavior
     */
    public abstract void accept(MachineVisitor visitor);

    /**
     * @return the number of leaf node machines in this composite.
     */
    public abstract int getMachineCount();

    /*
     * Subclasses implement this to support the isTree() algorithm.
     */
    protected abstract boolean isTree(Set s);

    /**
     * @return true if this component is atop an acyclic graph in which no node
     *         has two parents (two references to it).
     */
    public boolean isTree() {
        return isTree(new HashSet());
    }

    /**
     * @return an iterator for this component
     */
    public ComponentIterator iterator() {
        return iterator(new HashSet());
    }

    /**
     * Method description
     *
     *
     * @param set
     *
     * @return
     */
    public abstract ComponentIterator iterator(Set set);

    /**
     * @return a textual representation of this component
     */
    public String toString() {
        if (name != null) {
            return name;
        }
        String s = getClass().getName();

        return s.substring(s.lastIndexOf('.') + 1) + ":" + id;
    }

    /**
     *
     * @param o
     * @return true if, according to business rules, this component and the
     *         supplied object refer to the same thing.
     */
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MachineComponent)) {
            return false;
        }
        MachineComponent mc = (MachineComponent) o;

        return id == mc.id;
    }

    /**
     * @return the engineer who is responsible for this machine
     */
    public Engineer getResponsible() {
        if (responsible != null) {
            return responsible;
        }
        if (parent != null) {
            return parent.getResponsible();
        }

        return null;
    }

    /**
     * @return this component's id
     */
    public int getId() {
        return id;
    }

    /**
     * @return this component's name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name this component's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the composite that this machine belongs to.
     */
    public MachineComponent getParent() {
        return parent;
    }

    /**
     *
     * @param thatId
     * @return a machine within this machine graph, given its ID.
     */
    public MachineComponent find(int thatId) {
        if (id == thatId) {
            return this;
        }

        return null;
    }

    /**
     *
     * @param name
     * @return a machine with the given name.
     */
    public MachineComponent find(String name) {
        if (this.toString().equals(name)) {
            return this;
        }

        return null;
    }
}
