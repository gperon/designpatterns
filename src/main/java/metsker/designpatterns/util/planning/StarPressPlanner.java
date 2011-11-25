/*
 * @(#)StarPressPlanner.java   2011-11-01
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



package metsker.designpatterns.util.planning;

import metsker.designpatterns.util.machine.StarPress;

/**
 * This planner predicts when a star press will become available. A complete
 * implementation would probably consider many variables that affect a star
 * press.
 *
 * @author Steven J. Metsker
 */
public class StarPressPlanner extends MachinePlanner {

    /**
     * Construct a new planner for a star press.
     *
     * @param machine
     */
    public StarPressPlanner(StarPress machine) {
        super(machine);
    }

    /**
     * Return a datetime when the star press that this planner represents will
     * next become available.
     *
     * @return Date when the star press that this planner represents will next
     *         become available. In practice, this method would employ some
     *         operational modeling logic to determine this time.
     */
    public java.util.Date getAvailable() {
        // just return the current time, in this example
        return new java.util.Date();
    }
}
