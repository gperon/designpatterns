/*
 * @(#)MazePrototypeFactory.java   2011-11-01
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



package gamma.designpatterns.creational.prototype;

import gamma.designpatterns.creational.maze.Door;
import gamma.designpatterns.creational.maze.MapSite;
import gamma.designpatterns.creational.maze.Maze;
import gamma.designpatterns.creational.maze.Room;
import gamma.designpatterns.creational.maze.Wall;
import gamma.designpatterns.creational.abstractfactory.MazeFactory;

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
public class MazePrototypeFactory extends MazeFactory {
    private Maze prototypeMaze;
    private Room prototypeRoom;
    private Wall prototypeWall;
    private Door prototypeDoor;

    /**
     *  Constructor for the MazePrototypeFactory object
     *
     * @param  maze  Description of the Parameter
     * @param  wall  Description of the Parameter
     * @param  room  Description of the Parameter
     * @param  door  Description of the Parameter
     */
    public MazePrototypeFactory(Maze maze, Wall wall, Room room, Door door) {
        this.prototypeMaze = maze;
        this.prototypeWall = wall;
        this.prototypeRoom = room;
        this.prototypeDoor = door;
    }

    /**
     *  Description of the Method
     *
     * @return    Description of the Return Value
     */
    public Maze makeMaze() {
        return new Maze();
    }

    /**
     *  Description of the Method
     *
     * @param  n  Description of the Parameter
     * @return    Description of the Return Value
     */
    public Room makeRoom(int n) {
        Room room;
        try {
            room = (Room) prototypeRoom.clone();
            MapSite[] sides = new MapSite[] { makeWall(), makeWall(), makeWall(), makeWall(), };
            room.initialize(n, sides);

            return room;
        } catch (CloneNotSupportedException cnse) {
            cnse.printStackTrace();

            return null;
        }
    }

    /**
     *  Description of the Method
     *
     * @return    Description of the Return Value
     */
    public Wall makeWall() {
        try {
            return (Wall) prototypeWall.clone();
        } catch (CloneNotSupportedException cnse) {
            cnse.printStackTrace();

            return null;
        }
    }

    /**
     *  Description of the Method
     *
     * @param  r1  Description of the Parameter
     * @param  r2  Description of the Parameter
     * @return     Description of the Return Value
     */
    public Door makeDoor(Room r1, Room r2) {
        try {
            Door door = (Door) prototypeDoor.clone();
            door.initialize(r1, r2);

            return door;
        } catch (CloneNotSupportedException cnse) {
            cnse.printStackTrace();

            return null;
        }
    }
}
