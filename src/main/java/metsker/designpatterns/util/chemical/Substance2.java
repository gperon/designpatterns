/*
 * @(#)Substance2.java   2011-11-01
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



package metsker.designpatterns.util.chemical;

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
 * This class represents a batch of chemical.
 */
public class Substance2 {
    private double grams;
    private Chemical2 chemical;

    /**
     * Model a batch of stuff, revised from the original Substance class to rely
     * on an (immutable) Chemical class.
     *
     * @param grams
     *            The mass of this batch of substance.
     * @param chemical
     *            This batch's chemical composition
     */
    public Substance2(double grams, Chemical2 chemical) {
        this.grams = grams;
        this.chemical = chemical;
    }

    /**
     * @return The name of this substance, such as "Saltpeter."
     */
    public String getName() {
        return chemical.getName();
    }

    /**
     * @return The chemical symbol for this substance, such as "KNO3."
     */
    public String getSymbol() {
        return chemical.getSymbol();
    }

    /**
     * @return The atomic weight of this substance (e.g. 101 for saltpeter).
     */
    public double getAtomicWeight() {
        return chemical.getAtomicWeight();
    }

    /**
     * @return The mass of this batch of substance.
     */
    public double getGrams() {
        return grams;
    }

    /**
     * @return The number of moles in this batch.
     */
    public double getMoles() {
        return grams / getAtomicWeight();
    }
}
