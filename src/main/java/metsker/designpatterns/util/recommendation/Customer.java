/*
 * @(#)Customer.java   2011-11-01
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



package metsker.designpatterns.util.recommendation;

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
import java.lang.String;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import metsker.designpatterns.util.firework.Firework;

/**
 * Represents a customer.
 */
public class Customer {

    /** Field description */
    public static final int BIG_SPENDER_DOLLARS = 1000;

    /**
     * @return true if this customer has registered (or entered) his or her
     *         preference profile. This method is not actually implemented
     */
    public boolean isRegistered() {
        return false;
    }

    /**
     * This method demonstrates that the class can actually find the properties
     * file that lists a strategic promotion. If you set your classpath to
     * include the "oozinoz" directory that you can download from oozinoz.com,
     * this program will find the strategy.dat file that lists a promoted
     * firework. In short it's an example of finding and reading from a
     * properties file.
     *
     * @param args
     */
    public static void main(String[] args) {
        Firework recommendation = new Customer().getRecommended();
        System.out.println("Customer recommendation: " + recommendation.toString());
    }

    /**
     * @return a firework to recommend to this customer.
     */
    public Firework getRecommended() {
        // if we're promoting a particular firework, return it
        try {
            Properties p = new Properties();
            p.load(ClassLoader.getSystemResourceAsStream("config/strategy.dat"));
            String promotedName = p.getProperty("promote");
            if (promotedName != null) {
                Firework f = Firework.lookup(promotedName);
                if (f != null) {
                    return f;
                }
            }
        } catch (Exception ignored) {
            // If resource missing or it failed to load,
            // fall through to the next approach.
        }
        // if registered, compare to other customers
        if (isRegistered()) {
            return (Firework) Rel8.advise(this);
        }
        // check spending over the last year
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -1);
        if (spendingSince(cal.getTime()) > 1000) {
            return (Firework) LikeMyStuff.suggest(this);
        }

        // oh well!
        return Firework.getRandom();
    }

    /**
     * @return the amount of dough this customer has spent with us since the
     *         provided date.
     * @param date Since when?
     */
    public double spendingSince(Date date) {
        return 1000;
    }

    private boolean isBigSpender() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -1);

        return (spendingSince(cal.getTime()) > BIG_SPENDER_DOLLARS);
    }
}
