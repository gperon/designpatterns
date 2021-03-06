/*
 * @(#)DoorState.java   2011-11-01
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


package gamma.designpatterns.behavioral.state;

/**
 * Class description
 *
 * @author <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 * @version 0.1.1, 2011-11-01
 */
public abstract class DoorState {
    protected Door door;

    /**
     * Subclasses must decide what to do when the user
     * clicks the physical carousel button.
     */
    public abstract void click();

    /**
     * By default, discard notifications that the door
     * finished opening or closing.
     */
    public void complete() {
    }

    /**
     * Return a textual desciption of this state.
     *
     * @return a textual desciption of this state
     */
    public String status() {
        String s = getClass().getName();

        return s.substring(s.lastIndexOf('.') + 1);
    }

    /**
     * By default, discard notifications that the door
     * began closing after having been open for a while.
     */
    public void timeout() {
    }

    /**
     * Construct a state for the provided door.
     *
     * @param door a door that needs a state model
     */
    public DoorState(Door door) {
        this.door = door;
    }
}
