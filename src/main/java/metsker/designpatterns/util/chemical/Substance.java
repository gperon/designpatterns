/*
 * @(#)Substance.java   2011-11-01
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
 * This class represents a batch of chemicals.
 */
public class Substance {
    private final String name;
    private final String symbol;
    private final double atomicWeight;
    private final double grams;

    /**
     * Model a batch of stuff.
     *
     * @param name         The name of this substance, such as "Saltpeter."
     * @param symbol       The chemical symbol for this substance, such as "KNO3."
     * @param atomicWeight The atomic weight of this substance (101 for saltpeter).
     * @param grams        The mass of this batch of substance.
     */
    public Substance(String name, String symbol, double atomicWeight,
                     double grams) {
        this.name = name;
        this.symbol = symbol;
        this.atomicWeight = atomicWeight;
        this.grams = grams;
    }

    /**
     * @return The name of this substance, such as "Saltpeter."
     */
    public String getName() {
        return name;
    }

    /**
     * @return The chemical symbol for this substance, such as "KNO3."
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @return The atomic weight of this substance (e.g. 101 for saltpeter).
     */
    public double getAtomicWeight() {
        return atomicWeight;
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
        return grams / atomicWeight;
    }
}
