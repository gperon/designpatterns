/*
 * @(#)SimpleJFC2.java   2011-11-01
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



package cooper.designpatterns.util.swing.simple;

import cooper.designpatterns.util.swing.JxFrame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class SimpleJFC2 extends JxFrame implements ActionListener {
    JButton OK, Quit;
    JPanel jp;
    Color color;

    /**
     * Constructs ...
     *
     */
    public SimpleJFC2() {
        super("Simple JFC Program");
        color = Color.yellow;
        setGUI();
    }

    private void setGUI() {
        jp = new JPanel();
        getContentPane().add(jp);
        // create and add buttons
        OK = new JButton("OK", new ImageIcon("color.gif"));
        OK.setRolloverIcon(new ImageIcon("overColor.gif"));
        OK.setToolTipText("Change background color");
        Quit = new JButton("Quit", new ImageIcon("exit.gif"));
        Quit.setToolTipText("Exit from program");
        OK.addActionListener(this);
        Quit.addActionListener(this);
        jp.add(OK);
        jp.add(Quit);
        setSize(new Dimension(250, 100));
        setVisible(true);
    }

    /**
     * Method description
     *
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == OK) {
            switchColors();
        }
        if (obj == Quit) {
            System.exit(0);
        }
    }

    private void switchColors() {
        if (color == Color.green) {
            color = Color.yellow;
        } else {
            color = Color.green;
        }
        jp.setBackground(color);
        repaint();
    }

    /**
     * Method description
     *
     *
     * @param argv
     */
    static public void main(String[] argv) {
        new SimpleJFC2();
    }
}
