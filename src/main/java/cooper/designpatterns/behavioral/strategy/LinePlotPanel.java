/*
 * @(#)LinePlotPanel.java   2011-11-01
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

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class LinePlotPanel extends PlotPanel {

    /**
     * Method description
     *
     *
     * @param g
     */
    public void paint(Graphics g) {
        int xp = calcx(x[0]);    // get first point
        int yp = calcy(y[0]);
        g.setColor(Color.white);    // flood background
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.black);
        // draw bounding rectangle
        g.drawRect(xpmin, ypmin, xpmax, ypmax);
        g.setColor(color);
        // draw line graph
        for (int i = 1; i < x.length; i++) {
            int xp1 = calcx(x[i]);
            int yp1 = calcy(y[i]);
            g.drawLine(xp, yp, xp1, yp1);
            xp = xp1;
            yp = yp1;
        }
    }
}
