/*
 * @(#)NoCommand.java   2011-11-01
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
public class NoCommand extends Frame implements ActionListener {
    Menu mnuFile;
    MenuItem mnuOpen, mnuExit;
    Button btnRed;
    Panel p;

    /**
     * Constructs ...
     *
     */
    public NoCommand() {
        super("Frame without commands");
        MenuBar mbar = new MenuBar();
        setMenuBar(mbar);
        mnuFile = new Menu("File", true);
        mbar.add(mnuFile);
        mnuOpen = new MenuItem("Open...");
        mnuFile.add(mnuOpen);
        mnuExit = new MenuItem("Exit");
        mnuFile.add(mnuExit);
        mnuOpen.addActionListener(this);
        mnuExit.addActionListener(this);
        btnRed = new Button("Red");
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
        Object obj = e.getSource();
        if (obj == mnuOpen) {
            fileOpen();
        }
        if (obj == mnuExit) {
            exitClicked();
        }
        if (obj == btnRed) {
            redClicked();
        }
    }

    private void exitClicked() {
        System.exit(0);
    }

    private void fileOpen() {
        FileDialog fDlg = new FileDialog(this, "Open a file", FileDialog.LOAD);
        fDlg.setVisible(true);
    }

    private void redClicked() {
        p.setBackground(Color.red);
    }

    /**
     * Method description
     *
     *
     * @param argv
     */
    static public void main(String argv[]) {
        new NoCommand();
    }
}
