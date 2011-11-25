/*
 * @(#)PhysicalRocket.java   2011-11-01
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



package metsker.designpatterns.util.firework;

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
 * A physical model of a rocket for use in simulations.
 */
public class PhysicalRocket {
    private double burnArea;
    private double burnRate;
    private double initialFuelMass;
    private double totalMass;
    private double totalBurnTime;
    private static double SPECIFIC_IMPULSE = 620;    // Newtons/Kg
    private static double FUEL_DENSITY = 1800;       // Kg/M**3

    /**
     * Constructs ...
     *
     *
     * @param burnArea
     * @param burnRate
     * @param fuelMass
     * @param totalMass
     */
    public PhysicalRocket(double burnArea, double burnRate, double fuelMass, double totalMass) {
        this.burnArea = burnArea;
        this.burnRate = burnRate;
        this.initialFuelMass = fuelMass;
        this.totalMass = totalMass;
        double initialFuelVolume = fuelMass / FUEL_DENSITY;
        this.totalBurnTime = initialFuelVolume / (burnRate * burnArea);
    }

    /**
     *
     * @param t
     * @return The remaining mass of the rocket after burning off a portion of
     *         its fuel.
     */
    public double getMass(double t) {
        if (t > totalBurnTime) {
            return totalMass - initialFuelMass;
        }
        double burntFuelVolume = burnRate * burnArea * t;

        return totalMass - burntFuelVolume * FUEL_DENSITY;
    }

    /**
     * @param time time since ignition
     * @return Calculated thrust with the standard Oozinoz formula.
     */
    public double getThrust(double time) {
        if (time > totalBurnTime) {
            return 0;
        }

        return FUEL_DENSITY * SPECIFIC_IMPULSE * burnRate * burnArea;
    }

    /**
     * @return the time this rocket's fuel burns.
     */
    public double getBurnTime() {
        return totalBurnTime;
    }
}
