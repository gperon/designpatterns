/*
 * @(#)BallisticsPanel2.java   2011-11-01
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
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import metsker.designpatterns.behavioral.observer.BallisticsFunction;

/**
 * Plot a ballistics function. This class is refactored from BallisticsPanel_1
 * to register its interest in a slider's value.
 *
 * @author Steven J. Metsker
 */
public class BallisticsPanel2 extends JPanel implements ChangeListener {
    protected BallisticsFunction func;
    protected int nPoint = 101;
    protected double tPeak = 0.0;
    protected int[] x = new int[nPoint];
    protected int[] y = new int[nPoint];
    protected JSlider slider;

    /**
     * Create a panel that can display the provided function, evaluated against
     * the value of the provided slider.
     *
     * @param func
     *            the ballistics function to plot. Ballistics functions vary
     *            with time and with the time of peak burn area.
     * @param slider
     *
     */
    public BallisticsPanel2(BallisticsFunction func, JSlider slider) {
        this.func = func;
        this.slider = slider;
        slider.addChangeListener(this);
    }

    /**
     * Update the label when the slider moves.
     *
     * @param e ChangeEvent object (ignored)
     */
    public void stateChanged(ChangeEvent e) {
        double val = slider.getValue();
        double max = slider.getMaximum();
        double min = slider.getMinimum();
        tPeak = (val - min) / (max - min);
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);    // paint the background
        for (int i = 0; i < nPoint; i++) {
            double t = ((double) i) / (nPoint - 1);
            x[i] = (int) (t * getWidth());
            y[i] = (int) (getHeight() * (1 - func.function(t, tPeak)));
        }
        g.drawPolyline(x, y, nPoint);
    }
}
