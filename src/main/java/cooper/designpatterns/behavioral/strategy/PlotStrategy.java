/*
 * @(#)PlotStrategy.java   2011-11-01
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



package cooper.designpatterns.behavioral.strategy;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
//this is the abstact base class that
//concrete plot strategies are derived from

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public abstract class PlotStrategy extends JFrame {
    protected float[] x, y;
    protected float minX, minY, maxX, maxY;
    protected int width, height;
    protected Color color;

    /**
     * Constructs ...
     *
     *
     * @param title
     */
    public PlotStrategy(String title) {
        super(title);
        width = 300;
        height = 200;
        color = Color.black;
        addWindowListener(new WindAp(this));
    }

    /**
     * Method description
     *
     *
     * @param xp
     * @param yp
     */
    public abstract void plot(float xp[], float yp[]);

    /**
     * Method description
     *
     *
     * @param sz
     */
    public void setSize(Dimension sz) {
        width = sz.width;
        height = sz.height;
    }

    /**
     * Method description
     *
     *
     * @param c
     */
    public void setPenColor(Color c) {
        color = c;
    }

    /**
     * Method description
     *
     */
    public void findBounds() {
        minX = minY = Float.MAX_VALUE;
        maxX = maxY = Float.MIN_VALUE;
        for (int i = 0; i < x.length; i++) {
            if (x[i] > maxX) {
                maxX = x[i];
            }
            if (x[i] < minX) {
                minX = x[i];
            }
            if (y[i] > maxY) {
                maxY = y[i];
            }
            if (y[i] < minY) {
                minY = y[i];
            }
        }
    }
}


class WindAp extends WindowAdapter {
    JFrame fr;

    /**
     * Constructs ...
     *
     *
     * @param f
     */
    public WindAp(JFrame f) {
        fr = f;
    }

    /**
     * Method description
     *
     *
     * @param e
     */
    public void WindowClosing(WindowEvent e) {
        fr.setVisible(false);
    }
}
