/*
 * @(#)ImageIconProxy.java   2011-11-01
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



package metsker.designpatterns.structural.proxy;

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

/**
 * This class acts as a proxy for another ImageIcon. In "The Design Patterns
 * in Java" we wind up tearing out this class, preferring the techniques
 * used in the ImageIconLoader class.
 * @author Steven J. Metsker
 * @see LoadingImageIcon
 */
public class ImageIconProxy extends ImageIcon implements Runnable {
    static final ImageIcon ABSENT =
        new ImageIcon(ClassLoader.getSystemResource("images/absent.jpg"));
    static final ImageIcon LOADING =
        new ImageIcon(ClassLoader.getSystemResource("images/loading.jpg"));
    ImageIcon current = ABSENT;
    protected String filename;
    protected JFrame callbackFrame;

    /**
     * Construct an ImageIconProxy that will (on demand) load the image in the
     * provided file.
     * @param filename the name of a file to load
     */
    public ImageIconProxy(String filename) {
        super(ABSENT.getImage());
        this.filename = filename;
    }

    /**
     * Load the desired image and call back the provided frame when done.
     *
     * @param callbackFrame
     */
    public void load(JFrame callbackFrame) {
        this.callbackFrame = callbackFrame;
        current = LOADING;
        callbackFrame.repaint();
        new Thread(this).start();
    }

    /**
     * Load the desired image (presumably in a separate thread).
     */
    public void run() {
        current = new ImageIcon(ClassLoader.getSystemResource(filename));
        callbackFrame.pack();
    }

    /**
     * @return the height of the Icon
     */
    public int getIconHeight() {
        return current.getIconHeight();
    }

    /**
     * @return the width of the Icon
     */
    public int getIconWidth() {
        return current.getIconWidth();
    }

    /**
     * Paint the Icon
     *
     * @param c
     * @param g
     * @param x
     * @param y
     */
    public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
        current.paintIcon(c, g, x, y);
    }
}
