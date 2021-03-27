/*
 * @(#)Imager.java   2011-11-01
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

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.io.File;

/**
 * Class description
 *
 * @author <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 * @version 0.1.1, 2011-11-01
 */
public class Imager extends JPanel implements Chain {
    private Chain nextChain;
    private transient Image img;
    private boolean loaded;

    public Imager() {
        super();
        loaded = false;
        setBorder(new BevelBorder(BevelBorder.RAISED));
    }

    /**
     * Method description
     *
     * @param c
     */
    public void addChain(Chain c) {
        nextChain = c;    // next in chain of resp
    }

    private boolean findImage(String file) {
        XFile xfile = null;
        File dir = new File(System.getProperty("user.dir"));
        boolean found = false;
        String[] files = dir.list();
        int i = 0;

        while ((!found) && (i < files.length)) {
            xfile = new XFile(files[i]);
            found = xfile.matchRoot(file);

            if (!found) {
                i++;
            }
        }

        if (found) {
            return xfile.matchName(file + ".jpg");
        } else {
            return found;    // false
        }
    }

    private void loadImage(String file) {
        loaded = false;

        MediaTracker tracker = new MediaTracker(this);

        img = Toolkit.getDefaultToolkit().getImage(file);
        tracker.addImage(img, 0);    // watch for image loading

        // this begins actual image loading
        try {
            tracker.waitForID(0, 1);
        } catch (InterruptedException ignore) {
        }

        loaded = true;
        validate();
        repaint();
    }

    /**
     * Method description
     *
     * @param g
     */
    public void paint(Graphics g) {
        if (loaded) {
            g.drawImage(img, 0, 0, this);
        }
    }

    /**
     * Method description
     *
     * @param mesg
     */
    public void sendToChain(String mesg) {

        // if there is a JPEG file with this root name
        // load it and display it.
        if (findImage(mesg)) {
            loadImage(mesg + ".jpg");
        } else {

            // Otherwise, pass request along chain
            nextChain.sendToChain(mesg);
        }
    }

    /**
     * Method description
     *
     * @return
     */
    public Chain getChain() {
        return nextChain;
    }
}
