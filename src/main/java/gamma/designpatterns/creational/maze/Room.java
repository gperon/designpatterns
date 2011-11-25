/*
 * @(#)Room.java   2011-11-01
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
 * @created    7 giugno 2002
 * @version    1.0
 */
public class Room implements MapSite {
    private MapSite[] sides = new MapSite[4];
    private int roomNumber;

    /**
     *  Constructor for the Room object
     *
     * @param  roomNumber  Description of the Parameter
     */
    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     *  Constructor for the Room object
     */
    public Room() {}

    /**
     *  Description of the Method
     *
     * @param  roomNumber  Description of the Parameter
     * @param  sides       Description of the Parameter
     */
    public void initialize(int roomNumber, MapSite[] sides) {
        this.roomNumber = roomNumber;
        this.sides = sides;
    }

    /**
     *  Constructor for the Room object
     *
     * @param  room  Description of the Parameter
     */
    protected Room(Room room) {
        this.roomNumber = room.roomNumber;
        for (int i = 0; i < sides.length; i++) {
            try {
                if (room.sides[i] == null) {
                    this.sides[i] = null;
                } else {
                    this.sides[i] = (MapSite) room.sides[i].clone();
                }
            } catch (java.lang.CloneNotSupportedException cnse) {
                cnse.printStackTrace();
                this.sides[i] = null;
            }
        }
    }

    /**
     *  Gets the side attribute of the Room object
     *
     * @param  d  Description of the Parameter
     * @return    The side value
     */
    public MapSite getSide(Direction d) {
        return sides[d.ordinal()];
    }

    /**
     *  Sets the side attribute of the Room object
     *
     * @param  d     The new side value
     * @param  site  The new side value
     */
    public void setSide(Direction d, MapSite site) {
        sides[d.ordinal()] = site;
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
     * @return    Description of the Return Value
     */
    public String toString() {
        StringBuffer buffer = new StringBuffer("Room: ");
        buffer.append(roomNumber);
        // North
        buffer.append(" [");
        buffer.append(Direction.NORTH);
        buffer.append(": ");
        buffer.append(sides[Direction.NORTH.ordinal()]);
        // East
        buffer.append(" ");
        buffer.append(Direction.EAST);
        buffer.append(": ");
        buffer.append(sides[Direction.EAST.ordinal()]);
        // South
        buffer.append(" ");
        buffer.append(Direction.SOUTH);
        buffer.append(": ");
        buffer.append(sides[Direction.SOUTH.ordinal()]);
        // West
        buffer.append(" ");
        buffer.append(Direction.WEST);
        buffer.append(": ");
        buffer.append(sides[Direction.WEST.ordinal()]);
        buffer.append("]");

        return buffer.toString();
    }

    /**
     *  Gets the roomNumber attribute of the Room object
     *
     * @return    The roomNumber value
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     *  Description of the Method
     *
     * @param  parm1  Description of the Parameter
     * @return        Description of the Return Value
     */
    public boolean equals(Object parm1) {
        if ((parm1 instanceof Room) && ((Room) parm1).getRoomNumber() == roomNumber) {
            return true;
        }

        return false;
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
        return new Room(this);
    }
}
