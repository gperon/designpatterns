/*
 * @(#)xMenu.java   2011-11-01
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



package cooper.designpatterns.util.swing.menu;

import cooper.designpatterns.util.swing.JxFrame;

import java.awt.*;

import javax.swing.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class xMenu extends JxFrame {
    JPanel jp;
    JMenuItem menuitem;
    JToolBar toolbar;

    /**
     * Constructs ...
     *
     */
    public xMenu() {
        super("Extended Menu");
        JMenuBar mbar = new JMenuBar();    // set up  menu bar
        setJMenuBar(mbar);
        // Add File menu
        JMenu mFile = new JMenu("File");
        mbar.add(mFile);
        // create two Action Objects
        Action Open = new FileButton("Open", new ImageIcon("open.gif"), this);
        mFile.add(Open);
        Action Exit = new ExitButton("Exit", new ImageIcon("exit.gif"), this);
        mFile.addSeparator();
        mFile.add(Exit);
        // now create toolbar that fixes up the buttons as you add them
        toolbar = new JToolBar();
        getContentPane().add(jp = new JPanel());
        jp.setLayout(new BorderLayout());
        jp.add("North", toolbar);
        // add the two action objects
        toolbar.add(Open);
        toolbar.addSeparator();
        toolbar.add(Exit);
        setSize(300, 200);
        setVisible(true);
    }

    /**
     * Method description
     *
     *
     * @param argv
     */
    static public void main(String argv[]) {
        new xMenu();
    }
}
