/*
 * @(#)IsocelesTriangle.java   2011-11-01
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



package cooper.designpatterns.behavioral.templatemethod;

import java.awt.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class IsocelesTriangle extends AbstractTriangle {
    Point newc;
    int newcx, newcy;
    int incr;

    /**
     * Constructs ...
     *
     *
     * @param a
     * @param b
     * @param c
     */
    public IsocelesTriangle(Point a, Point b, Point c) {
        super(a, b, c);
        double dx1 = b.x - a.x;
        double dy1 = b.y - a.y;
        double dx2 = c.x - b.x;
        double dy2 = c.y - b.y;
        double side1 = calcSide(dx1, dy1);
        double side2 = calcSide(dx2, dy2);
        if (side2 < side1) {
            incr = -1;
        } else {
            incr = 1;
        }
        double slope = dy2 / dx2;
        double intercept = c.y - slope * c.x;

        /* move point c so that this is an isoceles triangle */
        newcx = c.x;
        newcy = c.y;
        while (Math.abs(side1 - side2) > 1) {

            /* iterate a pixel at a time until close */
            newcx += incr;
            newcy = (int) (slope * newcx + intercept);
            dx2 = newcx - b.x;
            dy2 = newcy - b.y;
            side2 = calcSide(dx2, dy2);
        }
        newc = new Point(newcx, newcy);
    }

    /**
     * calculate length of side
     */
    private double calcSide(double dx, double dy) {
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * draws 2nd line using saved new point
     *
     * @param g
     * @param b
     * @param c
     *
     * @return
     */
    public Point draw2ndLine(Graphics g, Point b, Point c) {
        g.drawLine(b.x, b.y, newc.x, newc.y);

        return newc;
    }
}
