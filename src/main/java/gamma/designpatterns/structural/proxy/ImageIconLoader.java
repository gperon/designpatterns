/*
 * @(#)ImageIconLoader.java   2011-11-01
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

import javax.swing.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class ImageIconLoader extends ImageIcon implements Runnable {
    static final ImageIcon ABSENT = new ImageIcon(ClassLoader.getSystemResource("absent.jpg"));
    static final ImageIcon LOADING = new ImageIcon(ClassLoader.getSystemResource("loading.jpg"));
    protected String filename;
    protected JFrame callbackFrame;

    /**
     * Construct an ImageIconLoader that will (on demand)
     * load the image in the provided file.
     *
     * @param filename the name of a file to load
     */
    public ImageIconLoader(String filename) {
        super(ABSENT.getImage());
        this.filename = filename;
    }

    /**
     * Load the desired image and call back the provided frame
     * when done.
     *
     *
     * @param callbackFrame
     */
    public void load(JFrame callbackFrame) {
        this.callbackFrame = callbackFrame;
        setImage(LOADING.getImage());
        callbackFrame.repaint();
        new Thread(this).start();
    }

    /**
     * Load the desired image (presumably in a separate thread).
     */
    public void run() {
        setImage(new ImageIcon(ClassLoader.getSystemResource(filename)).getImage());
        callbackFrame.pack();
    }
}
