/*
 * @(#)CoolDecorator.java   2011-11-01
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



package cooper.designpatterns.structural.decorator;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class CoolDecorator extends Decorator {
    boolean mouse_over;    // true when mose over button
    JComponent thisComp;

    /**
     * Constructs ...
     *
     *
     * @param c
     */
    public CoolDecorator(JComponent c) {
        super(c);
        mouse_over = false;
        thisComp = this;    // save this component
        // catch mouse movements in inner class
        c.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                mouse_over = true;    // set flag when mouse over
                thisComp.repaint();
            }
            public void mouseExited(MouseEvent e) {
                mouse_over = false;    // clear flag when mouse not over
                thisComp.repaint();
            }
        });
    }

    // paint the button

    /**
     * Method description
     *
     *
     * @param g
     */
    public void paint(Graphics g) {
        super.paint(g);    // first draw the parent button
        if (!mouse_over)
        // if the mouse is not over the button
        // erase the borders
        {
            Dimension size = super.getSize();
            g.setColor(Color.lightGray);
            g.drawRect(0, 0, size.width - 1, size.height - 1);
            g.drawLine(size.width - 2, 0, size.width - 2, size.height - 1);
            g.drawLine(0, size.height - 2, size.width - 2, size.height - 2);
        }
    }
}
