/*
 * @(#)Kid.java   2011-11-01
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
public class Kid {
    String frname, lname, club;
    int age;
    float time;

    /**
     * Constructs ...
     *
     *
     * @param line
     */
    public Kid(String line) {
        StringTokenizer tok = new StringTokenizer(line);
        String lnum = tok.nextToken();
        frname = tok.nextToken();
        lname = tok.nextToken();
        age = new Integer(tok.nextToken()).intValue();
        club = tok.nextToken();
        time = new Float(tok.nextToken()).floatValue();
    }

    /**
     * Method description
     *
     *
     * @param key
     *
     * @return
     */
    public Object getData(int key) {
        switch (key) {
            case ParseVar.FRNAME :
                return frname;

            case ParseVar.LNAME :
                return lname;

            case ParseVar.CLUB :
                return club;

            case ParseVar.AGE :
                return new Integer(age);

            case ParseVar.TIME :
                return new Float(time);
        }

        return null;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public float getTime() {
        return time;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getFrname() {
        return frname;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getLname() {
        return lname;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getClub() {
        return club;
    }
}
