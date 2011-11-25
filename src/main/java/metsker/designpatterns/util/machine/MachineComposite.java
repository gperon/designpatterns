/*
 * @(#)MachineComposite.java   2011-11-01
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
import metsker.designpatterns.behavioral.iterator.CompositeIterator;

/**
 * Represent a collection of machines: a manufacturing line, a bay, or a
 * factory.
 */
public class MachineComposite extends MachineComponent {
    protected List components = new ArrayList();

    /**
     * Create a composite with the given id.
     *
     * @param id identity of this composite, such as the bay number
     */
    public MachineComposite(int id) {
        this(id, null);
    }

    /**
     * Create a composite with the given id and with the supplied parent machine
     * component.
     *
     * @param id
     *            the identity of this composite
     * @param parent
     *            the component that this machine belongs to
     */
    public MachineComposite(int id, MachineComponent parent) {
        this(id, parent, (Engineer) null);
    }

    /**
     * Constructs ...
     *
     *
     * @param id
     * @param parent
     * @param responsible
     */
    public MachineComposite(int id, MachineComponent parent, Engineer responsible) {
        super(id, parent, responsible);
    }

    /**
     * Create a composite with the given id, with the supplied parent machine
     * component, and containing the given components.
     *
     * @param id
     *            the identity of this composite
     * @param parent
     *            the component that this composite belongs to
     * @param components
     *            the children of this composite
     */
    public MachineComposite(int id, MachineComponent parent, MachineComponent[] components) {
        super(id, parent);
        for (int i = 0; i < components.length; i++) {
            add(components[i]);
        }
    }

    /**
     * @return the number of machines (leaf nodes) in the tree that this
     *         composite represents
     */
    public int getMachineCount() {
        int count = 0;
        Iterator i = components.iterator();
        while (i.hasNext()) {
            MachineComponent mc = (MachineComponent) i.next();
            count += mc.getMachineCount();
        }

        return count;
    }

    /**
     * @param component the component to add to this composite
     */
    public void add(MachineComponent component) {
        components.add(component);
    }

    /**
     * @param children the components to add to this composite
     */
    public void add(MachineComponent[] children) {
        for (int i = 0; i < children.length; i++) {
            components.add(children[i]);
        }
    }

    /**
     * This hook lets visitors add behaviors to the machine composite. The point
     * here is to call back the visitor indicating the type of this node, namely
     * MachineComposite.
     *
     *
     * @param v
     */
    public void accept(MachineVisitor v) {
        v.visit(this);
    }

    /**
     * @return this composite's children
     */
    public List getComponents() {
        return components;
    }

    /**
     * @param visited a set of visited nodes
     * @return true if this composite is a tree
     * @see MachineComponent#isTree()
     */
    protected boolean isTree(Set visited) {
        visited.add(this);
        Iterator i = components.iterator();
        while (i.hasNext()) {
            MachineComponent c = (MachineComponent) i.next();
            if (visited.contains(c) || !c.isTree(visited)) {
                return false;
            }
        }

        return true;
    }

    /**
     *
     * @param thatId
     * @return a component in this machine graph whose id matches the provided
     *         one.
     */
    public MachineComponent find(int thatId) {
        if (id == thatId) {
            return this;
        }
        List components = getComponents();
        for (int i = 0; i < components.size(); i++) {
            MachineComponent child = (MachineComponent) components.get(i);
            MachineComponent mc = child.find(thatId);
            if (mc != null) {
                return mc;
            }
        }

        return null;
    }

    /**
     *
     * @param name
     * @return a component in this machine graph whose name matches the provided
     *         one.
     */
    public MachineComponent find(String name) {
        if (name.equals(this.toString())) {
            return this;
        }
        List components = getComponents();
        for (int i = 0; i < components.size(); i++) {
            MachineComponent child = (MachineComponent) components.get(i);
            MachineComponent mc = child.find(name);
            if (mc != null) {
                return mc;
            }
        }

        return null;
    }

    /**
     *
     * @param visited
     * @return an iterator for this composite.
     */
    public ComponentIterator iterator(Set visited) {
        return new CompositeIterator(this, components, visited);
    }
}
