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



package gamma.designpatterns.behavioral.strategy;

import java.io.*;

import java.util.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class Customer {
    private Advisor advisor;

    /** Field description */
    public static final int BIG_SPENDER_DOLLARS = 1000;

    /**
     * Return true if this customer has registered (or entered)
     * his or her preference profile.
     *
     * @return true if this customer has registered (or entered)
     *         his or her preference profile. This method is not
     *         actually implemented.
     */
    public boolean isRegistered() {
        return false;
    }

    /**
     * Return the amount of dough this customer has spent with
     * us since the provided date.
     *
     *
     * @param date
     * @return the amount of dough this customer has spent with
     *         us since the provided date; not actually implemented.
     */
    public double spendingSince(Date date) {
        return 1000;
    }

    private Advisor getAdvisor() {
        if (advisor == null) {
            if (PromotionAdvisor.singleton.hasItem()) {
                advisor = PromotionAdvisor.singleton;
            } else if (isRegistered()) {
                advisor = GroupAdvisor.singleton;
            } else if (isBigSpender()) {
                advisor = ItemAdvisor.singleton;
            } else {
                advisor = RandomAdvisor.singleton;
            }
        }

        return advisor;
    }

    /**
     * Return a firework to recommend to this customer.
     *
     * @return a firework to recommend to this customer
     *
     * @throws IOException
     */
    public Firework getRecommended() throws IOException {
        // see if we're promoting a particular firework
        Properties p = new Properties();
        p.load(ClassLoader.getSystemResourceAsStream(
            "designpatterns/behavioral/strategy/strategy.dat"));
        String promotedFireworkName = p.getProperty("promote");
        if (promotedFireworkName != null) {
            Firework f = Firework.lookup(promotedFireworkName);
            if (f != null) {
                return f;
            }
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
     * Return a firework to recommend to this customer.
     *
     * @return a firework to recommend to this customer. This
     *         method is refactored to employ the Strategy
     *         pattern.
     */
    public Firework getRecommended_2() {
        return getAdvisor().recommend(this);
    }

    private boolean isBigSpender() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -1);

        return spendingSince(cal.getTime()) > BIG_SPENDER_DOLLARS;
    }

    /**
     * I just used this to ensure I was actually finding
     * the properties file that lists a strategic promotion.
     * If you set your classpath to include the "oozinoz"
     * directory that you can download from oozinoz.com, this
     * program will find the strategy.dat file that lists a
     * promoted firework. In short it's an example of finding
     * and reading from a properties file.
     *
     * @param args
     *
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        new Customer().getRecommended();
    }
}
