/*
 * @(#)JListADemo.java   2011-11-01
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



package cooper.designpatterns.util.swing.jlist;

import cooper.designpatterns.util.swing.JxFrame;

import java.awt.*;
import java.awt.event.*;

import java.util.*;

import javax.swing.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class JListADemo extends JxFrame implements ActionListener {
    JTextField text;
    JList list;
    JButton Add;
    Vector dlist;

    /**
     * Constructs ...
     *
     */
    public JListADemo() {
        super("JList demo");
        JPanel jp = new JPanel();
        getContentPane().add(jp);
        jp.setLayout(new BorderLayout());
        // create text field
        text = new JTextField(20);
        jp.add("North", text);
        // Add button
        Add = new JButton("Add");
        JPanel p = new JPanel();
        jp.add("South", p);
        p.add(Add);
        Add.addActionListener(this);
        // create scroll pane
        JScrollPane sp = new JScrollPane();
        jp.add("Center", sp);    // add to layout
        list = new JList(makeData());    // create list with data
        sp.getViewport().add(list);    // add list to scrollpane
        setSize(200, 200);
        setVisible(true);
    }

    private Vector makeData() {
        dlist = new Vector();    // create vector
        dlist.addElement("Anchovies");    // and add data
        dlist.addElement("Bananas");
        dlist.addElement("Cilantro");
        dlist.addElement("Doughnuts");
        dlist.addElement("Escarole");

        return dlist;
    }

    /**
     * Method description
     *
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        dlist.addElement(text.getText());
        list.setListData(dlist);
        list.repaint();
    }

    /**
     * Method description
     *
     *
     * @param arv
     */
    static public void main(String[] arv) {
        new JListADemo();
    }
}
