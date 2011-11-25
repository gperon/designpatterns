/*
 * @(#)Customer2.java   2011-11-01
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

import metsker.designpatterns.util.firework.Firework;

/**
 * Represents a customer. This class is the refactored strategy class. It
 * extends Customer only so it can be passed in to Rel8 and LikeMyStuff. In
 * reality, you would replace the Customer class with this one.
 */
public class Customer2 extends Customer {
    private Advisor advisor;
    private static PromotionAdvisor promotionAdvisor = new PromotionAdvisor();
    private static GroupAdvisor groupAdvisor = new GroupAdvisor();
    private static ItemAdvisor itemAdvisor = new ItemAdvisor();
    private static RandomAdvisor randomAdvisor = new RandomAdvisor();

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
     * This method demonstrates that the object actually finds the properties
     * file that lists a strategic promotion. If you set your classpath to
     * include the "oozinoz" directory that you can download from oozinoz.com,
     * this program will find the strategy.dat file that lists a promoted
     * firework. In short it's an example of finding and reading from a
     * properties file.
     *
     * @param args
     */
    public static void main(String[] args) {
        Firework recommendation = new Customer2().getRecommended();
        System.out.println("Customer2 recommendation: " + recommendation.toString());
    }

    /**
     * @return a firework to recommend to this customer. This method is
     *         refactored to employ the Strategy pattern.
     */
    public Firework getRecommended() {
        Firework recommend = getAdvisor().recommend(this);

        return recommend;
    }

    private Advisor getAdvisor() {
        if (advisor == null) {
            if (promotionAdvisor.hasItem()) {
                advisor = promotionAdvisor;
            } else if (isRegistered()) {
                advisor = groupAdvisor;
            } else if (isBigSpender()) {
                advisor = itemAdvisor;
            } else {
                advisor = randomAdvisor;
            }
        }

        return advisor;
    }

    /**
     * @return the amount of money this customer has spent with us since the
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
