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



package cooper.designpatterns.behavioral.state;

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
    boolean dSelected;
    Vector drawings;
    Vector undoList;
    RectButton rectButton;
    FillButton fillButton;
    CircleButton circButton;
    PickButton arrowButton;
    JPanel canvas;
    Drawing selectedDrawing;
    StateManager stMgr;

    /**
     * Constructs ...
     *
     */
    public Mediator() {
        startRect = false;
        dSelected = false;
        drawings = new Vector();
        undoList = new Vector();
        stMgr = new StateManager(this);
    }

    /**
     * Method description
     *
     */
    public void startRectangle() {
        stMgr.setRect();
        arrowButton.setSelected(false);
        circButton.setSelected(false);
        fillButton.setSelected(false);
    }

    /**
     * Method description
     *
     */
    public void startCircle() {
        stMgr.setCircle();
        rectButton.setSelected(false);
        arrowButton.setSelected(false);
        fillButton.setSelected(false);
    }

    /**
     * Method description
     *
     */
    public void startFill() {
        stMgr.setFill();
        rectButton.setSelected(false);
        circButton.setSelected(false);
        arrowButton.setSelected(false);
        stMgr.select(selectedDrawing, Color.red);
        repaint();
    }

    /**
     * Method description
     *
     */
    public void startArrow() {
        stMgr.setArrow();
        rectButton.setSelected(false);
        circButton.setSelected(false);
        fillButton.setSelected(false);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Drawing getSelected() {
        return selectedDrawing;
    }

    /**
     * Method description
     *
     */
    public void fillSelected() {
        if (dSelected) {
            selectedDrawing.setFill(Color.red);
        }
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Vector getDrawings() {
        return drawings;
    }

    /**
     * Method description
     *
     *
     * @param d
     */
    public void addDrawing(Drawing d) {
        drawings.addElement(d);
    }

    /**
     * Method description
     *
     *
     * @param rb
     */
    public void registerRectButton(RectButton rb) {
        rectButton = rb;
    }

    /**
     * Method description
     *
     *
     * @param cb
     */
    public void registerCircleButton(CircleButton cb) {
        circButton = cb;
    }

    /**
     * Method description
     *
     *
     * @param ab
     */
    public void registerArrowButton(PickButton ab) {
        arrowButton = ab;
    }

    /**
     * Method description
     *
     *
     * @param fb
     */
    public void registerFillButton(FillButton fb) {
        fillButton = fb;
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

    /**
     * Method description
     *
     *
     * @param x
     * @param y
     */
    public void mouseDown(int x, int y) {
        stMgr.mouseDown(x, y);
        repaint();
    }

    /**
     * Method description
     *
     *
     * @param x
     * @param y
     */
    public void mouseUp(int x, int y) {
        stMgr.mouseUp(x, y);
    }

    /**
     * Method description
     *
     */
    public void unpick() {
        dSelected = false;
        if (selectedDrawing != null) {
            selectedDrawing.setSelected(false);
            selectedDrawing = null;
            repaint();
        }
    }

    /**
     * Method description
     *
     */
    public void rememberPosition() {
        if (dSelected) {
            // Memento m = new Memento(d);
            // undoList.addElement(m);
        }
    }

    /**
     * Method description
     *
     *
     * @param d
     */
    public void setSelected(Drawing d) {
        if (d != null) {
            dSelected = true;
            selectedDrawing = d;
            d.setSelected(true);
            repaint();
        }
    }

    /**
     * Method description
     *
     *
     * @param x
     * @param y
     */
    public void pickRect(int x, int y) {}

    /**
     * Method description
     *
     */
    public void clear() {
        drawings = new Vector();
        undoList = new Vector();
        dSelected = false;
        selectedDrawing = null;
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
    public void mouseDrag(int x, int y) {
        stMgr.mouseDrag(x, y);
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
            Drawing v = (Drawing) drawings.elementAt(i);
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
