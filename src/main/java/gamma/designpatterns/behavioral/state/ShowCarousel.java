/*
 * @(#)ShowCarousel.java   2011-11-01
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



package gamma.designpatterns.behavioral.state;

import gamma.designpatterns.structural.proxy.SwingFacade;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class ShowCarousel implements ActionListener {
    private Box buttonBox;
    private CarouselPanel doorPanel;
    private JPanel mainPanel;

    /**
     * Let the carousel know that someone pushed its button.
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        carousel.click();
    }

    /*
     * A container for the status label and the "One Touch"
     * button.
     */
    protected Box buttonBox() {
        if (buttonBox == null) {
            buttonBox = Box.createHorizontalBox();
            buttonBox.add(status());
            buttonBox.add(Box.createHorizontalGlue());
            buttonBox.add(button());
        }

        return buttonBox;
    }

    /**
     * Shows what the carousel door looks like.
     *
     * @param args
     */
    public static void main(String[] args) {
        ShowCarousel app = new ShowCarousel();
        SwingFacade.launch(app.mainPanel(), " Carousel");
        app.start();
    }

    /*
     * The panel that contains all the GUI components.
     */
    protected JPanel mainPanel() {
        if (mainPanel == null) {
            mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());
            mainPanel.add(doorPanel());
            mainPanel.add(buttonBox(), "South");
        }

        return mainPanel;
    }

    private JButton button;
    private Carousel carousel = new Carousel();
    private JLabel status;

    protected JButton button() {
        if (button == null) {
            button = new JButton("One Touch");
            button.addActionListener(this);
        }

        return button;
    }

    protected void start() {
        carousel.start();
    }

    protected JLabel status() {
        if (status == null) {
            status = new CarouselLabel(carousel);
        }

        return status;
    }

    protected CarouselPanel doorPanel() {
        if (doorPanel == null) {
            doorPanel = new CarouselPanel(carousel);
        }

        return doorPanel;
    }
}
