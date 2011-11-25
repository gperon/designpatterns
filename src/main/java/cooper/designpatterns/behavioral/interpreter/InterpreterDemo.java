/*
 * @(#)InterpreterDemo.java   2011-11-01
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



package cooper.designpatterns.behavioral.interpreter;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class InterpreterDemo extends JxFrame implements ActionListener {
    JButton go;
    JTextField tx;
    KidData kdata;
    JawtList ptable;

    /**
     * Constructs ...
     *
     */
    public InterpreterDemo() {
        super("Interpreter Demo");
        tx = new JTextField(20);
        tx.setText("print frname lname age club time");
        go = new JButton("Go");
        JLabel hlp = new JLabel("Ex: print frname age sortby age");
        JPanel p = new JPanel();
        getContentPane().add(p);
        p.setLayout(new BorderLayout());
        JPanel np = new JPanel();
        np.setLayout(new BorderLayout());
        JPanel nnp = new JPanel();
        p.add("North", np);
        nnp.add(tx);
        nnp.add(go);
        np.add("North", nnp);
        np.add("Center", hlp);
        go.addActionListener(this);
        ptable = new JawtList(20);
        p.add("Center", ptable);
        kdata = new KidData("50free.txt");
        setSize(new Dimension(400, 200));
        setVisible(true);
    }

    /**
     * Method description
     *
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        Parser p = new Parser(tx.getText());
        p.setData(kdata, ptable);
        p.execute();
    }

    /**
     * Method description
     *
     *
     * @param argv
     */
    static public void main(String argv[]) {
        new InterpreterDemo();
    }
}
