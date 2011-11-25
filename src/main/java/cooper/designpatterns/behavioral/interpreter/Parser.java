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



package cooper.designpatterns.behavioral.interpreter;

import cooper.designpatterns.behavioral.command.Command;

import java.util.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class Parser implements Command {
    Stack stk;
    Vector actionList;
    KidData kdata;
    Data data;
    // PrintTable ptable;
    JawtList ptable;

    /**
     * Constructs ...
     *
     *
     * @param line
     */
    public Parser(String line) {
        stk = new Stack();
        actionList = new Vector();
        StringTokenizer tok = new StringTokenizer(line);
        while (tok.hasMoreElements()) {
            ParseObject token = tokenize(tok.nextToken());
            if (token != null) {
                stk.push(token);
            }
        }
    }

    /**
     * Method description
     *
     *
     * @param k
     * @param pt
     */
    public void setData(KidData k, JawtList pt) {
        data = new Data(k.getData());
        ptable = pt;
    }

    /**
     * Executes parse of command line.
     */
    public void execute() {
        while (stk.hasMoreElements()) {
            if (topStack(ParseObject.VAR, ParseObject.VAR)) {

                /* reduce (Var Var) to Multvar */
                ParseVar v = (ParseVar) stk.pop();
                ParseVar v1 = (ParseVar) stk.pop();
                MultVar mv = new MultVar(v1, v);
                stk.push(mv);
            }

            /* reduce MULTVAR VAR to MULTVAR */
            if (topStack(ParseObject.MULTVAR, ParseObject.VAR)) {
                MultVar mv = new MultVar();
                MultVar mvo = (MultVar) stk.pop();
                ParseVar v = (ParseVar) stk.pop();
                mv.add(v);
                Vector mvec = mvo.getVector();
                for (int i = 0; i < mvec.size(); i++) {
                    mv.add((ParseVar) mvec.elementAt(i));
                }
                stk.push(mv);
            }
            if (topStack(ParseObject.VAR, ParseObject.MULTVAR)) {

                /* reduce (Multvar Var) to Multvar */
                ParseVar v = (ParseVar) stk.pop();
                MultVar mv = (MultVar) stk.pop();
                mv.add(v);
                stk.push(mv);
            }

            /* reduce Verb Var to Verb containing vars */
            if (topStack(ParseObject.VAR, ParseObject.VERB)) {
                addArgsToVerb();
            }

            /* reduce Verb MultVar to Verb containing vars */
            if (topStack(ParseObject.MULTVAR, ParseObject.VERB)) {
                addArgsToVerb();
            }

            /* move top verb to action list */
            if (stk.top().getType() == ParseObject.VERB) {
                actionList.addElement(stk.pop());
            }
        }

        /* now execute the verbs */
        for (int i = 0; i < actionList.size(); i++) {
            Verb v = (Verb) actionList.elementAt(i);
            v.setData(data, ptable);
            v.execute();
        }
    }

    private void addArgsToVerb() {
        ParseObject v = stk.pop();
        ParseVerb verb = (ParseVerb) stk.pop();
        verb.addArgs(v);
        stk.push(verb);
    }

    private boolean topStack(int c1, int c2) {
        return (stk.top().getType() == c1) && (stk.nextTop().getType() == c2);
    }

    private ParseObject tokenize(String s) {
        ParseObject obj = getVerb(s);
        if (obj == null) {
            obj = getVar(s);
        }

        return obj;
    }

    private ParseVerb getVerb(String s) {
        ParseVerb v;
        v = new ParseVerb(s);
        if (v.isLegal()) {
            return v.getVerb(s);
        } else {
            return null;
        }
    }

    private ParseVar getVar(String s) {
        ParseVar v;
        v = new ParseVar(s);
        if (v.isLegal()) {
            return v;
        } else {
            return null;
        }
    }
}
