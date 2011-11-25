/*
 * @(#)InputFile.java   2011-11-01
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

import java.io.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class InputFile {
    RandomAccessFile f = null;
    boolean errflag;
    String s = null;

    /**
     * Constructs ...
     *
     *
     * @param fname
     */
    public InputFile(String fname) {
        errflag = false;
        try {
            // open file
            f = new RandomAccessFile(fname, "r");
        } catch (IOException e) {
            // print error if not found
            System.out.println("no file found");
            errflag = true;    // and set flag
        }
    }

//  -----------------------------------------

    /**
     * Method description
     *
     *
     * @return
     */
    public boolean checkErr() {
        return errflag;
    }

//  -----------------------------------------

    /**
     * Method description
     *
     *
     * @return
     */
    public String read() {
//      read a single field up to a comma or end of line
        String ret = "";
        if (s == null)         // if no data in string
        {
            s = readLine();    // read next line
        }
        if (s != null)                             // if there is data
        {
            s.trim();                              // trim off blanks
            int i = s.indexOf(",");                // find next comma
            if (i <= 0) {
                ret = s.trim();                    // if no commas go to end of line
                s = null;                          // and null out stored string
            } else {
                ret = s.substring(0, i).trim();    // return left of comma
                s = s.substring(i + 1);            // save right of comma
            }
        } else {
            ret = null;
        }

        return ret;    // return string
    }

//  -----------------------------------------

    /**
     * Method description
     *
     *
     * @return
     */
    public String readLine() {
        // read in a line from the file
        s = null;
        try {
            s = f.readLine();    // could throw error
        } catch (IOException e) {
            errflag = true;
            System.out.println("File read error");
        }

        return s;
    }

//  -----------------------------------------

    /**
     * Method description
     *
     */
    public void close() {
        try {
            f.close();    // close file
        } catch (IOException e) {
            System.out.println("File close error");
            errflag = true;
        }
    }
//  -----------------------------------------
}
