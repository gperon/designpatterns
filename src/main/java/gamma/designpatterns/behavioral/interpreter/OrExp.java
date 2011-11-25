/*
 * @(#)OrExp.java   2011-11-01
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



package gamma.designpatterns.behavioral.interpreter;

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
public class OrExp implements BooleanExp {
    private BooleanExp operand1;
    private BooleanExp operand2;

    /**
     * Constructs ...
     *
     *
     * @param operand1
     * @param operand2
     */
    public OrExp(BooleanExp operand1, BooleanExp operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    /**
     * copy
     *
     * @return BooleanExp
     * @todo Implement this designpatterns.behavioral.interpreter.BooleanExp
     *   method
     */
    public BooleanExp copy() {
        return new OrExp(operand1.copy(), operand2.copy());
    }

    /**
     * evaluate
     *
     * @param aContext Context
     * @return boolean
     * @todo Implement this designpatterns.behavioral.interpreter.BooleanExp
     *   method
     */
    public boolean evaluate(Context aContext) {
        return operand1.evaluate(aContext) || operand2.evaluate(aContext);
    }

    /**
     * replace
     *
     * @param aName String
     * @param exp BooleanExp
     * @return BooleanExp
     * @todo Implement this designpatterns.behavioral.interpreter.BooleanExp
     *   method
     */
    public BooleanExp replace(String aName, BooleanExp exp) {
        return new OrExp(operand1.replace(aName, exp), operand2.replace(aName, exp));
    }
}
