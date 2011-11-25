/*
 * @(#)Door.java   2011-11-01
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



package gamma.designpatterns.creational.maze;

/**
 *  <p>
 *
 *  Title: Design Patterns</p> <p>
 *
 *  Description: </p> <p>
 *
 *  Copyright: Copyright (c) 2002</p> <p>
 *
 *  Company: GioPerLab</p>
 *
 * @author     giorgio_peron@libero.it
 * @created    8 giugno 2002
 * @version    1.0
 */
public class Door implements MapSite {
    private Room r1;
    private Room r2;
    private boolean isOpen;

    /**
     *  Constructor for the Door object
     *
     * @param  r1  Description of the Parameter
     * @param  r2  Description of the Parameter
     */
    public Door(Room r1, Room r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    /**
     *  Constructor for the Door object
     */
    public Door() {}

    /**
     *  Description of the Method
     *
     * @param  r1  Description of the Parameter
     * @param  r2  Description of the Parameter
     */
    public void initialize(Room r1, Room r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    /**
     *  Constructor for the Door object
     *
     * @param  door  Description of the Parameter
     */
    protected Door(Door door) {
        try {
            if (door.r1 == null) {
                this.r1 = null;
            } else {
                this.r1 = (Room) door.r1.clone();
            }
        } catch (java.lang.CloneNotSupportedException cnse) {
            cnse.printStackTrace();
            this.r1 = null;
        }
        try {
            if (door.r2 == null) {
                this.r2 = null;
            } else {
                this.r2 = (Room) door.r2.clone();
            }
        } catch (java.lang.CloneNotSupportedException cnse) {
            cnse.printStackTrace();
            this.r1 = null;
        }
        this.isOpen = door.isOpen;
    }

    /**
     *  Description of the Method
     *
     * @param  r  Description of the Parameter
     * @return    Description of the Return Value
     */
    public Room otherSideFrom(Room r) {
        if (r1.equals(r)) {
            return r2;
        }
        if (r2.equals(r)) {
            return r1;
        }

        return null;
    }

    /**
     *  Description of the Method
     */
    public void enter() {
        throw new java.lang.UnsupportedOperationException("Method enter() not yet implemented.");
    }

    /**
     *  Description of the Method
     *
     * @return                                           Description of the
     *      Return Value
     * @exception  java.lang.CloneNotSupportedException  Description of the
     *      Exception
     */
    public Object clone() throws java.lang.CloneNotSupportedException {
        return new Door(this);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String toString() {
        return "Door";
    }
}
