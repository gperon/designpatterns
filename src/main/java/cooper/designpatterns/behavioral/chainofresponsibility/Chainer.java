/*
 * @(#)Chainer.java   2011-11-01
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

import cooper.designpatterns.util.swing.JxFrame;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class Chainer extends JxFrame {
    // list of chain members
    Sender sender;            // gets commands
    Imager imager;            // displays images
    FileList fileList;        // highlights file names
    ColorImage colorImage;    // shows colors
    RestList restList;        // shows rest of list

    /**
     * Constructs ...
     *
     */
    public Chainer() {
        super("Chain demo");
        JPanel jp = new JPanel();
        jp.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(jp);
        jp.setLayout(new GridLayout(1, 3));
        JPanel left = new JPanel();
        jp.add(left);
        left.setLayout(new GridLayout(2, 1));
        // create send panel and image display panel
        sender = new Sender();
        imager = new Imager();
        left.add(imager);
        left.add(sender);
        // create file list and color panels
        JPanel mid = new JPanel();
        jp.add(mid);
        mid.setBorder(new EmptyBorder(5, 5, 5, 5));
        mid.setLayout(new GridLayout(2, 1));
        fileList = new FileList();
        colorImage = new ColorImage();
        mid.add(fileList);
        mid.add(colorImage);
        // put list for rest of commands in right panel
        restList = new RestList();
        jp.add(restList);
        // set up the chain of responsibility
        sender.addChain(imager);
        imager.addChain(colorImage);
        colorImage.addChain(fileList);
        fileList.addChain(restList);
        // set up visual shape
        setSize(new Dimension(500, 300));
        setVisible(true);
    }

    /**
     * Method description
     *
     *
     * @param argv
     */
    static public void main(String argv[]) {
        new Chainer();
    }
}
