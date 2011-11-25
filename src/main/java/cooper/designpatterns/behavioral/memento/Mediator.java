/*
 * @(#)Mediator.java   2011-11-01
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



package cooper.designpatterns.behavioral.memento;

import java.awt.*;

import java.util.*;

import javax.swing.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class Mediator {
    boolean startRect;
    boolean rectSelected;
    Vector drawings;
    Vector undoList;
    RectButton rect;
    JPanel canvas;
    VisitorRectangle selectedRectangle;

    /**
     * Constructs ...
     *
     */
    public Mediator() {
        startRect = false;
        rectSelected = false;
        drawings = new Vector();
        undoList = new Vector();
    }

    /**
     * Method description
     *
     */
    public void startRectangle() {
        startRect = true;
    }

    /**
     * Method description
     *
     *
     * @param x
     * @param y
     */
    public void createRect(int x, int y) {
        unpick();    // make sure no rectangle is selected
        if (startRect)                     // if rect button is depressed
        {
            Integer count = new Integer(drawings.size());
            undoList.addElement(count);    // Save previous drawing list size
            VisitorRectangle v = new VisitorRectangle(x, y);
            drawings.addElement(v);        // add new element to list
            startRect = false;             // done with this rectangle
            rect.setSelected(false);       // unclick button
            canvas.repaint();
        } else {
            pickRect(x, y);                // if not pressed look for rect to select
        }
    }

    /**
     * Method description
     *
     *
     * @param rb
     */
    public void registerRectButton(RectButton rb) {
        rect = rb;
    }

    /**
     * Method description
     *
     *
     * @param p
     */
    public void registerCanvas(JPanel p) {
        canvas = p;
    }

    private void unpick() {
        rectSelected = false;
        if (selectedRectangle != null) {
            selectedRectangle.setSelected(false);
            selectedRectangle = null;
            repaint();
        }
    }

    /**
     * Method description
     *
     */
    public void rememberPosition() {
        if (rectSelected) {
            Memento m = new Memento(selectedRectangle);
            undoList.addElement(m);
        }
    }

    /**
     * Method description
     *
     *
     * @param x
     * @param y
     */
    public void pickRect(int x, int y) {
        // save current selected rectangle to avoid double save of undo
        VisitorRectangle lastPick = selectedRectangle;
        unpick();
        for (int i = 0; i < drawings.size(); i++) {
            VisitorRectangle v = (VisitorRectangle) drawings.elementAt(i);
            if (v.contains(x, y))                       // did click inside a rectangle
            {
                selectedRectangle = v;                  // save it
                rectSelected = true;
                if (selectedRectangle != lastPick) {    // but don't save twice
                    rememberPosition();
                }
                v.setSelected(true);                    // turn on handles
                repaint();                              // and redraw
            }
        }
    }

    /**
     * Method description
     *
     */
    public void clear() {
        drawings = new Vector();
        undoList = new Vector();
        rectSelected = false;
        selectedRectangle = null;
        repaint();
    }

    private void repaint() {
        canvas.repaint();
    }

    /**
     * Method description
     *
     *
     * @param x
     * @param y
     */
    public void drag(int x, int y) {
        if (rectSelected) {
            if (selectedRectangle.contains(x, y)) {
                selectedRectangle.move(x, y);
                repaint();
            }
        }
    }

    /**
     * Method description
     *
     *
     * @param g
     */
    public void reDraw(Graphics g) {
        g.setColor(Color.black);
        for (int i = 0; i < drawings.size(); i++) {
            VisitorRectangle v = (VisitorRectangle) drawings.elementAt(i);
            v.draw(g);
        }
    }

    /**
     * Method description
     *
     */
    public void undo() {
        if (undoList.size() > 0) {
            // get last element in undo list
            Object obj = undoList.lastElement();
            undoList.removeElement(obj);    // and remove it
            // if this is an Integer, the last action was a new rectangle
            if (obj instanceof Integer) {
                // remove last created rectangle
                Object drawObj = drawings.lastElement();
                drawings.removeElement(drawObj);
            }
            // if this is a Memento, the last action was a move
            if (obj instanceof Memento) {
                // get the Memento
                Memento m = (Memento) obj;
                m.restore();    // and restore the old position
            }
            repaint();
        }
    }
}
