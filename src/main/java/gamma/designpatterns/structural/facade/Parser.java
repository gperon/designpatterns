/*
 * @(#)Parser.java   2011-11-01
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
 * Parser calls back on ProgramNodeBuilder to build the parse tree incrementally.
 * These classes interact according to the Builder pattern.
 *
 * @author giorgio_peron@libero.it
 * @version 1.0
 */
public class Parser {
    private Token lookahead;
    private ProgramNodeBuilder builder;
    private Scanner scanner;
    private final static boolean DEBUG = false;

    /**
     * Constructs ...
     *
     *
     * @param s
     * @param pnb
     */
    public Parser(Scanner s, ProgramNodeBuilder pnb) {
        this.builder = pnb;
        this.scanner = s;
    }

    void parse() throws Exception {
        ProgramNode listExpr = builder.getRootNode();
        lookahead = scanner.scan();
        while (lookahead.getType() != TokenType.DONE) {
            ProgramNode expr = builder.newExpression();
            expr(expr);
            listExpr.add(expr);
            match(TokenType.SEMICOLON);
        }
    }

    private void expr(ProgramNode pn) throws Exception {
        ProgramNode term = builder.newTerm();
        term(term);
        pn.add(term);
        while (true) {
            switch (lookahead.getType()) {
                case PLUS :
                case MINUS :
                    emit(lookahead);
                    term = builder.newTerm((Token) lookahead.clone());
                    match(lookahead.getType());
                    term(term);
                    pn.add(term);

                    break;

                default :
                    return;
            }
        }
    }

    private void term(ProgramNode pn) throws Exception {
        ProgramNode factor = builder.newFactor();
        factor(factor);
        pn.add(factor);
        while (true) {
            switch (lookahead.getType()) {
                case STAR :
                case SLASH :
                case DIV :
                case MOD :
                    emit(lookahead);
                    factor = builder.newFactor((Token) lookahead.clone());
                    match(lookahead.getType());
                    factor(factor);
                    pn.add(factor);

                    break;

                default :
                    return;
            }
        }
    }

    private void factor(ProgramNode pn) throws Exception {
        switch (lookahead.getType()) {
            case LEFT_BRACKET :
                match(TokenType.LEFT_BRACKET);
                ProgramNode expr = builder.newExpression();
                expr(expr);
                pn.add(expr);
                match(TokenType.RIGHT_BRACKET);

                break;

            case NUM :
                emit(lookahead);
                pn.add(builder.newVariable((Token) lookahead.clone()));
                match(TokenType.NUM);

                break;

            case ID :
                emit(lookahead);
                pn.add(builder.newVariable((Token) lookahead.clone()));
                match(TokenType.ID);

                break;

            default :
                throw new Exception("syntax error");
        }
    }

    private void match(TokenType tt) throws Exception {
        if (lookahead.getType() == tt) {
            lookahead = scanner.scan();
        } else {
            throw new Exception("syntax error");
        }
    }

    private void emit(Token t) {
        if (DEBUG) {
            switch (t.getType()) {
                case PLUS :
                case MINUS :
                case STAR :
                case SLASH :
                    System.out.printf("%c\n", t.getValue());

                    break;

                case DIV :
                    System.out.println("DIV");

                    break;

                case MOD :
                    System.out.println("MOD");

                    break;

                case NUM :
                    System.out.printf("%d\n", t.getValue());

                    break;

                case ID :
                    System.out.printf("%s\n", t.getValue());

                    break;

                default :
                    System.out.printf("token %d, value %d\n", t.getType(), t.getValue());

                    break;
            }
        }
    }
}
