/*
 * @(#)ProductTable.java   2011-11-01
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



package cooper.designpatterns.structural.bridge;

import java.util.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class ProductTable extends JScrollPane {
    JTable table;

    /**
     * Constructs ...
     *
     *
     * @param list
     */
    public ProductTable(Vector list) {
        table = new JTable(new prodModel(list));
        getViewport().add(table);
    }
}


class prodModel implements TableModel {
    int rows, columns;
    Vector prodNames, quantities;

    /**
     * Constructs ...
     *
     *
     * @param products
     */
    public prodModel(Vector products) {
        rows = products.size();
        columns = 2;
        prodNames = new Vector();
        quantities = new Vector();
        for (int i = 0; i < products.size(); i++) {
            String s = (String) products.elementAt(i);
            int index = s.indexOf("--");    // separate qty from name
            if (index > 0) {
                prodNames.addElement(s.substring(0, index));
                quantities.addElement(s.substring(index + 2).trim());
            } else {
                prodNames.addElement(s);
            }
        }
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getColumnCount() {
        return columns;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getRowCount() {
        return rows;
    }

    /**
     * Method description
     *
     *
     * @param r
     * @param c
     *
     * @return
     */
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0 :
                return prodNames.elementAt(r);

            case 1 :
                return quantities.elementAt(r);

            default :
                return prodNames.elementAt(r);
        }
    }

    /**
     * Method description
     *
     *
     * @param c
     *
     * @return
     */
    public Class getColumnClass(int c) {
        return (new String("")).getClass();
    }

    /**
     * Method description
     *
     *
     * @param r
     * @param c
     *
     * @return
     */
    public boolean isCellEditable(int r, int c) {
        return false;
    }

    /**
     * Method description
     *
     *
     * @param c
     *
     * @return
     */
    public String getColumnName(int c) {
        return "";
    }

    /**
     * Method description
     *
     *
     * @param obj
     * @param r
     * @param c
     */
    public void setValueAt(Object obj, int r, int c) {}

    /**
     * Method description
     *
     *
     * @param tbm
     */
    public void addTableModelListener(TableModelListener tbm) {}

    /**
     * Method description
     *
     *
     * @param tbm
     */
    public void removeTableModelListener(TableModelListener tbm) {}
}
