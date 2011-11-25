/*
 * @(#)ShowBallistics2.java   2011-11-01
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



package metsker.designpatterns.behavioral.observer;

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
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import metsker.designpatterns.util.ui.SwingFacade;

/**
 * Show the standard burn rate and thrust equations. This class is covered in
 * the Observer chapter where the class is refactored. The
 * refactoring relieves this class of the responsibility for telling
 * interested components that the slider moved.
 *
 * @author Steven J. Metsker
 */
public class ShowBallistics2 {
    protected BallisticsPanel2 burnPanel;
    protected JSlider slider;
    protected double sliderMax;
    protected double sliderMin;
    protected BallisticsPanel2 thrustPanel;
    protected JLabel valueLabel;

    /**
     * Show the standard burn rate and thrust equations.
     *
     * @param args
     */
    public static void main(String[] args) {
        SwingFacade.launch(new ShowBallistics2().mainPanel(), "Effects of tPeak");
    }

    protected BallisticsPanel2 burnPanel() {
        if (burnPanel == null) {
            burnPanel = new BallisticsPanel2(Ballistics.rate(), slider());
            burnPanel.setPreferredSize(new Dimension(300, 200));
        }

        return burnPanel;
    }

    /*
     * A panel to contain the two plots.
     */
    protected JPanel curvePanel() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 2));
        p.add(SwingFacade.createTitledPanel("Burn Rate", burnPanel()));
        p.add(SwingFacade.createTitledPanel("Thrust", thrustPanel()));

        return p;
    }

    /**
     * The main panel -- the one that actually gets displayed.
     */
    protected JPanel mainPanel() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(curvePanel(), "Center");
        p.add(sliderBox(), "South");

        return p;
    }

    protected JSlider slider() {
        if (slider == null) {
            slider = new JSlider();
            sliderMax = slider.getMaximum();
            sliderMin = slider.getMinimum();
            slider.setValue(slider.getMinimum());
        }

        return slider;
    }

    /*
     * The box that holds the slider plus a textual label and a changing label
     * that shows the value of the slider.
     */
    protected Box sliderBox() {
        Box b = Box.createHorizontalBox();
        JLabel label = new JLabel("tPeak");
        label.setFont(SwingFacade.getStandardFont());
        label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        label.setForeground(java.awt.Color.black);
        b.add(label);
        b.add(valueLabel());
        b.add(slider());

        return b;
    }

    protected BallisticsPanel2 thrustPanel() {
        if (thrustPanel == null) {
            thrustPanel = new BallisticsPanel2(Ballistics.thrust(), slider());
            thrustPanel.setPreferredSize(new Dimension(300, 200));
        }

        return thrustPanel;
    }

    protected JLabel valueLabel() {
        if (valueLabel == null) {
            valueLabel = new BallisticsLabel2(slider());
            valueLabel.setFont(SwingFacade.getStandardFont());
            valueLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
            valueLabel.setForeground(java.awt.Color.black);
        }

        return valueLabel;
    }
}
