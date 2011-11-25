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



package cooper.designpatterns.behavioral.mediator;

import java.util.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class KidData {
    Vector kids;

    /**
     * Constructs ...
     *
     *
     * @param filename
     */
    public KidData(String filename) {
        kids = new Vector();
        InputFile f = new InputFile(filename);
        String s = f.readLine();
        while (s != null) {
            if (s.trim().length() > 0) {
                Kid k = new Kid(s);
                kids.addElement(k);
            }
            s = f.readLine();
        }
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Kid[] getData() {
        Kid[] kd = new Kid[kids.size()];
        for (int i = 0; i < kids.size(); i++) {
            kd[i] = (Kid) kids.elementAt(i);
        }

        return kd;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Enumeration elements() {
        return kids.elements();
    }

    /**
     * Method description
     *
     *
     * @param club
     *
     * @return
     */
    public Enumeration kidsInClub(String club) {
        return new KidClub(this, club);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int size() {
        return kids.size();
    }

    /**
     * Method description
     *
     *
     * @param i
     *
     * @return
     */
    public Kid getKid(int i) {
        return (Kid) kids.elementAt(i);
    }

    /**
     * Method description
     *
     *
     * @param key
     *
     * @return
     */
    public Vector getKidData(int key) {
        Vector v = new Vector();
        for (int i = 0; i < kids.size(); i++) {
            v.addElement(getKid(i).getData(key));
        }

        return v;
    }

    /**
     * Method description
     *
     *
     * @param tabName
     *
     * @return
     */
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

    /**
     * Method description
     *
     *
     * @param i
     *
     * @return
     */
    public String getTableName(int i) {
        String name = "";
        switch (i) {
            case ParseVar.FRNAME :
                name = "frname";
            case ParseVar.LNAME :
                name = "lname";
            case ParseVar.AGE :
                name = "age";
            case ParseVar.CLUB :
                name = "club";
            case ParseVar.TIME :
                name = "time";
        }

        return name;
    }
}
