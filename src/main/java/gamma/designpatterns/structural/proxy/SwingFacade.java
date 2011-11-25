/*
 * @(#)SwingFacade.java   2011-11-01
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



package gamma.designpatterns.structural.proxy;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class SwingFacade {

    /**
     * Create a titled border with the given title.
     *
     * @param title the words to show in the title border tab
     * @return a (beveled) titled border with the given title
     */
    public static TitledBorder createTitledBorder(String title) {
        TitledBorder tb =
            BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),
                title, TitledBorder.LEFT, TitledBorder.TOP);
        tb.setTitleColor(Color.black);
        tb.setTitleFont(getStandardFont());

        return tb;
    }

    /**
     * Create a new panel that wraps a titled border around a
     * given panel.
     *
     * @param title the words to show in the title border tab
     * @param in the panel that the border goes around
     * @return a (beveled) titled border with the given title
     */
    public static JPanel createTitledPanel(String title, JPanel in) {
        JPanel out = new JPanel();
        out.add(in);
        out.setBorder(createTitledBorder(title));

        return out;
    }

    /**
     * Create a standard font for GUI use.
     *
     * @return a standard font for GUI use
     */
    public static Font getStandardFont() {
        return new Font("Dialog", Font.PLAIN, 18);
    }

    /**
     * Display the given component within a frame.
     *
     *
     * @param c
     * @param title the window title for the frame
     * @return the frame
     */
    public static JFrame launch(Component c, String title) {
        JFrame frame = new JFrame(title);
        frame.getContentPane().add(c);
        listen(frame);
        frame.pack();
        frame.setVisible(true);

        return frame;
    }

    /**
     * Set up an exit listener for a supplied frame.
     *
     *
     * @param f
     */
    public static void listen(Frame f) {
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
