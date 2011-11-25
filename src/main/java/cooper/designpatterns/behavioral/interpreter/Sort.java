/*
 * @(#)Sort.java   2011-11-01
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

import java.util.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class Sort extends Verb {
    Kid[] kids;
    int pindex;

    /**
     * Constructs ...
     *
     *
     * @param s
     */
    public Sort(String s) {
        super(s);
        value = SORTBY;
    }

    /**
     * Method description
     *
     */
    public void execute() {
        int sortKey;
        kids = data.getData();
        for (int a = 0; a < args.size(); a++) {
            ParseVar v = (ParseVar) args.elementAt(a);
            if (v instanceof MultVar) {
                MultVar mv = (MultVar) v;
                Vector mvec = mv.getVector();
                for (int k = mvec.size() - 1; k >= 0; k--) {
                    ParseVar pv = (ParseVar) mvec.elementAt(k);
                    sortKey = pv.getValue();
                    sortByKey(sortKey);
                }
            } else {
                sortKey = v.getValue();
                sortByKey(sortKey);
            }
        }
    }

    private void sortByKey(int sortkey) {
        System.out.println(sortkey);
        for (int i = 0; i < kids.length; i++) {
            for (int j = i + 1; j < kids.length; j++) {
                if (compare(i, j, sortkey)) {
                    Kid tmp = kids[i];
                    kids[i] = kids[j];
                    kids[j] = tmp;
                }
            }
        }
    }

    private boolean compare(int i, int j, int key) {
        boolean cval;
        switch (key) {
            case ParseVar.FRNAME :
                cval = kids[i].getFrname().compareTo(kids[j].getFrname()) > 0;

                break;

            case ParseVar.LNAME :
                cval = kids[i].getLname().compareTo(kids[j].getLname()) > 0;

                break;

            case ParseVar.CLUB :
                cval = kids[i].getClub().compareTo(kids[j].getClub()) > 0;

                break;

            case ParseVar.AGE :
                cval = kids[i].getAge() > kids[j].getAge();

                break;

            case ParseVar.TIME :
                cval = kids[i].getTime() > kids[j].getTime();

                break;

            default :
                cval = false;
        }

        return cval;
    }
}
