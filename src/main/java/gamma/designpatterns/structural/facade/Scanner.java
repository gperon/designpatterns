/*
 * @(#)Scanner.java   2011-11-01
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



package gamma.designpatterns.structural.facade;

import java.io.*;

import java.util.*;

/**
 * <p>Title: Design Patterns</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2003-2005</p>
 *
 * <p>Company: GioPerLab</p>
 *
 * @author giorgio_peron@libero.it
 * @version 1.0
 */
public class Scanner {
    private InputStream is;
    private StringBuffer lexbuf = new StringBuffer(128);
    private int lineno;
    private int position;
    private static Map<String, TokenType> lookup = new HashMap();

    static {
        lookup.put("div", TokenType.DIV);
        lookup.put("mod", TokenType.MOD);
    }

    /**
     * Constructs ...
     *
     *
     * @param is
     */
    public Scanner(InputStream is) {
        this.is = is;
    }

    /**
     * Method description
     *
     *
     * @return
     *
     * @throws IOException
     */
    public Token scan() throws IOException {
        int t = 0;
        while (true) {
            t = is.read();
            position++;
            // System.out.println("character[" + (char) t + "] (" + t + ")");
            if ((t == ' ') || (t == '\t')) {
                position++;
            } else if (t == '\n') {
                lineno++;
                position = 0;
            } else if (Character.isDigit(t)) {
                lexbuf.delete(0, 128);
                while (Character.isDigit(t)) {
                    lexbuf.append((char) t);
                    is.mark(0);
                    t = is.read();
                    position++;
                    // System.out.println("character[" + (char) t + "] (" + t + ")");
                }
                if (t != -1) {
                    is.reset();
                    position--;
                }

                return new Token(TokenType.NUM, lexbuf.toString());
            } else if (Character.isLetter(t)) {
                lexbuf.delete(0, 128);
                while (Character.isLetterOrDigit(t)) {
                    lexbuf.append((char) t);
                    is.mark(0);
                    t = is.read();
                    position++;
                    // System.out.println("character[" + (char) t + "] (" + t + ")");
                }
                if (t != -1) {
                    is.reset();
                    position--;
                }
                TokenType tt = lookup.get(lexbuf.toString());
                if (tt == null) {
                    lookup.put(lexbuf.toString(), TokenType.ID);

                    return new Token(TokenType.ID, lexbuf.toString());
                } else {
                    return new Token(tt, lexbuf.toString());
                }
            } else if ((t == -1) || (t == 0)) {
                return new Token(TokenType.DONE);
            } else {
                return new Token((char) t);
            }
        }
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getLine() {
        return lineno;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getPosition() {
        return position;
    }
}
