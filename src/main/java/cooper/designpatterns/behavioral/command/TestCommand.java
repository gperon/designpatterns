/*
 * @(#)TestCommand.java   2011-11-01
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



package cooper.designpatterns.behavioral.command;

import java.awt.*;
import java.awt.event.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class TestCommand extends Frame implements ActionListener {
    Menu mnuFile;
    fileOpenCommand mnuOpen;
    fileExitCommand mnuExit;
    btnRedCommand btnRed;
    Panel p;
    Frame fr;

    /**
     * Constructs ...
     *
     */
    public TestCommand() {
        super("Frame without commands");
        fr = this;    // save frame object
        MenuBar mbar = new MenuBar();
        setMenuBar(mbar);
        mnuFile = new Menu("File", true);
        mbar.add(mnuFile);
        mnuOpen = new fileOpenCommand("Open...");
        mnuFile.add(mnuOpen);
        mnuExit = new fileExitCommand("Exit");
        mnuFile.add(mnuExit);
        mnuOpen.addActionListener(this);
        mnuExit.addActionListener(this);
        btnRed = new btnRedCommand("Red");
        p = new Panel();
        add(p);
        p.add(btnRed);
        btnRed.addActionListener(this);
        setBounds(100, 100, 200, 100);
        setVisible(true);
    }

    /**
     * Method description
     *
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        Command obj = (Command) e.getSource();
        obj.execute();
    }

    /**
     * Method description
     *
     *
     * @param argv
     */
    static public void main(String argv[]) {
        new TestCommand();
    }

    /**
     * inner class
     */
    class btnRedCommand extends Button implements Command {

        /**
         * Constructs ...
         *
         *
         * @param caption
         */
        public btnRedCommand(String caption) {
            super(caption);
        }

        /**
         * Method description
         *
         */
        public void execute() {
            p.setBackground(Color.red);
        }
    }


    class fileOpenCommand extends MenuItem implements Command {

        /**
         * Constructs ...
         *
         *
         * @param caption
         */
        public fileOpenCommand(String caption) {
            super(caption);
        }

        /**
         * Method description
         *
         */
        public void execute() {
            FileDialog fDlg = new FileDialog(fr, "Open file");
            fDlg.setVisible(true);
        }
    }


    class fileExitCommand extends MenuItem implements Command {

        /**
         * Constructs ...
         *
         *
         * @param caption
         */
        public fileExitCommand(String caption) {
            super(caption);
        }

        /**
         * Method description
         *
         */
        public void execute() {
            System.exit(0);
        }
    }
}
