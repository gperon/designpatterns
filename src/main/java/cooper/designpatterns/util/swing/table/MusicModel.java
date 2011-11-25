/*
 * @(#)MusicModel.java   2011-11-01
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



package cooper.designpatterns.util.swing.table;

import javax.swing.table.*;

class MusicModel extends AbstractTableModel {
    String[] columnNames = { "Composer", "Title", "Orchestral" };
    Object[][] musicData = {
        { "Tschaikovsky", "1812 Overture", new Boolean(true) },
        { "Stravinsky", "Le Sacre", new Boolean(true) },
        { "Lennon", "Eleanor Rigby", new Boolean(false) },
        { "Wagner", "Gotterdammerung", new Boolean(true) }
    };
    int rowCount, columnCount;

    /**
     * Constructs ...
     *
     */
    public MusicModel() {
        rowCount = 4;
        columnCount = 3;
    }

    /**
     * Method description
     *
     *
     * @param col
     *
     * @return
     */
    public String getColumnName(int col) {
        return columnNames[col];
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getRowCount() {
        return rowCount;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getColumnCount() {
        return columnCount;
    }

    /**
     * Method description
     *
     *
     * @param col
     *
     * @return
     */
    public Class getColumnClass(int col) {
        return getValueAt(0, col).getClass();
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
    public boolean isCellEditable(int row, int col) {
        return (col > 1);
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
        musicData[row][col] = obj;
        fireTableCellUpdated(row, col);
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
        return musicData[row][col];
    }
}
