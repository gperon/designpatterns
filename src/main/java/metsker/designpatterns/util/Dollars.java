/*
 * @(#)Dollars.java   2011-11-01
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



package metsker.designpatterns.util;

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

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>    
 */
public class Dollars {

    /** Field description */
    public static final Dollars cent = new Dollars(0.01);
    static final int CENTS_PER_DOLLAR = 100;
    long cents;

    /**
     * Constructs ...
     *
     *
     * @param value
     */
    public Dollars(double value) {
        this.cents = Math.round(value * CENTS_PER_DOLLAR);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public boolean isZero() {
        return cents == 0;
    }

    /**
     * Method description
     *
     *
     * @param that
     *
     * @return
     */
    public Dollars plus(Dollars that) {
        return new Dollars(1.0 * (this.cents + that.cents) / CENTS_PER_DOLLAR);
    }

    /**
     * Method description
     *
     *
     * @param multiplier
     *
     * @return
     */
    public Dollars times(int multiplier) {
        return new Dollars((this.cents * multiplier) / CENTS_PER_DOLLAR);
    }

    /**
     * Method description
     *
     *
     * @param divisor
     *
     * @return
     */
    public Dollars dividedBy(int divisor) {
        double newCents = (1.0 * cents / divisor) / CENTS_PER_DOLLAR;

        return new Dollars(newCents);
    }

    /**
     * Method description
     *
     *
     * @param that
     *
     * @return
     */
    public double dividedBy(Dollars that) {
        return (1.0 * this.cents) / that.cents;
    }

    /**
     * Method description
     *
     *
     * @param that
     *
     * @return
     */
    public boolean isLessThan(Dollars that) {
        return this.cents < that.cents;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String toString() {
        StringBuffer result = new StringBuffer("$");
        long dollars = cents / CENTS_PER_DOLLAR;
        result.append(dollars);
        result.append('.');
        long pennies = cents % CENTS_PER_DOLLAR;
        if (pennies < 10) {
            result.append('0');
        }
        result.append(pennies);

        return result.toString();
    }

    /**
     * Method description
     *
     *
     * @param obj
     *
     * @return
     */
    public boolean equals(Object obj) {
        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }
        Dollars that = (Dollars) obj;

        return this.cents == that.cents;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int hashCode() {
        return (int) cents;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public long asCents() {
        return cents;
    }
}
