/*
 * @(#)OozinozFilter.java   2011-11-01
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

/**
 * This class channels all versions of the write() method to go through the
 * write() method that takes a single character.
 *
 * @author Steven J. Metsker
 */
public abstract class OozinozFilter extends FilterWriter {
    protected OozinozFilter(Writer out) {
        super(out);
    }

    /**
     * Write a portion of an array of characters.
     *
     * @param cbuf
     *            Buffer of characters to be written
     * @param offset
     *            Offset from which to start reading characters
     * @param length
     *            Number of characters to be written
     *
     * @throws IOException
     *             if an I/O error occurs
     */
    public void write(char cbuf[], int offset, int length) throws IOException {
        for (int i = 0; i < length; i++) {
            write(cbuf[offset + i]);
        }
    }

    /**
     * Write a single character.
     *
     *
     * @param c
     * @throws IOException if an I/O error occurs
     */
    public abstract void write(int c) throws IOException;

    /**
     * Write a portion of a string.
     *
     *
     * @param s
     * @param offset
     *            Offset from which to start reading characters
     * @param length
     *            Number of characters to be written
     *
     * @throws IOException
     *             if an I/O error occurs
     */
    public void write(String s, int offset, int length) throws IOException {
        write(s.toCharArray(), offset, length);
    }
}
