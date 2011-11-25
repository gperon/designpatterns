/*
 * @(#)Firework.java   2011-11-01
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

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class Firework {
    protected String name;
    protected Classification classification;

    /**
     * Returns this firework's classification.
     *
     * @return this firework's classification
     */
    public Classification getClassification() {
        return classification;
    }

    /**
     * Set this firework's classification.
     *
     * @param classification this firework's classification
     */
    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    protected double price;

    /**
     * Construct a firework with the given name.
     *
     * @param name the name of the firework
     * @param price the price of the firework
     */
    public Firework(String name, double price) {
        this(name, price, Classification.DISPLAY);
    }

    /**
     * Construct a firework with the given name and classification.
     *
     * @param name the name of the firework
     * @param price the price of the firework
     * @param classification the classification of the firework
     */
    public Firework(String name, double price, Classification classification) {
        this.name = name;
        this.price = price;
        this.classification = classification;
    }

    /**
     * This method exists mainly to show what can happen when a subclass shadows
     * a static method. See "Introducing Operations" in "The Design Patterns
     * Java Workbook."
     *
     * @return boolean
     */
    public static boolean flies() {
        return false;
    }

    /**
     * Return the name of this firework
     *
     * @return the name of this firework
     */
    public String getName() {
        return name;
    }

    /**
     * Return the price of this firework
     *
     * @return the price of this firework
     */
    public double getPrice() {
        return price;
    }

    /**
     * Return a random firework from our shelves.
     *
     * @return a random firework from our shelves; not actually
     *         implemented
     */
    public static Firework getRandom() {
        return null;
    }

    /**
     * Return the type of this firework, essentially the
     * class's name.
     *
     * @return the type of this firework, essentially the
     *         class's name
     */
    public String getType() {
        String s = getClass().getName();

        return s.substring(s.lastIndexOf('.') + 1);
    }

    /**
     * Return a firework of the given name.
     *
     * @param name a name to lookup
     * @return a firework of the given name; not actually
     *         implemented
     */
    public static Firework lookup(String name) {
        return new Firework("demo", 0);
    }
}
