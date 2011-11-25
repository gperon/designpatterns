/*
 * @(#)WrapFilter.java   2011-11-01
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



package metsker.designpatterns.util.filter;

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

import java.util.*;

/**
 * A WrapFilter object compresses whitespace and wraps text at a specified
 * width, optionally centering it. The class constructor requires a
 * BufferedWriter object and the line width. A typical filter class will accept
 * any Writer object in its constructor. The WrapFilter class requires a
 * BufferedWriter object because it requires the ability to write newlines in a
 * platform- independent way, and BufferedWriter supplies this ability.
 * <p>
 * The WrapFilter class expects line break indicators to appear as newline
 * characters. One way to arrange for this is to read input with a
 * BufferedReader object that handles platform differences in how line breaks
 * are indicated.
 * @author Steven J. Metsker
 */
public class WrapFilter extends OozinozFilter {
    protected int lineLength;
    protected StringBuffer lineBuf = new StringBuffer();
    protected StringBuffer wordBuf = new StringBuffer();
    protected boolean center = false;
    protected boolean inWhite = false;
    protected boolean needBlank = false;

    /**
     * Construct a filter that will wrap its writes at the specified length.
     * @param out a writer to which to pass down writes
     * @param lineLength the length at which to wrap text
     */
    public WrapFilter(BufferedWriter out, int lineLength) {
        super(out);
        this.lineLength = lineLength;
    }

    /**
     * Flush and close the stream.
     * @throws IOException if an I/O error occurs
     */
    public void close() throws IOException {
        flush();
        out.close();
    }

    /**
     * Write out any characters that were being held, awaiting a full line.
     * @throws IOException if an I/O error occurs
     */
    public void flush() throws IOException {
        if (wordBuf.length() > 0) {
            postWord();
        }
        if (lineBuf.length() > 0) {
            postLine();
        }
        out.flush();
    }

    /**
     * Write out the characters in the line buffer, optionally centering this
     * output.
     */
    protected void postLine() throws IOException {
        if (center) {
            int adjustment = Math.max(0, (lineLength - lineBuf.length()) / 2);
            char[] skootch = new char[adjustment];
            Arrays.fill(skootch, ' ');
            out.write(skootch);
        }
        out.write(lineBuf.toString());
    }

    /**
     * Add the word buffer to the line buffer, unless this would make the line
     * buffer too long. In that case, post the line buffer and then reset the
     * line buffer to the word buffer.
     */
    protected void postWord() throws IOException {
        if (lineBuf.length() + 1 + wordBuf.length() > lineLength) {
            postLine();
            ((BufferedWriter) out).newLine();
            lineBuf = wordBuf;
            wordBuf = new StringBuffer();
        } else {
            if (needBlank) {
                lineBuf.append(" ");
            }
            lineBuf.append(wordBuf);
            needBlank = true;
            wordBuf = new StringBuffer();
        }
    }

    /**
     * @param center If true, output text will be centered.
     */
    public void setCenter(boolean center) {
        this.center = center;
    }

    /**
     * Add the given character to the current word buffer, unless the character
     * is whitespace. Whitespace marks the end of words. On seeing end of a
     * word, "post" it.
     * @param c the character to write
     * @throws IOException if an I/O error occurs
     */
    public void write(int c) throws IOException {
        if (Character.isWhitespace((char) c)) {
            if (!inWhite) {
                postWord();
            }
            inWhite = true;
        } else {
            wordBuf.append((char) c);
            inWhite = false;
        }
    }
}
