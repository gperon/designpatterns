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



package cooper.designpatterns.behavioral.strategy;

import java.awt.*;

import javax.swing.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class PlotPanel extends JPanel {
    float xfactor, yfactor;
    int xpmin, ypmin, xpmax, ypmax;
    float minX, maxX, minY, maxY;
    float x[], y[];
    Color color;

    /**
     * Method description
     *
     *
     * @param minx
     * @param miny
     * @param maxx
     * @param maxy
     */
    public void setBounds(float minx, float miny, float maxx, float maxy) {
        minX = minx;
        maxX = maxx;
        minY = miny;
        maxY = maxy;
    }

    /**
     * Method description
     *
     *
     * @param xp
     * @param yp
     * @param c
     */
    public void plot(float[] xp, float[] yp, Color c) {
        x = xp;       // copy in the arrays
        y = yp;
        color = c;    // and color
        // compute bounds and sclaing factors
        int w = getWidth() - getInsets().left - getInsets().right;
        int h = getHeight() - getInsets().top - getInsets().bottom;
        xfactor = (0.9f * w) / (maxX - minX);
        yfactor = (0.9f * h) / (maxY - minY);
        xpmin = (int) (0.05f * w);
        ypmin = (int) (0.05f * h);
        xpmax = w - xpmin;
        ypmax = h - ypmin;
        repaint();    // this causes the actual plot
    }

    protected int calcx(float xp) {
        return (int) ((xp - minX) * xfactor + xpmin);
    }

    protected int calcy(float yp) {
        int ypnt = (int) ((yp - minY) * yfactor);

        return ypmax - ypnt;
    }
}
