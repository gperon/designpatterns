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

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import java.util.Vector;

/**
 * Class description
 *
 * @author <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 * @version 0.1.1, 2011-11-01
 */
public class PrintTable extends JScrollPane {
    JTable table;
    ProductModel pmodel;

    public PrintTable() {
        pmodel = new ProductModel();
        table = new JTable(pmodel);
        getViewport().add(table);
    }

    public void setDims(int r, int c) {
        pmodel.setSize(r, c);
    }

    public void setValueAt(Object obj, int row, int col) {
        pmodel.setValueAt(obj, row, col);
    }
}


class ProductModel implements TableModel {
    int rows;
    int columns;
    List<List<String>> columnList;

    public ProductModel() {
        columns = 0;
        rows = 0;
    }

    public void addTableModelListener(TableModelListener tbm) {}

    public void removeTableModelListener(TableModelListener tbm) {}

    public boolean isCellEditable(int r, int c) {
        return false;
    }

    public Class getColumnClass(int c) {
        return ("").getClass();
    }

    public int getColumnCount() {
        return columns;
    }

    public String getColumnName(int c) {
        return "";
    }

    public int getRowCount() {
        return rows;
    }

    public void setSize(int r, int cols) {
        columns = cols;
        rows = r;
        columnList = new ArrayList<>(columns);
        for (int i = 0; i < columns; i++) {
            List<String> v = new ArrayList<>(r);
            for (int j = 0; j < r; j++) {
                v.add("");
            }
            columnList.add(v);
        }
    }

    public Object getValueAt(int row, int col) {
        List<String> v = columnList.get(col);

        return v.get(row);
    }

    public void setValueAt(Object obj, int row, int col) {
        List<String> v = columnList.get(col);
        v.add(row, (String) obj);
    }
}
