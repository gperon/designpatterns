/*
 * @(#)ForgivingBuilder.java   2011-11-01
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

/**
 *  This class builds a valid reservation from its attributes,
 *  and fills in values where it can if the attributes are not
 *  set. This builder must receive a city and a date, but it
 *  will set reasonable values for the other reservation values.
 */
public class ForgivingBuilder extends ReservationBuilder {

    /**
     * Method description
     *
     *
     * @return
     *
     * @throws BuilderException
     */
    public Reservation build() throws BuilderException {
        boolean noHeadcount = (headcount == 0);
        boolean noDollarsPerHead = (dollarsPerHead.isZero());
        if (noHeadcount && noDollarsPerHead) {
            headcount = MINHEAD;
            dollarsPerHead = sufficientDollars(headcount);
        } else if (noHeadcount) {
            headcount = (int) Math.ceil(MINTOTAL.dividedBy(dollarsPerHead));
            headcount = Math.max(headcount, MINHEAD);
        } else if (noDollarsPerHead) {
            dollarsPerHead = sufficientDollars(headcount);
        }
        check();

        return new Reservation(date, headcount, city, dollarsPerHead, hasSite);
    }

    private Dollars sufficientDollars(int headcount) {
        Dollars dollars = MINTOTAL.dividedBy(headcount);
        if (dollars.times(headcount).isLessThan(MINTOTAL)) {
            dollars = dollars.plus(Dollars.cent);
        }

        return dollars;
    }

    protected void check() throws BuilderException {
        if (date == null) {
            throw new BuilderException("Valid date not found");
        }
        if (city == null) {
            throw new BuilderException("Valid city not found");
        }
        if (headcount < MINHEAD) {
            throw new BuilderException("Minimum headcount is " + MINHEAD);
        }
        if (dollarsPerHead.times(headcount).isLessThan(MINTOTAL)) {
            throw new BuilderException("Minimum total cost is " + MINTOTAL);
        }
    }
}
