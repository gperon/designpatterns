/*
 * @(#)FactoryModel.java   2011-11-01
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
import java.awt.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * A model of a factory; at the moment this model just contains
 *  machine locations. However, the factory also provides support
 *  for undo by storing off mementos each time the factory
 *  configuration changes.
 */
public class FactoryModel {
    private Stack mementos;
    private ArrayList listeners = new ArrayList();

    /**
     * Constructs ...
     *
     */
    public FactoryModel() {
        mementos = new Stack();
        mementos.push(new ArrayList());    // start empty
    }

    /**
     * Method description
     *
     *
     * @param location
     */
    public void add(Point location) {
        List oldLocs = (List) mementos.peek();
        List newLocs = new ArrayList(oldLocs);
        newLocs.add(0, location);
        mementos.push(newLocs);
        notifyListeners();
    }

    /**
     * Method description
     *
     *
     * @param oldLocation
     * @param newLocation
     */
    public void drag(Point oldLocation, Point newLocation) {
        List oldLocs = (List) mementos.peek();
        List newLocs = new ArrayList(oldLocs);
        newLocs.remove(oldLocation);
        newLocs.add(0, newLocation);
        mementos.push(newLocs);
        notifyListeners();
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public boolean canUndo() {
        return mementos.size() > 1;
    }

    /**
     * Method description
     *
     */
    public void undo() {
        if (!canUndo()) {
            return;
        }
        mementos.pop();
        notifyListeners();
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public List getLocations() {
        return (List) mementos.peek();
    }

    /**
     * Method description
     *
     *
     * @param list
     */
    public void setLocations(ArrayList list) {
        mementos.push(list);
        notifyListeners();
    }

    /**
     * Method description
     *
     *
     * @param listener
     */
    public void addChangeListener(ChangeListener listener) {
        listeners.add(listener);
    }

    /**
     * Method description
     *
     */
    public void notifyListeners() {
        for (int i = 0; i < listeners.size(); i++) {
            ((ChangeListener) listeners.get(i)).stateChanged(new ChangeEvent(this));
        }
    }
}
