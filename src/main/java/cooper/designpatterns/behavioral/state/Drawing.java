/*
 * @(#)Drawing.java   2011-11-01
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

/**
 * Class description
 *
 * @author <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 * @version 0.1.1, 2011-11-01
 */
public class Drawing {
    protected int x, y, w, h;
    protected Rectangle rect;
    protected boolean selected;
    protected boolean filled;
    protected Color fillColor;

    /**
     * Method description
     *
     * @param x
     * @param y
     * @return
     */
    public boolean contains(int x, int y) {
        return rect.contains(x, y);
    }

    /**
     * Method description
     *
     * @param g
     */
    public void draw(Graphics g) {
    }

    /**
     * Method description
     *
     * @param xpt
     * @param ypt
     */
    public void move(int xpt, int ypt) {
        x = xpt;
        y = ypt;
    }

    protected void saveAsRect() {
        rect = new Rectangle(x - w / 2, y - h / 2, w, h);
    }

    protected void setFill(Color c) {
        filled = true;
        fillColor = c;
    }

    /**
     * Method description
     *
     * @param b
     */
    public void setSelected(boolean b) {
        selected = b;
    }
}
