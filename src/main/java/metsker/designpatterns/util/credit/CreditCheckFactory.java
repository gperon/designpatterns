/*
 * @(#)CreditCheckFactory.java   2011-11-01
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



package metsker.designpatterns.util.credit;

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
 * This factory produces objects that can check credit.
 */
public abstract class CreditCheckFactory {

    /**
     * @return a CreditCheck object; the actual class of the object depends on
     *         whether the credit agency is up.
     */
    public static CreditCheck createCreditCheck() {
        if (isAgencyUp()) {
            return new CreditCheckOnline();
        }

        return new CreditCheckOffline();
    }

    /**
     * @return true if the service bureau is accessible. This method is not yet
     *         actually implemented.
     */
    public static boolean isAgencyUp() {
        return true;
    }

    /**
     * @return a BillingCheck object; the actual class of the object depends
     *         on subclasses.
     */
    public abstract BillingCheck createBillingCheck();

    /**
     * @return a CreditCheck object; the actual class of the object depends on
     *         subclasses.
     */
    public abstract CreditCheck createCreditCheck2();

    /**
     * @return a ShippingCheck object; the actual class of the object depends
     *         on subclasses.
     */
    public abstract ShippingCheck createShippingCheck();
}
