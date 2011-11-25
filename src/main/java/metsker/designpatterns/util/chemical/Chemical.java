/*
 * @(#)Chemical.java   2011-11-01
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
 * This class represents a type of chemical.
 */
public class Chemical {
    private String name;
    private String symbol;
    private double atomicWeight;

    /**
     * Model a chemical such as saltpeter.
     *
     * @param name
     *            The name of this chemical, such as "Saltpeter."
     * @param symbol
     *            The chemical symbol for this substance, such as "KNO3."
     * @param atomicWeight
     *            The atomic weight of this substance (101 for saltpeter).
     */
    Chemical(String name, String symbol, double atomicWeight) {
        this.name = name;
        this.symbol = symbol;
        this.atomicWeight = atomicWeight;
    }

    /**
     * @return The name of this chemical, such as "Saltpeter."
     */
    public String getName() {
        return name;
    }

    /**
     * @return The symbol for this chemical, such as "KNO3."
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @return The atomic weight of this chemical (e.g. 101 for saltpeter).
     */
    public double getAtomicWeight() {
        return atomicWeight;
    }

    /**
     * @return Textual description of this chemical.
     */
    public String toString() {
        return name + "(" + symbol + ")[" + atomicWeight + "]";
    }
}
