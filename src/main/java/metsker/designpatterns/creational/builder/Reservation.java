/*
 * @(#)Reservation.java   2011-11-01
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


package metsker.designpatterns.creational.builder;

/*
 * Copyright (c) 2001, 2005. Steven J. Metsker.
 *
 * Steve Metsker makes no representations or warranties about
 * the fitness of this software for any particular purpose,
 * including the implied warranty of merchantability.
 *
 * Please use this software as you wish with the sole
 * restriction that you may not claim that you wrote it.
 */

import metsker.designpatterns.util.Dollars;

import java.io.Serializable;
import java.util.Date;

/**
 * Objects of this class represent reservations for fireworks displays, but note
 * that this class in not fully developed. The classes in this package show how
 * to use builders to class is just a target for the builders in this package.
 */
public class Reservation implements Serializable {
    private final Date date;
    private final int headcount;
    private final String city;
    private final Dollars dollarsPerHead;
    private final boolean hasSite;

    /**
     * Construct a reservation with the given parameters. The proper way to
     * construct a reservation is with one of the builders in this package, so
     * this method is private.
     *
     * @param date           when to put on a display
     * @param headcount      how many people our customer will guarantee to be in
     *                       attendance
     * @param city           the city (or nearest city) for the display
     * @param dollarsPerHead the price per attendee the customer will pay
     * @param hasSite        true, if the customer has a display site in mind
     */
    Reservation(Date date, int headcount, String city, Dollars dollarsPerHead,
                boolean hasSite) {
        this.date = date;
        this.headcount = headcount;
        this.city = city;
        this.dollarsPerHead = dollarsPerHead;
        this.hasSite = hasSite;
    }

    /**
     * @return a textual description of this reservation.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Date: ");
        sb.append(date.toString());
        sb.append(", Headcount: ");
        sb.append(headcount);
        sb.append(", City: ");
        sb.append(city);
        sb.append(", Dollars/Head: ");
        sb.append(dollarsPerHead);
        sb.append(", Has Site: ");
        sb.append(hasSite);

        return sb.toString();
    }

    /**
     * The scheduled or requested date for the event.
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     * The number of headcount the requester will guarantee.
     *
     * @return
     */
    public int getHeadcount() {
        return headcount;
    }

    /**
     * @return The nearest city.
     */
    public String getCity() {
        return city;
    }

    /**
     * @return The dollars/head the person will pay.
     */
    public Dollars getDollarsPerHead() {
        return dollarsPerHead;
    }

    /**
     * @return True if the requester has a site in mind for the event.
     */
    public boolean hasSite() {
        return hasSite;
    }
}
