/*
 * @(#)ParseVerb.java   2011-11-01
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
public class ParseVerb extends ParseObject {

    /**
     * Field description
     */
    public static final int PRINT = 100;
    public static final int SORTBY = 110;
    public static final int THENBY = 120;
    protected List<ParseObject> args;

    public ParseVerb(String s) {
        args = new ArrayList<>();
        s = s.toLowerCase();
        value = -1;
        type = VERB;
        if (s.equals("print")) {
            value = PRINT;
        }
        if (s.equals("sortby")) {
            value = SORTBY;
        }
    }

    public void addArgs(MultVar mv) {
        args = mv.getVector();
    }

    public void addArgs(ParseObject p) {
        args.add(p);
    }

    public boolean isLegal() {
        return (value >= 0);
    }

    public ParseVerb getVerb(String s) {
        switch (value) {
            case PRINT :
                return new Print(s);

            case SORTBY :
                return new Sort(s);

            default :
                return null;
        }
    }
}
