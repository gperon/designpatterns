/*
 * @(#)StateManager.java   2011-11-01
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



package cooper.designpatterns.behavioral.state;

import java.awt.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class StateManager {
    private State currentState;
    RectState rState;
    ArrowState aState;
    CircleState cState;
    FillState fState;

    /**
     * Constructs ...
     *
     *
     * @param med
     */
    public StateManager(Mediator med) {
        rState = new RectState(med);
        cState = new CircleState(med);
        aState = new ArrowState(med);
        fState = new FillState(med);
        currentState = aState;
    }

    /**
     * Method description
     *
     */
    public void setRect() {
        currentState = rState;
    }

    /**
     * Method description
     *
     */
    public void setCircle() {
        currentState = cState;
    }

    /**
     * Method description
     *
     */
    public void setFill() {
        currentState = fState;
    }

    /**
     * Method description
     *
     */
    public void setArrow() {
        currentState = aState;
    }

    /**
     * Method description
     *
     *
     * @param x
     * @param y
     */
    public void mouseDown(int x, int y) {
        currentState.mouseDown(x, y);
    }

    /**
     * Method description
     *
     *
     * @param x
     * @param y
     */
    public void mouseUp(int x, int y) {
        currentState.mouseUp(x, y);
    }

    /**
     * Method description
     *
     *
     * @param x
     * @param y
     */
    public void mouseDrag(int x, int y) {
        currentState.mouseDrag(x, y);
    }

    /**
     * Method description
     *
     *
     * @param d
     * @param c
     */
    public void select(Drawing d, Color c) {
        currentState.select(d, c);
    }
}
