/*
 * @(#)RectButton.java   2011-11-01
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
import java.awt.event.*;

import cooper.designpatterns.behavioral.command.Command;

import javax.swing.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class RectButton extends JToggleButton implements Command {
    Mediator med;

    /**
     * Constructs ...
     *
     *
     * @param act
     * @param md
     */
    public RectButton(ActionListener act, Mediator md) {
        super("Rectangle");
        setSize(new Dimension(35, 35));
        setBorderPainted(true);
        setMargin(new Insets(5, 12, 5, 12));
        setToolTipText("Draw rectangle");
        addActionListener(act);
        med = md;
        med.registerRectButton(this);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Dimension getPreferredSize() {
        return new Dimension(35, 35);
    }

    /**
     * Method description
     *
     *
     * @param g
     */
    public void paint(Graphics g) {
        super.paint(g);
        int h = getHeight();
        int w = getWidth();
        g.setColor(Color.black);
        g.drawRect(4, 4, w - 8, h - 8);
    }

    /**
     * Method description
     *
     */
    public void execute() {
        med.startRectangle();
    }
}
