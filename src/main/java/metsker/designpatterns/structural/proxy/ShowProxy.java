/*
 * @(#)ShowProxy.java   2011-11-01
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
import metsker.designpatterns.util.ui.SwingFacade;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Show the use of ImageIconProxy. This application is discussed in the "Proxy"
 * chapter of "Design Patterns in Java." We later tear out this code,
 * preferring the techniques used in the ImageIconLoader class. For this class
 * to execute, an "images" directory must be in the classpath, and this
 * directory must contain absent.jpg, loading.jpg, and fest.jpg.
 * @author Steven J. Metsker
 * @see ImageIconProxy
 * @see LoadingImageIcon
 */
public class ShowProxy implements ActionListener {
    private ImageIconProxy proxy = new ImageIconProxy("images/fest.jpg");
    private JFrame frame;
    private JButton loadButton;

    /**
     * Start loading the image and disable the Load button.
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        proxy.load(frame);
        loadButton().setEnabled(false);
    }

    protected JButton loadButton() {
        if (loadButton == null) {
            loadButton = new JButton("Load");
            loadButton.addActionListener(this);
            loadButton.setFont(SwingFacade.getStandardFont());
        }

        return loadButton;
    }

    /**
     * Show the use of ImageIconProxy.
     *
     * @param args
     */
    public static void main(String[] args) {
        ShowProxy sp = new ShowProxy();
        sp.frame = SwingFacade.launch(sp.mainPanel(), " Proxy");
    }

    protected JPanel mainPanel() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add("Center", new JLabel(proxy));
        p.add("South", loadButton());

        return p;
    }
}
