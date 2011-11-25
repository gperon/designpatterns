/*
 * @(#)MachineTreeModel.java   2011-11-01
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
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import metsker.designpatterns.util.machine.Machine;
import metsker.designpatterns.util.machine.MachineComponent;
import metsker.designpatterns.util.machine.MachineComposite;

/**
 * This class adapts a machine composite to behave as a tree model.
 *
 * (You might think that this class should subclass DefaultTreeModel, but that
 * class requires its nodes to be TreeNode objects.)
 *
 * @author Steven J. Metsker
 */
public class MachineTreeModel implements TreeModel {
    protected MachineComponent root;

    /**
     * Ignored.
     *
     * @param l
     */
    public void addTreeModelListener(javax.swing.event.TreeModelListener l) {}

    /**
     * @param parent
     *            a node in the tree
     * @param index
     * @return the child of the parent at the given index
     */
    public Object getChild(Object parent, int index) {
        if (parent instanceof MachineComposite) {
            MachineComposite c = (MachineComposite) parent;

            return c.getComponents().get(index);
        }

        return null;
    }

    /**
     *
     * @param parent
     *            a node in the tree
     * @return the number of children of the given node
     */
    public int getChildCount(Object parent) {
        if (parent instanceof MachineComposite) {
            MachineComposite c = (MachineComposite) parent;

            return c.getComponents().size();
        }

        return 0;
    }

    /**
     * @param parent
     *            a node in the tree
     * @param child
     *            a node in the tree
     * @return the index of the child at the parent node
     */
    public int getIndexOfChild(Object parent, Object child) {
        if (parent instanceof MachineComposite) {
            MachineComposite c = (MachineComposite) parent;

            return c.getComponents().indexOf(child);
        }

        return 0;
    }

    /**
     * @return the root of the tree
     */
    public Object getRoot() {
        return root;
    }

    /**
     * @param node
     *            a node in the tree
     * @return true if the given node is a leaf
     */
    public boolean isLeaf(Object node) {
        return node instanceof Machine;
    }

    /**
     * Ignored.
     *
     * @param l
     */
    public void removeTreeModelListener(javax.swing.event.TreeModelListener l) {}

    /**
     * Ignored.
     *
     * @param path
     * @param newValue
     */
    public void valueForPathChanged(TreePath path, Object newValue) {}

    /**
     * Construct a tree model of the supplied MachineComponent object.
     *
     * @param root
     */
    public MachineTreeModel(MachineComponent root) {
        this.root = root;
    }
}
