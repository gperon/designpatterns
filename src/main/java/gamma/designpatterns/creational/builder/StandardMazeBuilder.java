/*
 * @(#)StandardMazeBuilder.java   2011-11-01
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



package gamma.designpatterns.creational.builder;

import gamma.designpatterns.creational.maze.Direction;
import gamma.designpatterns.creational.maze.Door;
import gamma.designpatterns.creational.maze.Maze;
import gamma.designpatterns.creational.maze.Room;
import gamma.designpatterns.creational.maze.Wall;

import java.util.*;

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
public class StandardMazeBuilder implements MazeBuilder {
    private Maze currentMaze;

    /**
     *  Constructor for the StandardMazeBuilder object
     */
    public StandardMazeBuilder() {}

    /**
     *  Description of the Method
     */
    public void buildMaze() {
        currentMaze = new Maze();
    }

    /**
     *  Description of the Method
     *
     * @param  roomNumber  Description of the Parameter
     */
    public void buildRoom(int roomNumber) {
        if (currentMaze.getRoom(roomNumber) == null) {
            Room room = new Room(roomNumber);
            currentMaze.addRoom(room);
            room.setSide(Direction.NORTH, new Wall());
            room.setSide(Direction.SOUTH, new Wall());
            room.setSide(Direction.EAST, new Wall());
            room.setSide(Direction.WEST, new Wall());
        }
    }

    /**
     *  Description of the Method
     *
     * @param  roomFrom  Description of the Parameter
     * @param  roomTo    Description of the Parameter
     */
    public void buildDoor(int roomFrom, int roomTo) {
        Room r1 = currentMaze.getRoom(roomFrom);
        Room r2 = currentMaze.getRoom(roomTo);
        Door d = new Door(r1, r2);
        r1.setSide(commonWall(r1, r2), d);
        r2.setSide(commonWall(r2, r1), d);
    }

    /**
     *  Gets the maze attribute of the StandardMazeBuilder object
     *
     * @return    The maze value
     */
    public Maze getMaze() {
        return currentMaze;
    }

    /**
     *  Description of the Method
     *
     * @param  r1  Description of the Parameter
     * @param  r2  Description of the Parameter
     * @return     Description of the Return Value
     */
    private Direction commonWall(Room r1, Room r2) {
        Direction d = null;
        Direction d1 = null;
        Direction d2 = null;
        Random r = new Random();
        d = Direction.values()[r.nextInt(4)];

        /*
         *       for (int i = 0; i < directions.length; i++) {
         *           d1 = directions[i];
         *           d2 = Direction.getOppositeDirection(d1);
         *           if (r1.getSide(d1) instanceof Wall &&
         *                   r2.getSide(d2) instanceof Wall &&
         *                   r1.getSide(d1).equals(r2.getSide(d2))) {
         *               d = d1;
         *           }
         *       }
         */
        return d;
    }
}
