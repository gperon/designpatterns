/*
 * @(#)FileList.java   2011-11-01
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



package cooper.designpatterns.behavioral.chainofresponsibility;

import javax.swing.border.*;

import java.awt.*;

import java.io.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class FileList extends RestList {
    String files[];
    private Chain nextChain;

    /**
     * Constructs ...
     *
     */
    public FileList() {
        super();
        setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new LineBorder(Color.black)));
        String tmp = "";
        File dir = new File(System.getProperty("user.dir"));
        files = dir.list();
        for (int i = 0; i < files.length; i++) {
            for (int j = i; j < files.length; j++) {
                if (files[i].toLowerCase().compareTo(files[j].toLowerCase()) > 0) {
                    tmp = files[i];
                    files[i] = files[j];
                    files[j] = tmp;
                }
            }
        }
        for (int i = 0; i < files.length; i++) {
            add(files[i]);
        }
    }

    /**
     * Method description
     *
     *
     * @param mesg
     */
    public void sendToChain(String mesg) {
        boolean found = false;
        int i = 0;
        while ((!found) && (i < files.length)) {
            XFile xfile = new XFile(files[i]);
            found = xfile.matchRoot(mesg);
            if (!found) {
                i++;
            }
        }
        if (found) {
            setSelectedIndex(i);
        } else {
            if (nextChain != null) {
                nextChain.sendToChain(mesg);
            }
        }
    }

    /**
     * Method description
     *
     *
     * @param c
     */
    public void addChain(Chain c) {
        nextChain = c;    // next in chain of resp
    }

    private void setSelectedIndex(int i) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
