/*
 * @(#)VisMediator.java   2011-11-01
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
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;

import javax.swing.JFileChooser;

/**
 * This class handles the UI events for the Visualization class
 */
public class VisMediator {

    /** Field description */
    public static final Point DEFAULT_LOCATION = new Point(10, 10);
    protected int initX;
    protected int initY;
    protected Point initLocation;
    Cursor originalCursor;
    protected boolean isMouseDown = false;
    protected FactoryModel factoryModel;

    /**
     * Constructs ...
     *
     *
     * @param m
     */
    public VisMediator(FactoryModel m) {
        factoryModel = m;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public ActionListener addAction() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VisMediator.this.add(e);
            }
        };
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public ActionListener undoAction() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VisMediator.this.undo(e);
            }
        };
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public MouseListener mouseDownAction() {
        return new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                VisMediator.this.mouseDown(e);
            }
            public void mouseReleased(MouseEvent e) {
                VisMediator.this.mouseUp(e);
            }
        };
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public MouseMotionListener mouseMotionAction() {
        return new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
                VisMediator.this.mouseMove(e);
            }
            public void mouseMoved(MouseEvent e) {}
        };
    }

    private void add(ActionEvent e) {
        factoryModel.add(DEFAULT_LOCATION);
    }

    private void undo(ActionEvent e) {
        factoryModel.undo();
    }

    // A click on a picture box
    private void mouseDown(MouseEvent e) {
        if (e.getButton() != MouseEvent.BUTTON1) {
            return;
        }
        Component source = (Component) e.getSource();
        Component parent = source.getParent();
        originalCursor = parent.getCursor();
        parent.setCursor(new Cursor(Cursor.MOVE_CURSOR));
        initLocation = source.getLocation();
        initX = e.getX();
        initY = e.getY();
        isMouseDown = true;
    }

    // A drag while a picture box is clicked
    private void mouseMove(MouseEvent e) {
        if (!isMouseDown) {
            return;
        }
    }

    // Release picture box. Let the factory model know about this change.
    private void mouseUp(MouseEvent e) {
        if (e.getButton() != MouseEvent.BUTTON1) {
            return;
        }
        Component parent = ((Component) e.getSource()).getParent();
        parent.setCursor(originalCursor);
        isMouseDown = false;
        factoryModel.drag(initLocation,
                          new Point(initLocation.x + e.getX() - initX,
                                    initLocation.y + e.getY() - initY));
    }

    // User clicked "Save As..." menu item

    /**
     * Method description
     *
     *
     * @param source
     *
     * @throws Exception
     */
    public void save(Component source) throws Exception {
        JFileChooser dialog = new JFileChooser();
        dialog.showSaveDialog(source);
        if (dialog.getSelectedFile() == null) {
            return;
        }
        FileOutputStream out = null;
        ObjectOutputStream s = null;
        try {
            out = new FileOutputStream(dialog.getSelectedFile());
            s = new ObjectOutputStream(out);
            s.writeObject(factoryModel.getLocations());
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    // User clicked "Restore from..." menu item

    /**
     * Method description
     *
     *
     * @param source
     *
     * @throws Exception
     */
    public void restore(Component source) throws Exception {
        JFileChooser dialog = new JFileChooser();
        dialog.showOpenDialog(source);
        if (dialog.getSelectedFile() == null) {
            return;
        }
        FileInputStream out = null;
        ObjectInputStream s = null;
        try {
            out = new FileInputStream(dialog.getSelectedFile());
            s = new ObjectInputStream(out);
            ArrayList list = (ArrayList) s.readObject();
            factoryModel.setLocations(list);
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
