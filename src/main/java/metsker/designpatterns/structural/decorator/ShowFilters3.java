/*
 * @(#)ShowFilters3.java   2011-11-01
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
import java.io.*;

import metsker.designpatterns.util.filter.RandomCaseFilter;
import metsker.designpatterns.util.filter.WrapFilter;

/**
 * This class just shows a slightly different approach to the same service that
 * ShowFilters2 provides.
 *
 * @author Steven J. Metsker
 */
public class ShowFilters3 {

    /**
     * Method description
     *
     *
     * @param args
     *
     * @throws IOException
     */
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        WrapFilter out =
            new WrapFilter(new BufferedWriter(new RandomCaseFilter(new PrintWriter(System.out))),
                           15);
        out.setCenter(true);
        while (true) {
            String s = in.readLine();
            if (s == null) {
                break;
            }
            out.write(s + "\n");
        }
        out.close();
        in.close();
    }
}
