/*
 * @(#)ResultSet.java   2011-11-01
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

class ResultSet {
//  this class is a higher level abstraction
//  of the JDBC ResultSet object
    java.sql.ResultSet rs;
    java.sql.ResultSetMetaData rsmd;
    int numCols;

    /**
     * Constructs ...
     *
     *
     * @param rset
     */
    public ResultSet(java.sql.ResultSet rset) {
        rs = rset;
        try {
            // get the meta data and column count at once
            rsmd = rs.getMetaData();
            numCols = rsmd.getColumnCount();
        } catch (Exception e) {
            System.out.println("resultset error" + e.getMessage());
        }
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String[] getMetaData() {
        // returns an array of all the column names
        // or other meta data
        String md[] = new String[numCols];
        try {
            for (int i = 1; i <= numCols; i++) {
                md[i - 1] = rsmd.getColumnName(i);
            }
        } catch (Exception e) {
            System.out.println("meta data error" + e.getMessage());
        }

        return md;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public boolean hasMoreElements() {
        try {
            return rs.next();
        } catch (Exception e) {
            System.out.println("next error " + e.getMessage());

            return false;
        }
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String[] nextElement() {
        // copies contents of row into string array
        String[] row = new String[numCols];
        try {
            for (int i = 1; i <= numCols; i++) {
                row[i - 1] = rs.getString(i);
            }
        } catch (Exception e) {
            System.out.println("next element error" + e.getMessage());
        }

        return row;
    }

    /**
     * Method description
     *
     *
     * @param columnName
     *
     * @return
     */
    public String getColumnValue(String columnName) {
        String res = "";
        try {
            res = rs.getString(columnName);
        } catch (Exception e) {
            System.out.println("Column value error:" + columnName + e.getMessage());
        }

        return res;
    }

    /**
     * Method description
     *
     *
     * @param i
     *
     * @return
     */
    public String getColumnValue(int i) {
        String res = "";
        try {
            res = rs.getString(i);
        } catch (Exception e) {
            System.out.println("Column value error: " + i + " " + e.getMessage());
        }

        return res;
    }

    /**
     * Method description
     *
     */
    public void finalize() {
        try {
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
