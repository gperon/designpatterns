/*
 * @(#)OzTextArea.java   2011-11-01
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
import javax.swing.border.*;

/**
 * This class acts as a prototypical text area that applications can clone to
 * get a standard look and feel.
 */
public class OzTextArea extends JPanel {
    protected JTextArea textArea = new JTextArea();
    protected TitledBorder border;

    /**
     * Create a standard, prototypical text area. This constructor places a
     * Swing text area inside a scroll pane with a standard border.
     */
    public OzTextArea() {
        setLayout(new BorderLayout());
        JScrollPane jsp = new JScrollPane(textArea);
        jsp.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        add(jsp, "Center");
    }

    /**
     * Add the supplied text to this text area.
     *
     *
     * @param text
     */
    public void append(String text) {
        textArea().append(text);
    }

    /**
     * Remove all the text from this text area.
     */
    public void clear() {
        textArea().setText("");
    }

    /**
     * @return a copy of a prototypical text area
     */
    public Object clone() {
        OzTextArea ta = new OzTextArea();
        ta.setFont(textArea().getFont());
        ta.setCursor(getCursor());

        return ta;
    }

    /**
     * Method description
     *
     *
     * @param font
     */
    public void setFont(Font font) {
        textArea().setFont(font);
    }

    protected JTextArea textArea() {
        if (textArea == null) {
            textArea = new JTextArea();
            textArea.setMargin(new Insets(20, 20, 20, 20));
        }

        return textArea;
    }
}
