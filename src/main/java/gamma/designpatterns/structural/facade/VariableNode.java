/*
 * @(#)VariableNode.java   2011-11-01
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
public class VariableNode implements ProgramNode {
    protected Token token;

    /**
     * Constructs ...
     *
     * @param t
     */
    public VariableNode(Token t) {
        this.token = t;
    }

    /**
     * add
     *
     * @param pn ProgramNode
     * @todo Implement this designpatterns.structural.facade.ProgramNode
     * method
     */
    public void add(ProgramNode pn) {
    }

    /**
     * getSourcePosition
     *
     * @param line  int
     * @param index int
     * @todo Implement this designpatterns.structural.facade.ProgramNode
     * method
     */
    public void getSourcePosition(int line, int index) {
    }

    /**
     * remove
     *
     * @param pn ProgramNode
     * @todo Implement this designpatterns.structural.facade.ProgramNode
     * method
     */
    public void remove(ProgramNode pn) {
    }

    /**
     * traverse
     *
     * @param cg CodeGenerator
     * @todo Implement this designpatterns.structural.facade.ProgramNode
     * method
     */
    public void traverse(CodeGenerator cg) {
        cg.visit(this);
    }

    /**
     * Method description
     *
     * @return
     */
    public Token getToken() {
        return token;
    }
}
