/*
 * @(#)JclassAwtList.java   2011-11-01
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

import cooper.designpatterns.util.swing.AwtList;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//this is a simple adapter class to
//convert List awt methods to Swing methods

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class JclassAwtList extends JList implements ListSelectionListener, AwtList {
    private JListData listContents;

//  -----------------------------------------

    /**
     * Constructs ...
     *
     *
     * @param rows
     */
    public JclassAwtList(int rows) {
        listContents = new JListData();
        setModel(listContents);
        setPrototypeCellValue("Abcdefg Hijkmnop");
    }

//  -----------------------------------------

    /**
     * Method description
     *
     *
     * @param s
     */
    public void add(String s) {
        listContents.addElement(s);
    }

//  -----------------------------------------

    /**
     * Method description
     *
     *
     * @param s
     */
    public void remove(String s) {
        listContents.removeElement(s);
    }

//  -----------------------------------------

    /**
     * Method description
     *
     *
     * @return
     */
    public String[] getSelectedItems() {
        Object[] obj = getSelectedValues();
        String[] s = new String[obj.length];
        for (int i = 0; i < obj.length; i++) {
            s[i] = obj[i].toString();
        }

        return s;
    }

//  -----------------------------------------

    /**
     * Method description
     *
     *
     * @param e
     */
    public void valueChanged(ListSelectionEvent e) {}
}
