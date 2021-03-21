/*
 * @(#)JawtList.java   2011-11-01
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

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Vector;

class JListData extends AbstractListModel {
    private Vector data;

    /**
     * Constructs ...
     */
    public JListData() {
        data = new Vector();
    }

    /**
     * Method description
     *
     * @param s
     */
    public void addElement(String s) {
        data.addElement(s);
        fireIntervalAdded(this, data.size() - 1, data.size());
    }

    /**
     * Method description
     */
    public void clear() {
        int size = data.size();

        data = new Vector();
        fireIntervalRemoved(this, 0, size);
    }

    /**
     * Method description
     *
     * @param s
     */
    public void removeElement(String s) {
        data.removeElement(s);
        fireIntervalRemoved(this, 0, data.size());
    }

    /**
     * Method description
     *
     * @param index
     * @return
     */
    public Object getElementAt(int index) {
        return data.elementAt(index);
    }

    /**
     * Method description
     *
     * @return
     */
    public int getSize() {
        return data.size();
    }
}


//this is a simple adapter class to
//convert List awt methods to Swing methods

/**
 * Class description
 *
 * @author <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 * @version 0.1.1, 2011-11-01
 */
public class JawtList extends JScrollPane implements ListSelectionListener, AwtList {
    private final JList listWindow;
    private final JListData listContents;

    /**
     * Constructs ...
     *
     * @param rows
     */
    public JawtList(int rows) {
        listContents = new JListData();
        listWindow = new JList(listContents);
        listWindow.setPrototypeCellValue("Abcdefg Hijkmnop");
        getViewport().add(listWindow);
    }

    /**
     * Method description
     *
     * @param s
     */
    public void add(String s) {
        listContents.addElement(s);
    }

    /**
     * Method description
     *
     * @param iList
     */
    public void addListSelectionListener(ListSelectionListener iList) {
        listWindow.addListSelectionListener(iList);
    }

    /**
     * Method description
     */
    public void clear() {
        listContents.clear();
    }

    /**
     * Method description
     */
    public void clearSelection() {
        listWindow.clearSelection();
    }

    /**
     * Method description
     *
     * @param s
     */
    public void remove(String s) {
        listContents.removeElement(s);
    }

    /**
     * Method description
     *
     * @param e
     */
    public void valueChanged(ListSelectionEvent e) {
    }

    /**
     * Method description
     *
     * @return
     */
    public String[] getSelectedItems() {
        Object[] obj = listWindow.getSelectedValues();
        String[] s = new String[obj.length];

        for (int i = 0; i < obj.length; i++) {
            s[i] = obj[i].toString();
        }

        return s;
    }

    /**
     * Method description
     *
     * @return
     */
    public Object getSelectedValue() {
        return listWindow.getSelectedValue();
    }
}
