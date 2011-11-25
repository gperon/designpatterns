/*
 * @(#)Door2.java   2011-11-01
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



package metsker.designpatterns.behavioral.state;

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
import java.util.Observable;

/**
 * This refactoring of the Door class moves state-specific logic to a separate
 * class hierarchy.
 */
public class Door2 extends Observable {

    /** Field description */
    public final DoorState CLOSED = new DoorClosed(this);

    /** Field description */
    public final DoorState CLOSING = new DoorClosing(this);

    /** Field description */
    public final DoorState OPEN = new DoorOpen(this);

    /** Field description */
    public final DoorState OPENING = new DoorOpening(this);

    /** Field description */
    public final DoorState STAYOPEN = new DoorStayOpen(this);
    private DoorState state = CLOSED;

    /**
     * The carousel user has touched the carousel button. This "one touch"
     * button elicits different behaviors, depending on the state of the door.
     */
    public void touch() {
        state.touch();
    }

    /**
     * This is a notification from the mechanical carousel that the door
     * finished opening or shutting.
     */
    public void complete() {
        state.complete();
    }

    /**
     * This is a notification from the mechanical carousel that the door got
     * tired of being open.
     */
    public void timeout() {
        state.timeout();
    }

    /**
     * @return a textual description of the door's state
     */
    public String status() {
        return state.status();
    }

    protected void setState(DoorState state) {
        this.state = state;
        setChanged();
        notifyObservers();
    }
}
