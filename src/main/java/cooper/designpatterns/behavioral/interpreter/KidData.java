/*
 * @(#)KidData.java   2011-11-01
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

import cooper.designpatterns.util.swing.InputFile;
import java.util.ArrayList;
import java.util.List;


/**
 * Class description
 *
 * @author <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 * @version 0.1.1, 2011-11-01
 */
public class KidData {
    List<Kid> kids;

    /**
     * Constructs ...
     *
     * @param filename
     */
    public KidData(String filename) {
        kids = new ArrayList<>();

        InputFile f = new InputFile(getClass(), filename);
        String s = f.readLine();

        while (s != null) {
            if (s.trim().length() > 0) {
                Kid k = new Kid(s);

                kids.add(k);
            }

            s = f.readLine();
        }
    }

    public int size() {
        return kids.size();
    }

    public Kid[] getData() {
        Kid[] kd = new Kid[kids.size()];

        for (int i = 0; i < kids.size(); i++) {
            kd[i] = kids.get(i);
        }

        return kd;
    }

    public Kid getKid(int i) {
        return kids.get(i);
    }

    public List<Object> getKidData(int key) {
        List<Object> v = new ArrayList<>();

        for (int i = 0; i < kids.size(); i++) {
            v.add(getKid(i).getData(key));
        }

        return v;
    }

    public int getTableKey(String tabName) {
        int key = -1;

        tabName = tabName.toLowerCase();

        if (tabName.equals("frname")) {
            key = ParseVar.FRNAME;
        }

        if (tabName.equals("lname")) {
            key = ParseVar.LNAME;
        }

        if (tabName.equals("age")) {
            key = ParseVar.AGE;
        }

        if (tabName.equals("club")) {
            key = ParseVar.CLUB;
        }

        if (tabName.equals("time")) {
            key = ParseVar.TIME;
        }

        return key;
    }

    public String getTableName(int i) {
        String name = "";

        switch (i) {
            case ParseVar.FRNAME:
                name = "frname";
				break;
            case ParseVar.LNAME:
                name = "lname";
				break;
            case ParseVar.AGE:
                name = "age";
				break;
            case ParseVar.CLUB:
                name = "club";
				break;
            case ParseVar.TIME:
                name = "time";
				break;
			default:
				name = "";
        }

        return name;
    }
}
