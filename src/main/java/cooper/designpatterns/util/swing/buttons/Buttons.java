/*
 * @(#)Buttons.java   2011-11-01
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



package cooper.designpatterns.util.swing.buttons;

import cooper.designpatterns.util.swing.JxFrame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class Buttons extends JxFrame implements ActionListener {
    JToolBar toolbar;
    JCheckBox YMCA, Rotary, ACLU;
    JRadioButton Rep, Dem, Flat;
    JButton Clear, Quit;

    /**
     * Constructs ...
     *
     */
    public Buttons() {
        super("Buttons and Checks");
        JPanel jp = new JPanel();
        getContentPane().add(jp);
        jp.setLayout(new BorderLayout());
        toolbar = new JToolBar();
        jp.add("North", toolbar);
        JPanel center = new JPanel();
        jp.add("Center", center);
        center.setLayout(new GridLayout(1, 2));
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        center.add(left);
        center.add(right);
        left.setLayout(new GridLayout(3, 1));
        right.setLayout(new GridLayout(3, 1));
        left.setBorder(new TitledBorder("Memberships"));
        right.setBorder(new TitledBorder("Party"));
        left.add(YMCA = new JCheckBox("YMCA"));
        left.add(Rotary = new JCheckBox("Rotary"));
        left.add(ACLU = new JCheckBox("ACLU"));
        right.add(Rep = new JRadioButton("Republicrat"));
        right.add(Dem = new JRadioButton("Demmican"));
        right.add(Flat = new JRadioButton("Flat Earth"));
        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(Rep);
        bgroup.add(Dem);
        bgroup.add(Flat);
        setBar();
        setSize(300, 200);
        setVisible(true);
    }

    private void setBar() {
        Clear = new ToolButton(new ImageIcon("erase.gif"));
        Quit = new ToolButton(new ImageIcon("stop.gif"));
        toolbar.add(Clear);
        Clear.setToolTipText("Clear all boxes");
        Quit.setToolTipText("Exit from program");
        toolbar.add(Quit);
        Clear.addActionListener(this);
        Quit.addActionListener(this);
        toolbar.addSeparator();
        JToggleButton a = new JToggleButton("a");
        JToggleButton b = new JToggleButton("b");
        JToggleButton c = new JToggleButton("c");
        toolbar.add(a);
        toolbar.add(b);
        toolbar.add(c);
        ButtonGroup tgroup = new ButtonGroup();
        tgroup.add(a);
        tgroup.add(b);
        tgroup.add(c);
    }

    /**
     * Method description
     *
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == Quit) {
            System.exit(0);
        }
        if (obj == Clear) {
            YMCA.setSelected(false);
            Rotary.setSelected(false);
            ACLU.setSelected(false);
            Rep.setSelected(false);
            Dem.setSelected(false);
            Flat.setSelected(false);
        }
    }

    /**
     * Method description
     *
     *
     * @param argv
     */
    static public void main(String argv[]) {
        new Buttons();
    }
}
