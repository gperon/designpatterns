/*
 * @(#)Skyrocket.java   2011-11-01
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



package metsker.designpatterns.util.simulation;

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
 * Instances of this class simulate rockets. The simulation depends mainly on
 * the internal ballistics of the burning fuel.
 */
public class Skyrocket {
    private double mass;
    private double thrust;
    private double burnTime;
    protected double simTime;

    /**
     * Create a model of a rocket.
     * @param mass the rocket's initial mass
     * @param thrust the rocket's initial thrust
     * @param burnTime the rocket fuel's burn time
     */
    public Skyrocket(double mass, double thrust, double burnTime) {
        this.mass = mass;
        this.thrust = thrust;
        this.burnTime = burnTime;
    }

    /**
     * @return Model mass as reducing linearly from the initial mass down to 0
     *         during the life of the fuel.
     */
    public double getMass() {
        if (simTime > burnTime) {
            return 0;
        }

        return mass * (1 - (simTime / burnTime));
    }

    /**
     * @return Model thrust as constant for the life of the fuel.
     */
    public double getThrust() {
        if (simTime > burnTime) {
            return 0;
        }

        return thrust;
    }

    /**
     * When the simulation updates its clock, hang onto the current time.
     * @param t the time in the simulation
     */
    public void setSimTime(double t) {
        simTime = t;
    }
}
