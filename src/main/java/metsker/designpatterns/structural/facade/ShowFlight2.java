/*
 * @(#)ShowFlight2.java   2011-11-01
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



package metsker.designpatterns.structural.facade;

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
import java.awt.Dimension;

import javax.swing.JFrame;

import metsker.designpatterns.structural.decorator.Function;
import metsker.designpatterns.structural.decorator.T;
import metsker.designpatterns.util.ui.PlotPanel;
import metsker.designpatterns.util.ui.UI;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>    
 */
public class ShowFlight2 {

    /**
     * Show the flight path of a nonexploding aerial shell.
     *
     * @param args
     */
    public static void main(String[] args) {
        PlotPanel p = new PlotPanel(101, new T(), new ShowFlight2().new YFunction());
        p.setPreferredSize(new Dimension(300, 200));
        JFrame frame = new JFrame("Flight Path for Shell Duds");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(UI.NORMAL.createTitledPanel("Flight Path", p));
        frame.pack();
        frame.setVisible(true);
    }

    private class YFunction extends Function {

        /**
         * Constructs ...
         *
         */
        public YFunction() {
            super(new Function[] {});
        }

        /**
         * Method description
         *
         *
         * @param t
         *
         * @return
         */
        public double f(double t) {
            // y is 0 at t = 0, 1; y is 1 at t = .5
            return 4 * t * (1 - t);
        }
    }
}
