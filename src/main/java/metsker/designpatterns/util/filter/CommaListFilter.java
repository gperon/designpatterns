/*
 * @(#)CommaListFilter.java   2011-11-01
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
import java.io.IOException;
import java.io.Writer;

/**
 * This filter adds comma separators between writes.
 */
public class CommaListFilter extends OozinozFilter {
    protected boolean needComma = false;

    /**
     * Construct a filter that pass random case characters to the supplied
     * stream.
     *
     * @param writer a stream to pass bytes to
     */
    public CommaListFilter(Writer writer) {
        super(writer);
    }

    /**
     * Plug a comma and a blank in front of this character if need be.
     * @param c the character to write
     *
     * @throws IOException
     */
    public void write(int c) throws IOException {
        if (needComma) {
            out.write(',');
            out.write(' ');
        }
        out.write(c);
        needComma = true;
    }

    /**
     * Plug a comma and a blank in front of this string if need be.
     * @param s the string to write
     *
     * @throws IOException
     */
    public void write(String s) throws IOException {
        if (needComma) {
            out.write(", ");
        }
        out.write(s);
        needComma = true;
    }
}
