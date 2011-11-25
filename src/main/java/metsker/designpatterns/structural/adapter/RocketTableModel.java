/*
 * @(#)RocketTableModel.java   2011-11-01
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



package metsker.designpatterns.structural.adapter;

/*
* Copyright (c) 2001, 2005. Steven J. Metsker.
*
* Steve Metsker makes no representations or warranties about
* the fitness of this software for any particular purpose,
* including the implied warranty of merchantability.
*
* Please use this software as you wish with the sole
* restriction that you may not claim that you wrote it.
 */
import javax.swing.table.*;

import metsker.designpatterns.util.firework.Rocket;

/**
 * Adapt a collection of rockets for display in a JTable.
 * @author Steven J. Metsker
 */
public class RocketTableModel extends AbstractTableModel {
    protected Rocket[] rockets;
    protected String[] columnNames = new String[] { "Name", "Price", "Apogee" };

    /**
     * Construct a rocket table from an array of rockets.
     * @param rockets an array of rockets
     */
    public RocketTableModel(Rocket[] rockets) {
        this.rockets = rockets;
    }

    /**
     *  @return the number of columns in this table.
     */
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     *
     * @param i
     * @return the name of the indicated column
     */
    public String getColumnName(int i) {
        return columnNames[i];
    }

    /**
     * @return the number of rows in this table.
     */
    public int getRowCount() {
        return rockets.length;
    }

    /**
     * @param row which row is interesting
     * @param col which column is interesting
     * @return the value at the indicated row and column.
     */
    public Object getValueAt(int row, int col) {
        switch (col) {
            case 0 :
                return rockets[row].getName();

            case 1 :
                return rockets[row].getPrice();

            case 2 :
                return new Double(rockets[row].getApogee());

            default :
                return null;
        }
    }
}
