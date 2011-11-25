/*
 * @(#)QueryDialog.java   2011-11-01
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



package cooper.designpatterns.structural.facade;

import java.util.*;

import java.awt.*;
import java.awt.event.*;

class QueryDialog extends Dialog implements ActionListener {
    ResultSet results;
    Button OK;
    textPanel pc;
    Vector tables;

    /**
     * Constructs ...
     *
     *
     * @param f
     * @param r
     */
    public QueryDialog(Frame f, ResultSet r) {
        super(f, "Query Result");
        results = r;
        setLayout(new BorderLayout());
        OK = new Button("OK");
        Panel p = new Panel();
        add("South", p);
        p.add(OK);
        OK.addActionListener(this);
        pc = new textPanel();
        pc.setBackground(Color.white);
        add("Center", pc);
        makeTables();
        setBounds(100, 100, 500, 300);
        setVisible(true);
        repaint();
    }

    private void makeTables() {
        tables = new Vector();
        String t[] = results.getMetaData();
        tables.addElement(t);
        while (results.hasMoreElements()) {
            tables.addElement(results.nextElement());
        }
    }

    /**
     * Method description
     *
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    class textPanel extends Panel {

        /**
         * Method description
         *
         *
         * @param g
         */
        public void paint(Graphics g) {
            String s[];
            int x = 0;
            int y = g.getFontMetrics().getHeight();
            int deltaX = (int) 1.5f * (g.getFontMetrics().stringWidth("wwwwwwwwwwwwww"));
            for (int i = 0; i < tables.size(); i++) {
                s = (String[]) tables.elementAt(i);
                for (int j = 0; j < s.length; j++) {
                    String st = s[j];
                    g.drawString(st, x, y);
                    x += deltaX;
                }
                x = 0;
                y += g.getFontMetrics().getHeight();
                if (i == 0) {
                    y += g.getFontMetrics().getHeight();
                }
            }
        }
    }
}
