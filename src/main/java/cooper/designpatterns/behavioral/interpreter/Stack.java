/*
 * @(#)Stack.java   2011-11-01
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

import java.util.ArrayList;
import java.util.List;

/**
 * Class description
 *
 * @author <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 * @version 0.1.1, 2011-11-01
 */
public class Stack {
    List<ParseObject> stk;

    public Stack() {
        stk = new ArrayList<>();
    }

    public void dump() {
        for (int i = 0; i < stk.size(); i++) {
            ParseObject p = stk.get(i);
        }
    }

    public void dump(String s) {
        System.out.println(s);
        dump();
    }

    public ParseObject nextTop() {
        int i = stk.size();
        if (i > 1) {
            return stk.get(i - 2);
        } else {
            return null;
        }
    }

    public ParseObject pop() {
        int i = stk.size() - 1;
        ParseObject obj = stk.get(i);
        stk.remove(i);

        return obj;
    }

    public void pop2Push(ParseObject p) {
        int i = stk.size();
        if (i >= 2) {
            pop();
            pop();
            push(p);
        } else {
            push(p);
        }
    }

    public void push(ParseObject obj) {
        stk.add(obj);
    }

    public ParseObject top() {
        return stk.get(stk.size() - 1);
    }

    public boolean hasMoreElements() {
        return !stk.isEmpty();
    }
}
