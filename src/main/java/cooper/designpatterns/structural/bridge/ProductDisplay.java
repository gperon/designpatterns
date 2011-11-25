/*
 * @(#)ProductDisplay.java   2011-11-01
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

import java.awt.*;
import java.awt.event.*;

import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import javax.swing.border.*;

import cooper.designpatterns.util.swing.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class ProductDisplay extends JxFrame {

    /**
     * Constructs ...
     *
     */
    public ProductDisplay() {
        super("The Java Factory-- Products");
        setLF();            // set look and feel
        setCloseClick();    // set close on window close click
        InputFile f = new InputFile("products.txt");
        Vector prod = new Vector();
        // read in product list
        String s = f.readLine();
        while (s != null) {
            prod.addElement(s);
            s = f.readLine();
        }
        JPanel p = new JPanel();
        getContentPane().add(p);
        p.setLayout(new GridLayout(1, 2));
        JPanel pleft = new JPanel();
        JPanel pright = new JPanel();
        p.add(pleft);
        p.add(pright);
        pleft.setLayout(new BorderLayout());
        pright.setLayout(new BorderLayout());
        // add in customer view as list box
        pleft.add("North", new JLabel("Customer view"));
        pleft.add("Center", new ProductList(prod));
        // add in execute view as table
        pright.add("North", new JLabel("Executive view"));
        pright.add("Center", new ProductTable(prod));
        setSize(new Dimension(400, 300));
        setVisible(true);
    }

    private void setCloseClick() {
        // create window listener to respond to window close click
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private void setLF() {
        // Force SwingApp to come up in the System L&F
        String laf = UIManager.getSystemLookAndFeelClassName();
        try {
            UIManager.setLookAndFeel(laf);
        } catch (UnsupportedLookAndFeelException exc) {
            System.err.println("Warning: UnsupportedLookAndFeel: " + laf);
        } catch (Exception exc) {
            System.err.println("Error loading " + laf + ": " + exc);
        }
    }

    /**
     * Method description
     *
     *
     * @param argv
     */
    static public void main(String argv[]) {
        new ProductDisplay();
    }
}
