/*
 * @(#)Visualization2.java   2011-11-01
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



package metsker.designpatterns.creational.abstractfactory;

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
import metsker.designpatterns.util.ui.SwingFacade;
import metsker.designpatterns.util.ui.UI;

import java.awt.event.*;

import javax.swing.*;

/**
 * This version of the visualization adds a menu that
 * provides for saving and restoring mementos from a file.
 */
public class Visualization2 extends Visualization {

    /**
     * Method description
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Visualization2 panel = new Visualization2(UI.NORMAL);
        JFrame frame = SwingFacade.launch(panel, "Operational Model");
        frame.setJMenuBar(panel.menus());
        frame.setVisible(true);
    }

    /**
     * Constructs ...
     *
     *
     * @param ui
     */
    public Visualization2(UI ui) {
        super(ui);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public JMenuBar menus() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        JMenuItem menuItem = new JMenuItem("Save As...");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
        menu.add(menuItem);
        menuItem = new JMenuItem("Restore From...");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                restore();
            }
        });
        menu.add(menuItem);

        return menuBar;
    }

    /**
     * Method description
     *
     */
    public void save() {
        try {
            mediator.save(this);
        } catch (Exception ex) {
            System.out.println("Failed save: " + ex.getMessage());
        }
    }

    /**
     * Method description
     *
     */
    public void restore() {
        try {
            mediator.restore(this);
        } catch (Exception ex) {
            System.out.println("Failed restore: " + ex.getMessage());
        }
    }
}
