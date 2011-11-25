/*
 * @(#)TwoList.java   2011-11-01
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
//Demonstratio of simple Two-list program
//using awt controls

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class TwoList extends Frame implements ActionListener {
    private Button Add, MoveRight, MoveLeft;
    private List leftList, rightList;
    private TextField txt;

    /**
     * Constructs ...
     *
     */
    public TwoList() {
        super("Two Lists");
        setCloseClick();
        setGUI();
    }

    // --------------------------------------------
    private void setGUI() {
        setLayout(new GridLayout(1, 2));    // two columns
        setBackground(Color.lightGray);
        Panel pLeft = new Panel();
        Panel pRight = new Panel();
        add(pLeft);
        add(pRight);
        pLeft.setLayout(new BorderLayout());
        // top panel contains text field and
        // Insert buttn
        Panel pTop = new Panel();
        pLeft.add("North", pTop);
        txt = new TextField(10);
        pTop.add(txt);
        Add = new Button("Insert");
        pTop.add(Add);
        // right border contains add and remove buttons
        Panel rBorder = new Panel();
        rBorder.setLayout(new GridLayout(2, 1));
        MoveRight = new Button("Add --->");
        MoveLeft = new Button("<--- Remove");
        Panel rbTop = new Panel();
        rbTop.add(MoveRight);
        rBorder.add(rbTop);
        Panel rbBot = new Panel();
        rbBot.add(MoveLeft);
        rBorder.add(rbBot);
        pLeft.add("East", rBorder);
        leftList = new List(10);
        pLeft.add("Center", leftList);
        rightList = new List(10);
        pRight.add(rightList);
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

    // ---------------------------------------------

    /**
     * Method description
     *
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();
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
        new TwoList();
    }
}
