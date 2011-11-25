/*
 * @(#)ChemicalFactory2.java   2011-11-01
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
import java.util.*;

/**
 * This class creates and returns Chemical objects. This is a refactoring that
 * ensures that the factory class is the only class that can instantiate the
 * ChemicalImpl class.
 */
public class ChemicalFactory2 {
    private static Map chemicals = new HashMap();

    class ChemicalImpl implements Chemical2 {
        private String name;
        private String symbol;
        private double atomicWeight;

        ChemicalImpl(String name, String symbol, double atomicWeight) {
            this.name = name;
            this.symbol = symbol;
            this.atomicWeight = atomicWeight;
        }

        /**
         * Method description
         *
         *
         * @return
         */
        public String getName() {
            return name;
        }

        /**
         * Method description
         *
         *
         * @return
         */
        public String getSymbol() {
            return symbol;
        }

        /**
         * Method description
         *
         *
         * @return
         */
        public double getAtomicWeight() {
            return atomicWeight;
        }

        /**
         * Method description
         *
         *
         * @return
         */
        public String toString() {
            return name + "(" + symbol + ")[" + atomicWeight + "]";
        }
    }


    static {
        ChemicalFactory2 factory = new ChemicalFactory2();
        chemicals.put("carbon", factory.new ChemicalImpl("Carbon", "C", 12));
        chemicals.put("sulfur", factory.new ChemicalImpl("Sulfur", "S", 32));
        chemicals.put("saltpeter", factory.new ChemicalImpl("Saltpeter", "KN03", 101));
        // ...
    }

    /**
     * @param name the name of the interesting chemical
     * @return the Chemical object for the given name.
     */
    public static Chemical2 getChemical(String name) {
        return (Chemical2) chemicals.get(name.toLowerCase());
    }
}
