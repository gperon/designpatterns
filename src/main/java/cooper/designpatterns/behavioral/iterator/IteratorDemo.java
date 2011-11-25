/*
 * @(#)IteratorDemo.java   2011-11-01
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



package cooper.designpatterns.behavioral.iterator;

import cooper.designpatterns.util.swing.JxFrame;
import cooper.designpatterns.structural.adapter.JawtList;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

import java.util.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class IteratorDemo extends JxFrame implements ActionListener {
    JawtList kidList, kidClubList;
    JComboBox tx;
    JButton get;
    KidData kdata;

    /**
     * Constructs ...
     *
     */
    public IteratorDemo() {
        super("Iterator demo");
        JPanel jp = new JPanel();
        getContentPane().add(jp);
        jp.setLayout(new GridLayout(1, 2));
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        jp.add(left);
        jp.add(right);
        left.setBorder(new EmptyBorder(5, 5, 5, 5));
        right.setBorder(new EmptyBorder(5, 5, 5, 5));
        kidList = new JawtList(20);
        left.setLayout(new BorderLayout());
        left.add("Center", kidList);
        right.setLayout(new BorderLayout());
        JLabel lbl = new JLabel("Club:");
        get = new JButton("Get");
        get.addActionListener(this);
        JPanel rtop = new JPanel();
        right.add("North", rtop);
        rtop.add(lbl);
        kidClubList = new JawtList(20);
        right.add("Center", kidClubList);
        kdata = new KidData("50free.txt");
        fillKidList();
        tx = new JComboBox(getClubs());
        tx.setEditable(false);
        rtop.add(tx);
        rtop.add(get);
        setSize(new Dimension(400, 300));
        setVisible(true);
    }

    private void fillKidList() {
        Enumeration ekid = kdata.elements();
        while (ekid.hasMoreElements()) {
            Kid k = (Kid) ekid.nextElement();
            kidList.add(k.getFrname() + " " + k.getLname());
        }
    }

    private Object[] getClubs() {
        Enumeration ekid = kdata.elements();
        Set clubs = new HashSet();
        while (ekid.hasMoreElements()) {
            Kid k = (Kid) ekid.nextElement();
            clubs.add(k.getClub());
        }

        return clubs.toArray();
    }

    /**
     * Method description
     *
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        String club = (String) tx.getSelectedItem();
        if (club.trim().length() > 0) {
            kidClubList.clear();
            Enumeration eclub = kdata.kidsInClub(club);
            while (eclub.hasMoreElements()) {
                Kid k = (Kid) eclub.nextElement();
                kidClubList.add(k.getFrname() + " " + k.getLname());
            }
        }
    }

    /**
     * Method description
     *
     *
     * @param argv
     */
    static public void main(String argv[]) {
        new IteratorDemo();
    }
}
