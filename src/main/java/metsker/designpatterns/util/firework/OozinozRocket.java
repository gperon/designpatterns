/*
 * @(#)OozinozRocket.java   2011-11-01
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

import metsker.designpatterns.util.simulation.RocketSim;

/**
 *  An adapter that lets a rocket participate in a simulation.
 */
public class OozinozRocket extends PhysicalRocket implements RocketSim {
    private double time;

    /**
     * Constructs ...
     *
     *
     * @param burnArea
     * @param burnRate
     * @param fuelMass
     * @param totalMass
     */
    public OozinozRocket(double burnArea, double burnRate, double fuelMass, double totalMass) {
        super(burnArea, burnRate, fuelMass, totalMass);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public double getMass() {
        return getMass(time);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public double getThrust() {
        return getThrust(time);
    }

    /**
     * Method description
     *
     *
     * @param time
     */
    public void setSimTime(double time) {
        this.time = time;
    }
}
