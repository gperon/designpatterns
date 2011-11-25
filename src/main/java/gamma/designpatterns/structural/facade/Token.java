/*
 * @(#)Token.java   2011-11-01
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
public class Token {
    private TokenType type;
    private String value;

    Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    Token(char value) {
        this.value = String.valueOf(value);
        this.type = TokenType.getTypeBySymbol(value);
    }

    Token(TokenType type) {
        this(type, type.toString());
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public TokenType getType() {
        return type;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Object getValue() {
        switch (type) {
            case NUM :
                return Integer.parseInt(value);

            case PLUS :
            case MINUS :
            case STAR :
            case SLASH :
            case LEFT_BRACKET :
            case RIGHT_BRACKET :
            case SEMICOLON :
                return type.getSymbol();

            default :
                return value;
        }
    }

    /**
     * Method description
     *
     *
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public byte[] toByteArray() {
        return getValue().toString().getBytes();
    }

    /**
     * Creates and returns a copy of this object.
     *
     * @return a clone of this instance.
     * @throws CloneNotSupportedException if the object's class does not
     *   support the <code>Cloneable</code> interface. Subclasses that
     *   override the <code>clone</code> method can also throw this
     *   exception to indicate that an instance cannot be cloned.
     * @todo Implement this java.lang.Object method
     */
    protected Object clone() throws CloneNotSupportedException {
        Token t = new Token(type, value);

        return t;
    }
}


enum TokenType {
    NUM, DIV, MOD, ID, DONE, PLUS('+'), MINUS('-'), STAR('*'), SLASH('/'), LEFT_BRACKET('('),
    RIGHT_BRACKET(')'), SEMICOLON(';'), NONE;

    TokenType(char c) {
        this.symbol = c;
    }

    TokenType() {
        this.symbol = 0;
    }

    /**
     * Method description
     *
     *
     * @param sym
     *
     * @return
     */
    public static TokenType getTypeBySymbol(char sym) {
        for (TokenType t : values()) {
            if (t.symbol == sym) {
                return t;
            }
        }

        return NONE;
    }

    private char symbol;

    /**
     * Method description
     *
     *
     * @return
     */
    public char getSymbol() {
        return symbol;
    }
}
