/*
 * @(#)HumanCodeGenerator.java   2011-11-01
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

import java.io.IOException;

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
public class HumanCodeGenerator extends CodeGenerator {
    protected HumanCodeGenerator(BytecodeStream bs) {
        super(bs);
    }

    /**
     * visit
     *
     * @param en ExpressionNode
     * @todo Implement this designpatterns.structural.facade.CodeGenerator
     * method
     */
    public void visit(ExpressionNode en) {
        Token t = en.getToken();
        if (t != null) {
            try {
                output.write(t.toByteArray());
                output.write('(');
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * visit
     *
     * @param fn FactorNode
     * @todo Implement this designpatterns.structural.facade.CodeGenerator
     * method
     */
    public void visit(FactorNode fn) {
        try {
            Token t = fn.getToken();
            if (t != null) {
                output.write(t.toByteArray());
            }
            // output.write( (char) '(');
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * visit
     *
     * @param loen ListOfExpressionNode
     * @todo Implement this designpatterns.structural.facade.CodeGenerator
     * method
     */
    public void visit(ListOfExpressionNode loen) {
        try {
            output.write(new byte[]{';', '\n'});
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * visit
     *
     * @param sn StatementNode
     * @todo Implement this designpatterns.structural.facade.CodeGenerator
     * method
     */
    public void visit(StatementNode sn) {
        // throw new NoSuchMethodException("Method visit(StatementNode sn) not implemented");
    }

    /**
     * visit
     *
     * @param tn TermNode
     * @todo Implement this designpatterns.structural.facade.CodeGenerator
     * method
     */
    public void visit(TermNode tn) {
        Token t = tn.getToken();
        if (t != null) {
            try {
                output.write(t.toByteArray());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * visit
     *
     * @param vn
     * @todo Implement this designpatterns.structural.facade.CodeGenerator
     * method
     */
    public void visit(VariableNode vn) {
        Token t = vn.getToken();
        if (t != null) {
            try {
                output.write(t.toByteArray());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
