/*
 * @(#)OozinozSkyrocket.java   2011-11-01
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

import metsker.designpatterns.util.simulation.Skyrocket;

/**
 * Instances of this class qualify as Skyrocket objects, but use information
 * from a PhysicalRocket object. This class is an "object adapter" that adapts
 * the PhysicalRocket class to meet the needs of clients of the Skyrocket class.
 */
public class OozinozSkyrocket extends Skyrocket {
    private PhysicalRocket rocket;

    /**
     * Constructs ...
     *
     *
     * @param r
     */
    public OozinozSkyrocket(PhysicalRocket r) {
        super(r.getMass(0), r.getThrust(0), r.getBurnTime());
        rocket = r;
    }

    /**
     * Use a PhysicalRocket object to model a rocket's mass at simulation time.
     * @return mass
     */
    public double getMass() {
        return rocket.getMass(simTime);
    }

    /**
     * Use a PhysicalRocket object to model a rocket's thrust at simulation
     * time.
     * @return thrust
     */
    public double getThrust() {
        return rocket.getThrust(simTime);
    }
}
