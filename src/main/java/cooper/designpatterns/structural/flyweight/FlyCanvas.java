/*
 * @(#)FlyCanvas.java   2011-11-01
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



package cooper.designpatterns.structural.flyweight;

import cooper.designpatterns.util.swing.JxFrame;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import java.util.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class FlyCanvas extends JxFrame implements MouseMotionListener {
    Folder folder;
    Vector names;
    FolderFactory fact;
    final int Top = 30, Left = 30;
    final int W = 50, H = 30;
    final int VSpace = 80, HSpace = 70, HCount = 3;
    String selectedName = "";

    /**
     * Constructs ...
     *
     */
    public FlyCanvas() {
        super("Flyweight Canvas");
        loadNames();
        JPanel jp = new JPanel();
        getContentPane().add(jp);
        setSize(new Dimension(300, 300));
        addMouseMotionListener(this);
        setVisible(true);
        repaint();
    }

    private void loadNames() {
        names = new Vector();
        fact = new FolderFactory();
        names.addElement("Alan");
        names.addElement("Barry");
        names.addElement("Charlie");
        names.addElement("Dave");
        names.addElement("Edward");
        names.addElement("Fred");
        names.addElement("George");
        selectedName = "Charlie";
    }

    /**
     * Method description
     *
     *
     * @param g
     */
    public void paint(Graphics g) {
        Folder f;
        String name;
        int j = 0;        // count number in row
        int row = Top;    // start in upper left
        int x = Left;
        // go through all the names and folders
        for (int i = 0; i < names.size(); i++) {
            name = (String) names.elementAt(i);
            if (name.equals(selectedName)) {
                f = fact.getFolder(true);
            } else {
                f = fact.getFolder(false);
            }
            // have that folder draw itself at this spot
            f.Draw(g, x, row, name);
            x = x + HSpace;     // change to next posn
            j++;
            if (j >= HCount)    // reset for next row
            {
                j = 0;
                row += VSpace;
                x = Left;
            }
        }
    }

    /**
     * Method description
     *
     *
     * @param e
     */
    public void mouseMoved(MouseEvent e) {
        int j = 0;        // count number in row
        int row = Top;    // start in upper left
        int x = Left;
        // go through all the names and folders
        for (int i = 0; i < names.size(); i++) {
            // see if this folder contains the mouse
            Rectangle r = new Rectangle(x, row, W, H);
            if (r.contains(e.getX(), e.getY())) {
                selectedName = (String) names.elementAt(i);
                repaint();
            }
            x = x + HSpace;     // change to next posn
            j++;
            if (j >= HCount)    // reset for next row
            {
                j = 0;
                row += VSpace;
                x = Left;
            }
        }
    }

    /**
     * Method description
     *
     *
     * @param e
     */
    public void mouseDragged(MouseEvent e) {}

    /**
     * Method description
     *
     *
     * @param argv
     */
    static public void main(String[] argv) {
        new FlyCanvas();
    }
}


class Folder extends JPanel {
    private Color color;
    final int W = 50, H = 30;

    /**
     * Constructs ...
     *
     *
     * @param c
     */
    public Folder(Color c) {
        color = c;
    }

    /**
     * Method description
     *
     *
     * @param g
     * @param tx
     * @param ty
     * @param name
     */
    public void Draw(Graphics g, int tx, int ty, String name) {
        g.setColor(Color.black);                // outline
        g.drawRect(tx, ty, W, H);
        g.drawString(name, tx, ty + H + 15);    // title
        g.setColor(color);                      // fill rectangle
        g.fillRect(tx + 1, ty + 1, W - 1, H - 1);
        g.setColor(Color.lightGray);            // bend line
        g.drawLine(tx + 1, ty + H - 5, tx + W - 1, ty + H - 5);
        g.setColor(Color.black);                // shadow lines
        g.drawLine(tx, ty + H + 1, tx + W - 1, ty + H + 1);
        g.drawLine(tx + W + 1, ty, tx + W + 1, ty + H);
        g.setColor(Color.white);                // highlight lines
        g.drawLine(tx + 1, ty + 1, tx + W - 1, ty + 1);
        g.drawLine(tx + 1, ty + 1, tx + 1, ty + H - 1);
    }
}


class FolderFactory {
    Folder unSelected, Selected;

    /**
     * Constructs ...
     *
     */
    public FolderFactory() {
        Color brown = new Color(0x5f5f1c);
        Selected = new Folder(brown);
        unSelected = new Folder(Color.yellow);
    }

    /**
     * Method description
     *
     *
     * @param isSelected
     *
     * @return
     */
    public Folder getFolder(boolean isSelected) {
        if (isSelected) {
            return Selected;
        } else {
            return unSelected;
        }
    }
}
