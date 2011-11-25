/*
 * @(#)FillState.java   2011-11-01
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

import java.util.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class FillState extends State {
    private Mediator med;    // save Mediator
    private Color color;     // save current color

    /**
     * Constructs ...
     *
     *
     * @param md
     */
    public FillState(Mediator md) {
        med = md;
    }

    /**
     * Fill drawing if selected
     *
     * @param d
     * @param c
     */
    public void select(Drawing d, Color c) {
        color = c;
        if (d != null) {
            d.setFill(c);    // fill that drawing
        }
    }

    /**
     * Fill drawing if you click inside one
     *
     * @param x
     * @param y
     */
    public void mouseDown(int x, int y) {
        Vector drawings = med.getDrawings();
        for (int i = 0; i < drawings.size(); i++) {
            Drawing d = (Drawing) drawings.elementAt(i);
            if (d.contains(x, y)) {
                d.setFill(color);    // fill drawing
            }
        }
    }
}
