/*
 * @(#)PrintTable.java   2011-11-01
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



package cooper.designpatterns.behavioral.interpreter;

import java.util.*;

//swing classes
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
public class PrintTable extends JScrollPane {
    JTable table;
    ProductModel pmodel;

    /**
     * Constructs ...
     *
     */
    public PrintTable() {
        pmodel = new ProductModel();
        table = new JTable(pmodel);
        getViewport().add(table);
    }

    /**
     * Method description
     *
     *
     * @param r
     * @param c
     */
    public void setDims(int r, int c) {
        pmodel.setSize(r, c);
    }

    /**
     * Method description
     *
     *
     * @param obj
     * @param row
     * @param col
     */
    public void setValueAt(Object obj, int row, int col) {
        pmodel.setValueAt(obj, row, col);
    }
}


class ProductModel implements TableModel {
    int rows, columns;
    Vector columnList;

    /**
     * Constructs ...
     *
     */
    public ProductModel() {
        columns = 0;
        rows = 0;
    }

    /**
     * Method description
     *
     *
     * @param r
     * @param cols
     */
    public void setSize(int r, int cols) {
        columns = cols;
        rows = r;
        columnList = new Vector(columns);
        for (int i = 0; i < columns; i++) {
            Vector v = new Vector(r);
            for (int j = 0; j < r; j++) {
                v.addElement("");
            }
            columnList.addElement(v);
        }
    }

    /**
     * Method description
     *
     *
     * @param obj
     * @param row
     * @param col
     */
    public void setValueAt(Object obj, int row, int col) {
        Vector v = (Vector) columnList.elementAt(col);
        v.setElementAt(obj, row);
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
     * @param row
     * @param col
     *
     * @return
     */
    public Object getValueAt(int row, int col) {
        Vector v = (Vector) columnList.elementAt(col);
        System.out.println(row + " " + v.elementAt(row));

        return v.elementAt(row);
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
