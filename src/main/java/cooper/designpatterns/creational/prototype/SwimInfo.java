/*
 * @(#)SwimInfo.java   2011-11-01
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



package cooper.designpatterns.creational.prototype;

import java.awt.*;
import java.awt.event.*;

import cooper.designpatterns.util.swing.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class SwimInfo extends JxFrame implements ActionListener {
    SwimData sdata, sxdata = null;
    List swList, cloneList;
    Button clone, refresh, quit;
    Swimmer sw;

    /**
     * Constructs ...
     *
     */
    public SwimInfo() {
        super("Prototype example");
        sdata = new SwimData("Swimmers.txt");
//      sdata = new SwimmerNoSex("Swimmers.txt");
        setGUI();
        loadSwimmerList();
    }

    /**
     * Method description
     *
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == clone) {
            cloneAndLoad();
        }
        if (obj == refresh) {
            loadSwimmerList();
        }
        if (obj == quit) {
            System.exit(0);
        }
    }

    private void cloneAndLoad() {
        // sxdata = (SwimData)sdata.deepClone();
        sxdata = (SwimData) sdata.clone();
        sxdata.sortByTime();
        cloneList.removeAll();
        // now print out sorted values from clone
        for (int i = 0; i < sxdata.size(); i++) {
            sw = sxdata.getSwimmer(i);
            cloneList.add(sw.toString());
        }
    }

    private void loadSwimmerList() {
        swList.removeAll();
        for (int i = 0; i < sdata.size(); i++) {
            sw = sdata.getSwimmer(i);
            swList.add(sw.toString());
        }
    }

    private void setGUI() {
        setLayout(new GridLayout(1, 3));
        setBackground(Color.lightGray);
        swList = new List(15);
        cloneList = new List(15);
        Panel cp = new Panel();
        add(swList);
        add(cp);
        add(cloneList);
        clone = new Button("Clone -->");
        refresh = new Button("<--Refresh");
        quit = new Button("Quit");
        cp.setLayout(new GridLayout(3, 1));
        Panel p1 = new Panel();
        cp.add(p1);
        p1.add(clone);
        Panel p2 = new Panel();
        cp.add(p2);
        p2.add(refresh);
        Panel p3 = new Panel();
        cp.add(p3);
        p3.add(quit);
        clone.addActionListener(this);
        refresh.addActionListener(this);
        quit.addActionListener(this);
        setBounds(100, 100, 500, 400);
        setVisible(true);
    }

    /**
     * Method description
     *
     *
     * @param argv
     */
    static public void main(String argv[]) {
        new SwimInfo();
    }
}
