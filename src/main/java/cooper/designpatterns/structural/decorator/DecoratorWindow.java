/*
 * @(#)DecoratorWindow.java   2011-11-01
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

import cooper.designpatterns.util.swing.JxFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class description
 *
 * @author <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 * @version 0.1.1, 2011-11-01
 */
public class DecoratorWindow extends JxFrame implements ActionListener {
    JButton Quit;

    /**
     * Constructs ...
     */
    public DecoratorWindow() {
        super("Deco Button");

        JPanel jp = new JPanel();

        getContentPane().add(jp);
        jp.add(new CoolDecorator(new JButton("Cbutton")));
        jp.add(new SlashDecorator(new CoolDecorator(new JButton("Dbutton"))));

        // jp.add( new CoolDecorator(new JButton("Dbutton")));
        jp.add(Quit = new JButton("Quit"));
        Quit.addActionListener(this);
        setSize(new Dimension(200, 100));
        setVisible(true);
        Quit.requestFocus();
    }

    /**
     * Method description
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    /**
     * Method description
     *
     * @param argv
     */
    static public void main(String[] argv) {
        new DecoratorWindow();
    }
}
