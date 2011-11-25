/*
 * @(#)PlotPanel.java   2011-11-01
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



package metsker.designpatterns.util.ui;

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
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import metsker.designpatterns.structural.decorator.Function;

/**
 * This class displays pair of functions in a panel. The functions
 * are x and y functions, parameterized by time. As the panel plots,
 * time goes 0 to 1.
 */
public class PlotPanel extends JPanel {
    private int points;
    private int[] xPoints;
    private int[] yPoints;
    private Function xFunction;
    private Function yFunction;

    /**
     * Create a plot calculated from the provided x and y functions.
     * These functions must be functions of time; time goes 0 to 1
     * as the panel plots.
     *
     * @param nPoint
     * @param xFunc
     * @param yFunc
     */
    public PlotPanel(int nPoint, Function xFunc, Function yFunc) {
        points = nPoint;
        xPoints = new int[points];
        yPoints = new int[points];
        xFunction = xFunc;
        yFunction = yFunc;
        setBackground(Color.WHITE);
    }

    protected void paintComponent(Graphics graphics) {
        double w = getWidth() - 1;
        double h = getHeight() - 1;
        for (int i = 0; i < points; i++) {
            double t = ((double) i) / (points - 1);
            xPoints[i] = (int) (xFunction.f(t) * w);
            yPoints[i] = (int) (h * (1 - yFunction.f(t)));
        }
        graphics.drawPolyline(xPoints, yPoints, points);
    }
}
