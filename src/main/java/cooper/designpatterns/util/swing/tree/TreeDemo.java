/*
 * @(#)TreeDemo.java   2011-11-01
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



package cooper.designpatterns.util.swing.tree;

import cooper.designpatterns.util.swing.JxFrame;

import java.awt.*;

import javax.swing.*;
import javax.swing.tree.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class TreeDemo extends JxFrame {
    DefaultMutableTreeNode root;

    /**
     * Constructs ...
     *
     */
    public TreeDemo() {
        super("Tree Demo");
        JPanel jp = new JPanel();    // create interior panel
        jp.setLayout(new BorderLayout());
        getContentPane().add(jp);
        // create scroll pane
        JScrollPane sp = new JScrollPane();
        jp.add("Center", sp);
        // create root node
        root = new DefaultMutableTreeNode("Foods");
        JTree tree = new JTree(root);    // create tree
        sp.getViewport().add(tree);    // add to scroller
        // create 3 nodes, each with three sub nodes
        addNodes("Meats", "Beef", "Chicken", "Pork");
        addNodes("Vegies", "Broccolli", "Carrots", "Peas");
        addNodes("Desserts", "Charlotte Russe", "Bananas Flambe", "Peach Melba");
        setSize(200, 300);
        setVisible(true);
    }

    private void addNodes(String b, String n1, String n2, String n3) {
        DefaultMutableTreeNode base = new DefaultMutableTreeNode(b);
        root.add(base);
        base.add(new DefaultMutableTreeNode(n1));
        base.add(new DefaultMutableTreeNode(n2));
        base.add(new DefaultMutableTreeNode(n3));
    }

    /**
     * Method description
     *
     *
     * @param argv
     */
    static public void main(String[] argv) {
        new TreeDemo();
    }
}
