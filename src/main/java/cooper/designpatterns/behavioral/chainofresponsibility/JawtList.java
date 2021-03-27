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


package cooper.designpatterns.behavioral.chainofresponsibility;

import cooper.designpatterns.util.swing.AwtList;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class JListData extends AbstractListModel<String> {
    private final List<String> data;

    public JListData() {
        data = new ArrayList<>();
    }

    public void addElement(String s) {
        data.add(s);
        fireIntervalAdded(this, data.size() - 1, data.size());
    }

    public void removeElement(String s) {
        data.remove(s);
        fireIntervalRemoved(this, 0, data.size());
    }

    public String getElementAt(int index) {
        return data.get(index);
    }

    public int getSize() {
        return data.size();
    }
}



/**
 * This is a simple adapter class to
 * convert List awt methods to Swing methods
 *
 * @author <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 * @version 0.1.1, 2011-11-01
 */
public class JawtList extends JScrollPane implements ListSelectionListener, AwtList {
    private final JList<String> listWindow;
    private final JListData listContents;

    public JawtList() {
        listContents = new JListData();
        listWindow = new JList<>(listContents);
        listWindow.setPrototypeCellValue("Abcdefg Hijkmnop");
        getViewport().add(listWindow);
    }

    public void add(String s) {
        listContents.addElement(s);
    }

    public void remove(String s) {
        listContents.removeElement(s);
    }

    public void valueChanged(ListSelectionEvent e) {
    }

    public void setSelectedIndex(int i) {
        listWindow.setSelectedIndex(i);
        listWindow.ensureIndexIsVisible(i);
    }

    public String[] getSelectedItems() {
        Object[] obj = listWindow.getSelectedValues();
        String[] s = new String[obj.length];

        for (int i = 0; i < obj.length; i++) {
            s[i] = obj[i].toString();
        }

        return s;
    }
}
