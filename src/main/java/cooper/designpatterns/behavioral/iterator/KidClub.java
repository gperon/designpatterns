/*
 * @(#)KidClub.java   2011-11-01
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



package cooper.designpatterns.behavioral.iterator;

import java.util.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class KidClub implements Enumeration {
    String clubMask;    // name of club
    Kid kid;            // next kid to return
    Enumeration ke;     // gets all kids
    KidData kdata;      // class containing kids

    /**
     * Constructs ...
     *
     *
     * @param kd
     * @param club
     */
    public KidClub(KidData kd, String club) {
        clubMask = club;          // save the club
        kdata = kd;               // copy the class
        kid = null;               // default
        ke = kdata.elements();    // get Enumerator
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public boolean hasMoreElements() {
        // return true if there are any more kids
        // belonging to the specified club
        boolean found = false;
        while (ke.hasMoreElements() && !found) {
            kid = (Kid) ke.nextElement();
            found = kid.getClub().equals(clubMask);
        }
        if (!found) {
            kid = null;    // set to null if none left
        }

        return found;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Object nextElement() {
        if (kid != null) {
            return kid;
        } else {
            // throw exception if access past end
            throw new NoSuchElementException();
        }
    }
}
