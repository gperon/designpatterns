/*
 * @(#)EmployeeTree.java   2011-11-01
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



package cooper.designpatterns.structural.composite;

import cooper.designpatterns.util.swing.JxFrame;

import java.awt.*;

import java.util.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.tree.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class EmployeeTree extends JxFrame implements TreeSelectionListener {
    Employee boss, marketVP, prodVP;
    Employee salesMgr, advMgr;
    Employee prodMgr, shipMgr;
    JScrollPane sp;
    JPanel treePanel;
    JTree tree;
    DefaultMutableTreeNode troot;
    JLabel cost;

    /**
     * Constructs ...
     *
     */
    public EmployeeTree() {
        super("Employee tree");
        makeEmployees();
        setGUI();
    }

    private void setGUI() {
        treePanel = new JPanel();
        getContentPane().add(treePanel);
        treePanel.setLayout(new BorderLayout());
        sp = new JScrollPane();
        treePanel.add("Center", sp);
        treePanel.add("South", cost = new JLabel("          "));
        treePanel.setBorder(new BevelBorder(BevelBorder.RAISED));
        troot = new DefaultMutableTreeNode(boss.getName());
        tree = new JTree(troot);
        tree.setBackground(Color.lightGray);
        loadTree(boss);

        /* Put the Tree in a scroller. */
        sp.getViewport().add(tree);
        setSize(new Dimension(200, 300));
        setVisible(true);
    }

    /**
     * Method description
     *
     *
     * @param topDog
     */
    public void loadTree(Employee topDog) {
        DefaultMutableTreeNode troot;
        troot = new DefaultMutableTreeNode(topDog.getName());
        treePanel.remove(tree);
        tree = new JTree(troot);
        tree.addTreeSelectionListener(this);
        sp.getViewport().add(tree);
        addNodes(troot, topDog);
        tree.expandRow(0);
        repaint();
    }

    private void addNodes(DefaultMutableTreeNode pnode, Employee emp) {
        DefaultMutableTreeNode node;
        Enumeration e = emp.elements();
        while (e.hasMoreElements()) {
            Employee newEmp = (Employee) e.nextElement();
            node = new DefaultMutableTreeNode(newEmp.getName());
            pnode.add(node);
            addNodes(node, newEmp);
        }
    }

    private void makeEmployees() {
        boss = new Employee("CEO", 200000);
        boss.add(marketVP = new Employee("Marketing VP", 100000));
        boss.add(prodVP = new Employee("Production VP", 100000));
        marketVP.add(salesMgr = new Employee("Sales Mgr", 50000));
        marketVP.add(advMgr = new Employee("Advt Mgr", 50000));
        for (int i = 0; i < 5; i++) {
            salesMgr.add(new Employee("Sales " + new Integer(i).toString(),
                                      30000.0F + (float) (Math.random() - 0.5) * 10000));
        }
        advMgr.add(new Employee("Secy", 20000));
        prodVP.add(prodMgr = new Employee("Prod Mgr", 40000));
        prodVP.add(shipMgr = new Employee("Ship Mgr", 35000));
        for (int i = 0; i < 4; i++) {
            prodMgr.add(new Employee("Manuf " + new Integer(i).toString(),
                                     25000.0F + (float) (Math.random() - 0.5) * 5000));
        }
        for (int i = 0; i < 3; i++) {
            shipMgr.add(new Employee("ShipClrk " + new Integer(i).toString(),
                                     20000.0F + (float) (Math.random() - 0.5) * 5000));
        }
    }

    /**
     * Method description
     *
     *
     * @param evt
     */
    public void valueChanged(TreeSelectionEvent evt) {
        TreePath path = evt.getPath();
        String selectedTerm = path.getLastPathComponent().toString();
        Employee emp = boss.getChild(selectedTerm);
        if (emp != null) {
            cost.setText(new Float(emp.getSalaries()).toString());
        }
    }

    /**
     * Method description
     *
     *
     * @param argv
     */
    static public void main(String argv[]) {
        new EmployeeTree();
    }
}
