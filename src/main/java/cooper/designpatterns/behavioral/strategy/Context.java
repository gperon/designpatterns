/*
 * @(#)Context.java   2011-11-01
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



package cooper.designpatterns.behavioral.strategy;

import cooper.designpatterns.util.swing.InputFile;

import java.awt.*;

import java.util.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class Context {
    // this object selects one of the strategies
    // to be used for plotting
    private PlotStrategy plotStrategy;
    float x[], y[];

    /**
     * Constructs ...
     *
     */
    public Context() {
        setLinePlot();
    }

    /**
     * Method description
     *
     */
    public void setBarPlot() {
        plotStrategy = new BarPlotStrategy();
    }

    /**
     * Method description
     *
     */
    public void setLinePlot() {
        plotStrategy = new LinePlotStrategy();
    }

    /**
     * Method description
     *
     */
    public void plot() {
        plotStrategy.plot(x, y);
    }

    /**
     * Method description
     *
     *
     * @param c
     */
    public void setPenColor(Color c) {
        plotStrategy.setPenColor(c);
    }

    /**
     * Method description
     *
     *
     * @param filename
     */
    public void readData(String filename) {
        StringTokenizer tok;
        InputFile f = new InputFile(getClass(), filename);
        Vector xv = new Vector();
        Vector yv = new Vector();
        String s = "";
        // read data into 2 Vectors
        while (s != null) {
            s = f.readLine();                      // read a line at a time
            if (s != null) {
                tok = new StringTokenizer(s);
                xv.addElement(tok.nextToken());    // x data
                yv.addElement(tok.nextToken());    // y data
            }
        }
        f.close();
        // copy data into two float arrays
        x = new float[xv.size()];
        y = new float[yv.size()];
        for (int i = 0; i < xv.size(); i++) {
            x[i] = new Float((String) xv.elementAt(i)).floatValue();
            y[i] = new Float((String) yv.elementAt(i)).floatValue();
        }
    }
}
