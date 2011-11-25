/*
 * @(#)ShowBrightness.java   2011-11-01
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



package metsker.designpatterns.structural.decorator;

import metsker.designpatterns.util.ui.SwingFacade;
import metsker.designpatterns.structural.decorator.Arithmetic;
import metsker.designpatterns.structural.decorator.Constant;
import metsker.designpatterns.structural.decorator.Exp;
import metsker.designpatterns.structural.decorator.Function;
import metsker.designpatterns.structural.decorator.Sin;
import metsker.designpatterns.structural.decorator.T;

/**
 * Show the brightness of a (fireworks) star.
 *
 * @author Steven J. Metsker
 */
public class ShowBrightness {

    /**
     * Method description
     *
     *
     * @param args
     */
    public static void main(String args[]) {
        FunPanel panel = new FunPanel();
        panel.setPreferredSize(new java.awt.Dimension(200, 200));
        Function brightness = new Arithmetic('*',
                                  new Exp(new Arithmetic('*', new Constant(-4), new T())),
                                  new Sin(new Arithmetic('*', new Constant(Math.PI), new T())));
        panel.setXY(new T(), brightness);
        SwingFacade.launch(panel, "Brightness");
    }
}
