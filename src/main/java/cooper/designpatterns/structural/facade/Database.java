/*
 * @(#)Database.java   2011-11-01
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

import java.sql.*;

import java.util.*;

class Database {
    Connection con;
    ResultSet results;
    ResultSetMetaData rsmd;
    DatabaseMetaData dma;
    String catalog;
    String types[];
    String database_url;

    /**
     * Constructs ...
     *
     *
     * @param driver
     */
    public Database(String driver) {
        types = new String[1];
        types[0] = "TABLES";    // initialize type array
        try {
            Class.forName(driver);
        }    // load the Bridge driver
                catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method description
     *
     */
    public void close() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("close error");
        }
    }

    /**
     * Method description
     *
     *
     * @param url
     * @param cat
     */
    public void open(String url, String cat) {
        catalog = cat;
        database_url = url;
        try {
            con = DriverManager.getConnection(url);
            dma = con.getMetaData();    // get the meta data
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method description
     *
     */
    public void reOpen() {
        try {
            con = DriverManager.getConnection(database_url);
            dma = con.getMetaData();    // get the meta data
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String[] getTableNames() {
        String[] tbnames = null;
        Vector tname = new Vector();
        // add the table names to a Vector
        // since we don't know how many there are
        try {
            results = new ResultSet(dma.getTables(catalog, null, "%", types));
        } catch (Exception e) {
            System.out.println(e);
        }
        while (results.hasMoreElements()) {
            tname.addElement(results.getColumnValue("TABLE_NAME"));
        }
        // copy the table names into a String array
        tbnames = new String[tname.size()];
        for (int i = 0; i < tname.size(); i++) {
            tbnames[i] = (String) tname.elementAt(i);
        }

        return tbnames;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String[] getTableMetaData() {
        // return the table type information
        results = null;
        try {
            results = new ResultSet(dma.getTables(catalog, null, "%", types));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return results.getMetaData();
    }

    /**
     * Method description
     *
     *
     * @param tablename
     *
     * @return
     */
    public String[] getColumnMetaData(String tablename) {
        // return the data on a column
        results = null;
        try {
            results = new ResultSet(dma.getColumns(catalog, null, tablename, null));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return results.getMetaData();
    }

    /**
     * Method description
     *
     *
     * @param table
     *
     * @return
     */
    public String[] getColumnNames(String table) {
        // return an array of Column names
        String[] tbnames = null;
        Vector tname = new Vector();
        try {
            results = new ResultSet(dma.getColumns(catalog, null, table, null));
            while (results.hasMoreElements()) {
                tname.addElement(results.getColumnValue("COLUMN_NAME"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        tbnames = new String[tname.size()];
        for (int i = 0; i < tname.size(); i++) {
            tbnames[i] = (String) tname.elementAt(i);
        }

        return tbnames;
    }

    /**
     * Method description
     *
     *
     * @param table
     * @param columnName
     *
     * @return
     */
    public String getColumnValue(String table, String columnName) {
        // return the value of a given column
        String res = null;
        try {
            if (table.length() > 0) {
                results = execute("Select " + columnName + " from " + table + " order by "
                                  + columnName);
            }
            if (results.hasMoreElements()) {
                res = results.getColumnValue(columnName);
            }
        } catch (Exception e) {
            System.out.println("Column value error" + columnName + e.getMessage());
        }

        return res;
    }

    /**
     * Method description
     *
     *
     * @param columnName
     *
     * @return
     */
    public String getNextValue(String columnName) {
        // return the next value in that column
        // using the remembered resultSet
        String res = "";
        try {
            if (results.hasMoreElements()) {
                res = results.getColumnValue(columnName);
            }
        } catch (Exception e) {
            System.out.println("next value error" + columnName + e.getMessage());
        }

        return res;
    }

    /**
     * Method description
     *
     *
     * @param sql
     *
     * @return
     */
    public ResultSet execute(String sql) {
        // execute an SQL query on this database
        results = null;
        try {
            Statement stmt = con.createStatement();
            results = new ResultSet(stmt.executeQuery(sql));
        } catch (Exception e) {
            System.out.println("execute error: " + e.getMessage());
        }

        return results;
    }
}
