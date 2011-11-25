/*
 * @(#)Ballistics.java   2011-11-01
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



package metsker.designpatterns.behavioral.observer;

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
 * This utility class provides standard equations for burn rate and thrust.
 *
 * @author Steven J. Metsker
 *
 * @version 1.0
 */
public class Ballistics {
    private static BallisticsFunction rate;
    private static BallisticsFunction thrust;

    /**
     * @return a standard function that models the burn rate of a rocket's fuel
     *         as function of burn time and the peak time when the burn area
     *         reaches its maximum
     */
    public static BallisticsFunction rate() {
        if (rate == null) {
            rate = new BallisticsFunction() {
                public double function(double t, double tPeak) {
                    return .5 * Math.pow(25, -Math.pow((t - tPeak), 2));
                }
            };
        }

        return rate;
    }

    /**
     * @return a standard function that models the thrust of a rocket engine as
     *         a function of burn time and the peak time when the burn area
     *         reaches its maximum
     */
    public static BallisticsFunction thrust() {
        if (thrust == null) {
            thrust = new BallisticsFunction() {
                public double function(double t, double tPeak) {
                    return 1.7 * Math.pow((rate().function(t, tPeak) / .6), (1 / .3));
                }
            };
        }

        return thrust;
    }
}
