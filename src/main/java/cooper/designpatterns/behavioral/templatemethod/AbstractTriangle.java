/*
 * @(#)AbstractTriangle.java   2011-11-01
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
public abstract class AbstractTriangle {
    Point p1, p2, p3;

    /**
     * Constructs ...
     *
     *
     * @param a
     * @param b
     * @param c
     */
    public AbstractTriangle(Point a, Point b, Point c) {
        p1 = a;
        p2 = b;
        p3 = c;
    }

    /**
     * Method description
     *
     *
     * @param g
     */
    public void draw(Graphics g) {
        drawLine(g, p1, p2);
        Point current = draw2ndLine(g, p2, p3);
        closeTriangle(g, current);
    }

    /**
     * Method description
     *
     *
     * @param g
     * @param a
     * @param b
     */
    public void drawLine(Graphics g, Point a, Point b) {
        g.drawLine(a.x, a.y, b.x, b.y);
    }

    /**
     * Method description
     *
     *
     * @param g
     * @param a
     * @param b
     *
     * @return
     */
    abstract public Point draw2ndLine(Graphics g, Point a, Point b);

    /**
     * Method description
     *
     *
     * @param g
     * @param c
     */
    public void closeTriangle(Graphics g, Point c) {
        g.drawLine(c.x, c.y, p1.x, p1.y);
    }
}
