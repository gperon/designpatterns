/*
 * @(#)DbFrame.java   2011-11-01
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

import java.awt.*;
import java.awt.event.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class DbFrame extends Frame implements ActionListener, ItemListener {
    Database db;
    java.awt.List Tables, Columns, Data;
    TextArea query;
    Button Search, Quit;

    /**
     * Constructs ...
     *
     */
    public DbFrame() {
        super("Database demonstration");
        setGUI();
        db = new Database("sun.jdbc.odbc.JdbcOdbcDriver");
        db.open("jdbc:odbc:Grocery prices", null);
        String tnames[] = db.getTableNames();
        loadList(Tables, tnames);
        String queryText =
            "SELECT DISTINCTROW FoodName, StoreName, Price "
            + "FROM (Food INNER JOIN FoodPrice ON Food.FoodKey = FoodPrice.FoodKey) "
            + "INNER JOIN Stores ON FoodPrice.StoreKey = Stores.StoreKey "
            + "WHERE (((Food.FoodName)=\'Oranges\')) ORDER BY FoodPrice.Price;";
        query.setText(queryText);
    }

    private void setGUI() {
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        Panel pn = new Panel();
        add("North", pn);
        pn.setLayout(new GridLayout(1, 3));
        pn.add(new Label("Tables"));
        pn.add(new Label("Columns"));
        pn.add(new Label("Data"));
        Panel pc = new Panel();
        add("Center", pc);
        pc.setLayout(new GridLayout(1, 3));
        pc.add(Tables = new java.awt.List(15));
        pc.add(Columns = new java.awt.List(15));
        pc.add(Data = new java.awt.List(15));
        Tables.addItemListener(this);
        Columns.addItemListener(this);
        Panel ps = new Panel();
        add("South", ps);
        ps.add(query = new TextArea("", 3, 40));
        addPanel(ps, Search = new Button("Run Query"));
        addPanel(ps, Quit = new Button("Quit"));
        Search.addActionListener(this);
        Quit.addActionListener(this);
        setBounds(100, 100, 500, 300);
        setVisible(true);
    }

    private void addPanel(Panel ps, Component c) {
        Panel p = new Panel();
        ps.add(p);
        p.add(c);
    }

    private void loadList(java.awt.List list, String[] s) {
        list.removeAll();
        for (int i = 0; i < s.length; i++) {
            list.add(s[i]);
        }
    }


    /**
     * Method description
     *
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == Quit) {
            System.exit(0);
        }
        if (obj == Search) {
            clickedSearch();
        }
    }


    /**
     * Method description
     *
     *
     * @param e
     */
    public void itemStateChanged(ItemEvent e) {
        Object obj = e.getSource();
        if (obj == Tables) {
            showColumns();
        }
        if (obj == Columns) {
            showData();
        }
    }

    private void showColumns() {
        String cnames[] = db.getColumnNames(Tables.getSelectedItem());
        loadList(Columns, cnames);
    }

    private void showData() {
        String colname = Columns.getSelectedItem();
        String colval = db.getColumnValue(Tables.getSelectedItem(), colname);
        Data.setVisible(false);
        Data.removeAll();
        Data.setVisible(true);
        colval = db.getNextValue(Columns.getSelectedItem());
        while (colval.length() > 0) {
            Data.add(colval);
            colval = db.getNextValue(Columns.getSelectedItem());
        }
    }

    private void clickedSearch() {
        ResultSet rs = db.execute(query.getText());
        String cnames[] = rs.getMetaData();
        Columns.removeAll();
        QueryDialog q = new QueryDialog(this, rs);
        q.show();
    }


    /**
     * Method description
     *
     *
     * @param argv
     */
    static public void main(String argv[]) {
        new DbFrame();
    }
}
