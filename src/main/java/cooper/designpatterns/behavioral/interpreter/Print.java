/*
 * @(#)Print.java   2011-11-01
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



package cooper.designpatterns.behavioral.interpreter;

import java.util.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class Print extends Verb {
    Kid[] kids;

    /**
     * Constructs ...
     *
     *
     * @param s
     */
    public Print(String s) {
        super(s);
        value = PRINT;
    }

    /**
     * Method description
     *
     */
    public void execute() {
        String pline;
        kids = data.getData();
        // ptable.setDims(kids.length, args.size());
        ptable.clear();
        for (int i = 0; i < kids.length; i++) {
            pline = "";    // line in output list
            for (int j = 0; j < args.size(); j++) {
                ParseVar v = (ParseVar) args.elementAt(j);
                if (v instanceof MultVar) {
                    MultVar mv = (MultVar) v;
                    Vector vlist = mv.getVector();
                    for (int k = 0; k < vlist.size(); k++) {
                        ParseVar pv = (ParseVar) vlist.elementAt(k);
                        // System.out.print(kids[i].getData(pv.getValue())+"   ");
                        pline += kids[i].getData(pv.getValue()) + "   ";
                    }
                } else {
                    // System.out.print(kids[i].getData(v.getValue())+"   ");
                    // ptable.setValueAt( kids[i].getData(v.getValue()), i, j);
                    pline += kids[i].getData(v.getValue()) + "   ";
                }
            }
            ptable.add(pline);
            // System.out.println();
        }
        ptable.validate();
        ptable.repaint();
    }
}
