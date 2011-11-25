/*
 * @(#)BallisticsLabel2.java   2011-11-01
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
import javax.swing.*;
import javax.swing.event.*;

import metsker.designpatterns.util.Format;

/**
 * Instances of this class are labels that show the value of a slider as a
 * percentage of the slider's progress from its minimum to its maximum.
 *
 * @author Steven J. Metsker
 */
public class BallisticsLabel2 extends JLabel implements ChangeListener {

    /**
     * Update the label when the slider moves.
     * @param e ChangeEvent object (ignored)
     */
    public void stateChanged(ChangeEvent e) {
        double val = slider.getValue();
        double max = slider.getMaximum();
        double min = slider.getMinimum();
        double tPeak = (val - min) / (max - min);
        setText(Format.formatToNPlaces(tPeak, 2));
    }

    protected JSlider slider;

    /**
     * Construct a label that will show the value of a slider.
     *
     *
     * @param slider
     */
    public BallisticsLabel2(JSlider slider) {
        this.slider = slider;
        setText("0.00");
        slider.addChangeListener(this);
    }
}
