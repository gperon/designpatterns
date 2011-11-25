/*
 * @(#)MoveATub2.java   2011-11-01
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



package metsker.designpatterns.behavioral.mediator;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import metsker.designpatterns.util.ui.SwingFacade;
import metsker.designpatterns.util.ui.UI;

/**
 * This class is refactored, show a mediator class, factoring the action logic
 * out of this class.
 */
public class MoveATub2 extends JPanel {
    private NameBase data = new NameBase();
    private JList boxList;
    private JList tubList;
    private JList machineList;
    private JButton assignButton;
    private UI ui = UI.NORMAL;
    MoveATubMediator mediator;

    /**
     * Method description
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = SwingFacade.launch(new MoveATub2(), "Move a Tub");
        frame.setSize(600, 250);
        frame.validate();
    }

    /**
     * Constructs ...
     *
     */
    public MoveATub2() {
        super(new GridLayout(1, 4));
        mediator = new MoveATubMediator(this, data);
        setFont(ui.getFont());
        this.add(labeledPanel("From Machine...", boxList()));
        this.add(labeledPanel("Move Tub...", tubList()));
        this.add(labeledPanel("To Machine...", machineList()));
        this.add(buttonPanel(assignButton()));
    }

    private Component buttonPanel(JButton button) {
        JPanel result = new JPanel(new GridLayout(3, 1));
        result.add(new JLabel(" "));
        JPanel innerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        innerPanel.add(button);
        result.add(innerPanel);
        result.add(new JLabel(" "));

        return result;
    }

    private Component labeledPanel(String label, JList list) {
        JPanel result = new JPanel(new BorderLayout());
        result.add(new JLabel(label), BorderLayout.NORTH);
        result.add(new JScrollPane(list), BorderLayout.CENTER);
        int borderWidth = 15;
        result.setBorder(BorderFactory.createEmptyBorder(borderWidth, borderWidth, borderWidth,
                borderWidth));

        return result;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public JList boxList() {
        if (boxList == null) {
            boxList = ui.createList(data.boxes());
            boxList.addListSelectionListener(mediator);
        }

        return boxList;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public JList machineList() {
        if (machineList == null) {
            machineList = ui.createList(data.boxes());
            machineList.addListSelectionListener(mediator);
        }

        return machineList;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public JList tubList() {
        if (tubList == null) {
            tubList = ui.createList(new String[] {});
            tubList.addListSelectionListener(mediator);
        }

        return tubList;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public JButton assignButton() {
        if (assignButton == null) {
            assignButton = new JButton("Do it!");
            assignButton.setEnabled(false);
            assignButton.addActionListener(mediator);
        }

        return assignButton;
    }
}
