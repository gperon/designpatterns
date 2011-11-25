/*
 * @(#)ProxyDisplay.java   2011-11-01
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



package cooper.designpatterns.structural.proxy;

import cooper.designpatterns.util.swing.JxFrame;

import javax.swing.*;

import java.awt.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class ProxyDisplay extends JxFrame {

    /**
     * Constructs ...
     *
     */
    public ProxyDisplay() {
        super("Display proxied image");
        JPanel p = new JPanel();
        getContentPane().add(p);
        p.setLayout(new BorderLayout());
        ImageProxy image = new ImageProxy("elliott.jpg", 321, 271);
        p.add("Center", image);
        p.add("North", new Label("    "));
        p.add("West", new Label("  "));
        setSize(370, 350);
        setVisible(true);
    }

    /**
     * Method description
     *
     *
     * @param argv
     */
    static public void main(String[] argv) {
        new ProxyDisplay();
    }
}


class ImageProxy extends JPanel implements Runnable {
    int height, width;
    MediaTracker tracker;
    Image img;
    JFrame frame;
    Thread imageCheck;    // to monitor loading

    /**
     * Constructs ...
     *
     *
     * @param filename
     * @param w
     * @param h
     */
    public ImageProxy(String filename, int w, int h) {
        height = h;
        width = w;
        tracker = new MediaTracker(this);
        img = Toolkit.getDefaultToolkit().getImage(getClass().getResource(filename));
        tracker.addImage(img, 0);    // watch for image loading
        imageCheck = new Thread(this);
        imageCheck.start();    // start 2nd thread monitor
        // this begins actual image loading
        try {
            tracker.waitForID(0, 1);
        } catch (InterruptedException e) {}
    }

    /**
     * Method description
     *
     *
     * @param g
     */
    public void paint(Graphics g) {
        if (tracker.checkID(0)) {
            height = img.getHeight(frame);    // get height
            width = img.getWidth(frame);      // and width
            g.setColor(Color.lightGray);      // erase box
            g.fillRect(0, 0, width, height);
            g.drawImage(img, 0, 0, this);     // draw loaded image
        } else {
            // draw box outlining image if not loaded yet
            g.setColor(Color.black);
            g.drawRect(1, 1, width - 2, height - 2);
        }
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    // public int getWidth() {return width;}
    // public int getHeight(){return height;}
    // ------------------------------------

    /**
     * Method description
     *
     */
    public void run() {
        // this thread monitors image loading
        // and repaints when done
        // the 1000 msec is artifically long
        // to allow demo to display with delay
        try {
            Thread.sleep(3000);
            while (!tracker.checkID(0)) {
                Thread.sleep(1000);
            }
        } catch (Exception e) {}
        repaint();
    }
}
