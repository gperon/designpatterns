/*
 * @(#)JTwoList.java   2011-11-01
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



package cooper.designpatterns.structural.adapter;
//Demonstratiob of simple Two-list program
//using JFC controls

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class JTwoList extends JFrame implements ActionListener {
    private JButton Add, MoveRight, MoveLeft;
    private JawtList leftList, rightList;
    private TextField txt;

    /**
     * Constructs ...
     *
     */
    public JTwoList() {
        super("Two Lists");
        setLF();            // set look and feel
        setCloseClick();    // Window exits on close-click
        setGUI();
    }

    // --------------------------------------------
    private void setGUI() {
        getContentPane().setLayout(new GridLayout(1, 2));    // two columns
        setBackground(Color.lightGray);
        JPanel pLeft = new JPanel();
        JPanel pRight = new JPanel();
        getContentPane().add(pLeft);
        getContentPane().add(pRight);
        pLeft.setLayout(new BorderLayout());
        JPanel pTop = new JPanel();
        pLeft.add("North", pTop);
        txt = new TextField(15);
        pTop.add(txt);
        Add = new JButton("Insert");
        Add.setMargin(new Insets(0, 0, 0, 0));
        pTop.add(Add);
        JPanel rBorder = new JPanel();
        rBorder.setLayout(new GridLayout(2, 1));
        MoveRight = new JButton("Add --->");
        MoveLeft = new JButton("<--- Remove");
        JPanel rbTop = new JPanel();
        rbTop.add(MoveRight);
        rBorder.add(rbTop);
        JPanel rbBot = new JPanel();
        rbBot.add(MoveLeft);
        rBorder.add(rbBot);
        pLeft.add("East", rBorder);
        leftList = new JawtList(15);
        pLeft.add("Center", leftList);
        rightList = new JawtList(15);
        pRight.setLayout(new BorderLayout());
        pRight.add("Center", rightList);
        // Add button action listenes
        Add.addActionListener(this);
        MoveRight.addActionListener(this);
        MoveLeft.addActionListener(this);
        setSize(new Dimension(400, 300));
        setVisible(true);
    }

    // -----------------------------------------
    private void setCloseClick() {
        // create window listener to respond to window close click
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // ------------------------------------------
    private void setLF() {
        // Force SwingApp to come up in the System L&F
        String laf = UIManager.getSystemLookAndFeelClassName();
        try {
            UIManager.setLookAndFeel(laf);
        } catch (UnsupportedLookAndFeelException exc) {
            System.err.println("Warning: UnsupportedLookAndFeel: " + laf);
        } catch (Exception exc) {
            System.err.println("Error loading " + laf + ": " + exc);
        }
    }

    // ---------------------------------------------

    /**
     * Method description
     *
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if (b == Add) {
            addName();
        }
        if (b == MoveRight) {
            moveNameRight();
        }
        if (b == MoveLeft) {
            moveNameLeft();
        }
    }

    // --------------------------------------------
    private void addName() {
        if (txt.getText().length() > 0) {
            leftList.add(txt.getText());
            txt.setText("");
        }
    }

    // --------------------------------------------
    private void moveNameRight() {
        String sel[] = leftList.getSelectedItems();
        if (sel != null) {
            rightList.add(sel[0]);
            leftList.remove(sel[0]);
        }
    }

    // --------------------------------------------

    /**
     * Method description
     *
     */
    public void moveNameLeft() {
        String sel[] = rightList.getSelectedItems();
        if (sel != null) {
            leftList.add(sel[0]);
            rightList.remove(sel[0]);
        }
    }

    // --------------------------------------------

    /**
     * Method description
     *
     *
     * @param argv
     */
    static public void main(String argv[]) {
        new JTwoList();
    }
}
