/*
 * @(#)UI.java   2011-11-01
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
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

/**
 * User interface utilities.
 */
public class UI {
    protected Font font = new Font("Book Antiqua", Font.PLAIN, 18);

    /** Field description */
    public static final int STANDARD_PAD = 10;

    /** Field description */
    public static final UI NORMAL = new UI();

    /**
     * @return a standard font that subclasses can override
     */
    public Font getFont() {
        return font;
    }

    /**
     * @return a standard padding amount that subclasses can override
     */
    public int getPad() {
        return STANDARD_PAD;
    }

    /**
     * @return a standard button
     */
    public JButton createButton() {
        JButton button = new JButton();
        button.setSize(128, 128);
        button.setFont(getFont());
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setHorizontalTextPosition(SwingConstants.CENTER);

        return button;
    }

    /**
     *     @return a standard OK! (or affirmation) button
     */
    public JButton createButtonOk() {
        JButton button = createButton();
        button.setIcon(getIcon("images/rocket-large.gif"));
        button.setText("Ok!");

        return button;
    }

    /**
     * @return a standard Cancel! (or negation) button
     */
    public JButton createButtonCancel() {
        JButton button = createButton();
        button.setIcon(getIcon("images/rocket-large-down.gif"));
        button.setText("Cancel!");

        return button;
    }

    /**
     * @return a panel with a standard amount of padding around any controls
     */
    public JPanel createPaddedPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(getPad(), getPad(), getPad(), getPad()));

        return panel;
    }

    /**
     * @return a panel with a standard amount of padding around any particular
     *         control
     * @param c
     *            the control
     */
    public JPanel createPaddedPanel(Component c) {
        JPanel panel = createPaddedPanel();
        panel.add(c);

        return panel;
    }

    /**
     * Method description
     *
     *
     * @param imageName
     *
     * @return
     */
    public static Icon getIcon(String imageName) {
        return new ImageIcon(imageName);
    }

    /**
     * Method description
     *
     *
     * @param contents
     *
     * @return
     */
    public JList createList(Object[] contents) {
        JList result = new JList(contents);
        result.setFont(getFont());
        result.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        return result;
    }

    /**
     *
     * @param title
     * @return a titled border with the given title.
     */
    public TitledBorder createTitledBorder(String title) {
        TitledBorder border =
            BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),
                title, TitledBorder.LEFT, TitledBorder.TOP);
        border.setTitleColor(Color.black);
        border.setTitleFont(getFont());

        return border;
    }

    /**
     *
     * @param title
     * @param in
     * @return a new panel that wraps a titled border around a given panel.
     */
    public JPanel createTitledPanel(String title, JPanel in) {
        JPanel out = new JPanel();
        out.add(in);
        out.setBorder(createTitledBorder(title));

        return out;
    }
}
