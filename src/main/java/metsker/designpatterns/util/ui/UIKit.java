/*
 * @(#)UIKit.java   2011-11-01
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
import java.awt.*;

import javax.swing.*;

/**
 * This class shows the idea of establishing user interface kits with
 * prototypical components.
 */
public class UIKit {
    protected OzButton button = new OzButton();
    protected OzTextArea textArea = new OzTextArea();

    /**
     *
     * @param text
     * @return a (copy of a prototypical) button
     */
    public JButton createButton(String text) {
        JButton b = new JButton(text);
        b.setFont(button.getFont());

        return b;
    }

    /**
     * @return a (copy of a prototypical) text area
     */
    public OzTextArea createTextArea() {
        return (OzTextArea) textArea.clone();
    }

    /**
     * @return a kit for full-screen user interfaces
     */
    public static UIKit fullScreen() {
        Font font = new Font("Dialog", Font.ITALIC, 18);
        UIKit kit = new UIKit();
        kit.button.setFont(font);
        kit.textArea.setFont(font);

        return kit;
    }

    /**
     * @return a kit for handheld device user interfaces
     */
    public static UIKit handheld() {
        UIKit kit = new UIKit();
        Font font = new Font("Dialog", Font.PLAIN, 8);
        kit.button.setFont(font);
        kit.textArea = new OzTextArea();
        kit.textArea.setFont(font);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        kit.textArea.setCursor(cursor);

        return kit;
    }
}
