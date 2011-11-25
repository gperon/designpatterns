/*
 * @(#)SkyrocketTest.java   2011-11-01
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



package metsker.designpatterns.util.testing;

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
import junit.framework.TestCase;

import metsker.designpatterns.util.firework.OozinozSkyrocket;
import metsker.designpatterns.util.firework.PhysicalRocket;

/**
 *  Test the Simulation package and the Fireworks classes that support it.
 */
public class SkyrocketTest extends TestCase {
    private static double SPECIFIC_IMPULSE = 620;    // Newtons/Kg
    private static double FUEL_DENSITY = 1800;       // Kg/M**3

    /**
     *  Test that mass varies linearly from start mass to 0, over the
     *  time it takes the fuel to burn.
     */
    public void testPhysicalRocket() {
        double burnArea = .0030;
        double burnDepth = .06;
        double burnVolume = burnArea * burnDepth;
        double fuelMass = burnVolume * FUEL_DENSITY;
        double totalMass = fuelMass * 1.1;
        double burnRate = .020;
        PhysicalRocket r = new PhysicalRocket(burnArea, burnRate, fuelMass, totalMass);
        double bt = burnDepth / burnRate;
        double tol = 0.01;
        assertEquals("check burn time", bt, r.getBurnTime(), tol);
        assertEquals("initial mass", totalMass, r.getMass(0), tol);
        assertEquals("burnt out mass", totalMass - fuelMass, r.getMass(bt), tol);
        assertEquals("half mass", totalMass - fuelMass * .5, r.getMass(bt / 2), tol);
        assertEquals("thrust", SPECIFIC_IMPULSE * FUEL_DENSITY * burnArea * burnRate,
                     r.getThrust(bt / 2), tol);
    }

    /**
     *  Test that mass varies linearly from start mass to 0, over the
     *  time it takes the fuel to burn.
     */
    public void testOozinozSkyocket() {
        double burnArea = .0030;
        double burnDepth = .06;
        double burnVolume = burnArea * burnDepth;
        double fuelMass = burnVolume * FUEL_DENSITY;
        double totalMass = fuelMass * 1.1;
        double burnRate = .020;
        PhysicalRocket pr = new PhysicalRocket(burnArea, burnRate, fuelMass, totalMass);
        OozinozSkyrocket or = new OozinozSkyrocket(pr);
        double tol = 0.01;
        or.setSimTime(0);
        assertEquals("initial mass", totalMass, or.getMass(), tol);
        assertEquals("thrust", SPECIFIC_IMPULSE * FUEL_DENSITY * burnArea * burnRate,
                     or.getThrust(), tol);
        double bt = burnDepth / burnRate;
        or.setSimTime(bt * 1.01);
        assertEquals("end mass", totalMass - fuelMass, or.getMass(), tol);
        assertEquals("thrust", 0, or.getThrust(), tol);
    }
}
