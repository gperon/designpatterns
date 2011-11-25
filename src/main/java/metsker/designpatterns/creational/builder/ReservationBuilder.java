/*
 * @(#)ReservationBuilder.java   2011-11-01
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
import java.util.*;

import metsker.designpatterns.util.Dollars;

/**
 *  Subclasses of this abstract class validate a reservation's
 *  attributes before constructing a Reservation object.
 */
public abstract class ReservationBuilder {

    /** Field description */
    public static final int MINHEAD = 25;

    /** Field description */
    public static final Dollars MINTOTAL = new Dollars(495.95);
    protected Date date = null;
    protected String city;
    protected int headcount;
    protected Dollars dollarsPerHead = new Dollars(0);
    protected boolean hasSite;

    /**
     *  Push a date into the future by rolling forward the year.
     *  @param inDate a date to push forward
     *  @return a date like the one provided but with a year
     *  that makes the date in the future
     */
    public static Date futurize(Date inDate) {
        Calendar now = Calendar.getInstance();
        Calendar then = Calendar.getInstance();
        then.setTime(inDate);
        while (then.before(now)) {
            then.add(Calendar.YEAR, 1);
        }

        return then.getTime();
    }

    /**
     *  Construct a valid reservation from attributes that have
     *  been presumably been set for this builder. Subclasses may
     *  throw an exception if a valid reservation cannot
     *  be formed.
     * @return a valid reservation
     *
     * @throws BuilderException
     */
    public abstract Reservation build() throws BuilderException;

    /**
     *  The city for a reservation
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     * Method description
     *
     *
     * @param value
     */
    public void setCity(String value) {
        city = value;
    }

    /**
     *  The date for a reservation.
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     * Method description
     *
     *
     * @param value
     */
    public void setDate(Date value) {
        date = value;
    }

    /**
     *  The dollars/head that a customer will pay for a display.
     *
     * @return
     */
    public Dollars getDollarsPerHead() {
        return dollarsPerHead;
    }

    /**
     * Method description
     *
     *
     * @param value
     */
    public void setDollarsPerHead(Dollars value) {
        dollarsPerHead = value;
    }

    /**
     *  Indicates whether a customer has a site in mind for a
     *  display.
     *
     * @return
     */
    public boolean hasSite() {
        return hasSite;
    }

    /**
     * Method description
     *
     *
     * @param value
     */
    public void setHasSite(boolean value) {
        hasSite = value;
    }

    /**
     *  The number of people that a customer will guarantee for
     *  a display.
     *
     * @return
     */
    public int getHeadcount() {
        return headcount;
    }

    /**
     * Method description
     *
     *
     * @param value
     */
    public void setHeadcount(int value) {
        headcount = value;
    }
}
