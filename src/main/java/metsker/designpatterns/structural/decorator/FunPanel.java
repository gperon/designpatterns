/*
 * @(#)FunPanel.java   2011-11-01
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



package metsker.designpatterns.structural.decorator;

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
import metsker.designpatterns.structural.decorator.Function;
import metsker.designpatterns.structural.decorator.T;

import java.awt.*;

import javax.swing.*;

/**
 * Plots a curve given parametric functions x and y that are parameterized on
 * time t, where t goes 0 to 1 during the life of the curve.
 *
 * @author Steven J. Metsker
 */
public class FunPanel extends JPanel {
    protected Function fx = new T();
    protected Function fy = new T();
    protected int nPoint;
    protected int[] xArray;
    protected double xMax = 1;
    protected double xMin = 0;
    protected int[] yArray;
    protected double yMax = 1;
    protected double yMin = 0;

    /**
     * Constructs ...
     *
     */
    public FunPanel() {
        this(101);
    }

    /**
     * Constructs ...
     *
     *
     * @param nPoint
     */
    public FunPanel(int nPoint) {
        this.nPoint = nPoint;
        xArray = new int[nPoint];
        yArray = new int[nPoint];
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        double h = getHeight() - 1;
        double w = getWidth() - 1;
        for (int i = 0; i < nPoint; i++) {
            double t = ((double) i) / (nPoint - 1);
            xArray[i] = (int) (w * (fx.f(t) - xMin) / (xMax - xMin));
            yArray[i] = (int) (h - h * (fy.f(t) - yMin) / (yMax - yMin));
        }
        g.setColor(Color.black);
        g.drawPolyline(xArray, yArray, nPoint);
    }

    /**
     * Establish the functions to plot.
     *
     * @param fx
     *            the x function
     * @param fy
     *            the y function
     */
    public void setXY(Function fx, Function fy) {
        this.fx = fx;
        this.fy = fy;
        calculateExtrema();
        repaint();
    }

    protected void calculateExtrema() {
        for (int i = 0; i < nPoint; i++) {
            double t = ((double) i) / (nPoint - 1);
            double dx = fx.f(t);
            double dy = fy.f(t);
            if ((i == 0) || (dx > xMax)) {
                xMax = dx;
            }
            if ((i == 0) || (dx < xMin)) {
                xMin = dx;
            }
            if ((i == 0) || (dy > yMax)) {
                yMax = dy;
            }
            if ((i == 0) || (dy < yMin)) {
                yMin = dy;
            }
        }
    }
}
