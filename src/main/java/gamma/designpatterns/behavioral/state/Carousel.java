/*
 * @(#)Carousel.java   2011-11-01
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

import java.util.*;

import java.awt.event.*;

import javax.swing.Timer;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class Carousel extends Observable implements ActionListener {
    private double percentClosed = 1.00;
    private Timer heartbeatTimer;
    private Timer timeoutTimer;

    // Carousel uses the following states, not to be confused
    // with ones we create for the Door classes; Carousel is
    // a black box to us

    /**
     * Enum description
     *
     */
    public enum CarouselState {
        CLOSED, OPENING, OPEN, CLOSING, STAYOPEN
    }

    ;
    //
    private CarouselState state = CarouselState.CLOSED;

    /**
     * Respond to one of two timers, our heartbeat or the
     * timeout timer.
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(heartbeatTimer())) {
            heartbeat();
        }
        if (source.equals(timeoutTimer())) {
            timeout();
        }
    }

    /**
     * The user clicked our button. React accordingly
     * and let the Door object know.
     */
    public void click() {
        if (state == CarouselState.CLOSED) {
            this.state = CarouselState.OPENING;
        } else if ((state == CarouselState.OPENING) || (state == CarouselState.STAYOPEN)) {
            this.state = CarouselState.CLOSING;
        } else if (state == CarouselState.OPEN) {
            this.state = CarouselState.STAYOPEN;
            timeoutTimer.stop();
        } else if (state == CarouselState.CLOSING) {
            this.state = CarouselState.OPENING;
        }
        setChanged();
        notifyObservers();
    }

    /**
     * Return a percentage showing how closed the
     * door is.
     *
     * @return
     */
    public double getPercentClosed() {
        return percentClosed;
    }

    /*
     * Update the simulated door.
     */
    private void heartbeat() {
        if (state == CarouselState.OPENING) {
            incrementPercentClosed(-.04);
            if (percentClosed <= 0.01) {
                this.state = CarouselState.OPEN;
                timeoutTimer().start();
            }
        } else if (state == CarouselState.CLOSING) {
            incrementPercentClosed(.04);
            if (percentClosed >= 0.99) {
                this.state = CarouselState.CLOSED;
            }
        }
    }

    /*
     * This timer makes the carousel seem alive.
     */
    private Timer heartbeatTimer() {
        if (heartbeatTimer == null) {
            heartbeatTimer = new Timer(400, this);
        }

        return heartbeatTimer;
    }

    private void incrementPercentClosed(double inc) {
        percentClosed += inc;
        percentClosed = Math.min(1.0, percentClosed);
        percentClosed = Math.max(0.0, percentClosed);
        if (percentClosed >= 0.99) {
            state = CarouselState.CLOSED;
        } else if (percentClosed <= 0.01) {
            state = CarouselState.OPEN;
        }
        setChanged();
        notifyObservers();
    }

    /**
     * Start the timer that makes a carousel object
     * monitor the state of its door.
     */
    public void start() {
        heartbeatTimer().start();
    }

    /*
     * We got bored standing around with our door open.
     */
    private void timeout() {
        state = CarouselState.CLOSING;
        setChanged();
        notifyObservers();
    }

    /**
     * Insert the method's description here.
     * Creation date: (5/15/01 12:30:54 PM)
     * @param args java.lang.String[]
     */
    private Timer timeoutTimer() {
        if (timeoutTimer == null) {
            timeoutTimer = new Timer(2000, this);
            timeoutTimer.setRepeats(false);
        }

        return timeoutTimer;
    }

    /**
     * Return a textual description of the door's state.
     *
     * @return a textual description of the door's state
     */
    public String status() {
        switch (state) {
            case OPENING :
                return "Opening";

            case OPEN :
                return "Open";

            case CLOSING :
                return "Closing";

            case STAYOPEN :
                return "StayOpen";

            default :
                return "Closed";
        }
    }
}
