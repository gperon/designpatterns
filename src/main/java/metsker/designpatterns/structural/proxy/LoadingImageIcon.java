/*
 * @(#)LoadingImageIcon.java   2011-11-01
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
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * This class acts as an ImageIcon that can have three images: an 'absent'
 * image, a 'loading' image, and the target image.
 * @author Steven J. Metsker
 */
public class LoadingImageIcon extends ImageIcon implements Runnable {
    static final ImageIcon ABSENT =
        new ImageIcon(ClassLoader.getSystemResource("images/absent.jpg"));
    static final ImageIcon LOADING =
        new ImageIcon(ClassLoader.getSystemResource("images/loading.jpg"));
    protected String filename;
    protected JFrame callbackFrame;

    /**
     * Construct an ImageIconLoader that will (on demand) load the image in the
     * provided file.
     * @param filename the name of a file to load
     */
    public LoadingImageIcon(String filename) {
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
