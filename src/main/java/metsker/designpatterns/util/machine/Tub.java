/*
 * @(#)Tub.java   2011-11-01
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



package metsker.designpatterns.util.machine;

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
 *  A tub is a standard, rubber container that contains
 *  about four liters of a chemical. This class is a minimal
 *  model that helps show how to manage a one-to-many
 *  relation in an object model.
 */
public class Tub {
    private String id;
    private TubMediator mediator = null;

    /**
     *  Create a tub with the given id and managed by the given
     *  mediator.
     * @param id the identity of this machine
     * @param mediator
     */
    public Tub(String id, TubMediator mediator) {
        this.id = id;
        this.mediator = mediator;
    }

    /**
     *  Use a mediator to control getting and setting the location
     *  of this tub. This prevents a tub from ever being modeled as
     *  being on two machines at once.
     *
     * @return
     */
    public Machine getLocation() {
        return mediator.getMachine(this);
    }

    /**
     * Method description
     *
     *
     * @param value
     */
    public void setLocation(Machine value) {
        mediator.set(this, value);
    }

    /**
     *  @return a textual representation of this tub.
     */
    public String toString() {
        return id;
    }

    /**
     *  @return a unique id for this tub.
     */
    public int hashCode() {
        return id.hashCode();
    }

    /**
     *
     * @param obj
     *  @return true if, according to business rules, this
     *  component and the supplied object refer to the same
     *  thing.
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != Tub.class) {
            return false;
        }
        Tub that = (Tub) obj;

        return id.equals(that.id);
    }
}
