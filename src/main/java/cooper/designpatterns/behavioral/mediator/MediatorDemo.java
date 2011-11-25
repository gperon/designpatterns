/*
 * @(#)MediatorDemo.java   2011-11-01
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



package cooper.designpatterns.behavioral.mediator;

import cooper.designpatterns.util.swing.JxFrame;
import cooper.designpatterns.behavioral.command.Command;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class MediatorDemo extends JxFrame implements ActionListener {
    KidList kidList;
    PickedKidsList picked;
    KTextField tx;
    MoveButton move;
    ClearButton clear;
    Mediator med;

    /**
     * Constructs ...
     *
     */
    public MediatorDemo() {
        super("Mediator demo");
        Mediator med = new Mediator();
        JPanel jp = new JPanel();
        getContentPane().add(jp);
        jp.setLayout(new BorderLayout());
        JPanel center = new JPanel();
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        jp.add("Center", center);
        center.setLayout(new GridLayout(1, 2));
        center.add(left);
        center.add(right);
        left.setBorder(new EmptyBorder(5, 5, 5, 5));
        right.setBorder(new EmptyBorder(5, 5, 5, 5));
        kidList = new KidList(med);
        left.setLayout(new BorderLayout());
        left.add("Center", kidList);
        right.setLayout(new BorderLayout());
        tx = new KTextField(med);
        move = new MoveButton(this, med);
        clear = new ClearButton(this, med);
        JPanel rtop = new JPanel();
        jp.add("North", rtop);
        rtop.add(tx);
        rtop.add(move);
        rtop.add(clear);
        picked = new PickedKidsList(med);
        right.add("Center", picked);
        med.init();
        setSize(new Dimension(400, 300));
        setVisible(true);
    }

    /**
     * Method description
     *
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        Command comd = (Command) e.getSource();
        comd.execute();
    }

    /**
     * Method description
     *
     *
     * @param argv
     */
    static public void main(String argv[]) {
        new MediatorDemo();
    }
}
