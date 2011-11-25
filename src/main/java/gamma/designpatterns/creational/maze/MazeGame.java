/*
 * @(#)MazeGame.java   2011-11-01
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

import gamma.designpatterns.creational.abstractfactory.AbstractMazeFactory;
import gamma.designpatterns.creational.builder.MazeBuilder;

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
public class MazeGame {

    /**
     *  Constructor for the MazeGame object
     */
    public MazeGame() {}

    /**
     *  Description of the Method
     *
     * @param  factory  Description of the Parameter
     * @return          Description of the Return Value
     */
    public static Maze createMaze(AbstractMazeFactory factory) {
        Maze aMaze = factory.makeMaze();
        Room r1 = factory.makeRoom(1);
        Room r2 = factory.makeRoom(2);
        Door aDoor = factory.makeDoor(r1, r2);
        aMaze.addRoom(r1);
        aMaze.addRoom(r2);
        r1.setSide(Direction.NORTH, factory.makeWall());
        r1.setSide(Direction.EAST, aDoor);
        r1.setSide(Direction.SOUTH, factory.makeWall());
        r1.setSide(Direction.WEST, factory.makeWall());
        r2.setSide(Direction.NORTH, factory.makeWall());
        r2.setSide(Direction.EAST, factory.makeWall());
        r2.setSide(Direction.SOUTH, factory.makeWall());
        r2.setSide(Direction.WEST, aDoor);

        return aMaze;
    }

    /**
     *  Description of the Method
     *
     * @param  builder  Description of the Parameter
     * @return          Description of the Return Value
     */
    public Maze createMaze(MazeBuilder builder) {
        builder.buildMaze();
        builder.buildRoom(1);
        builder.buildRoom(2);
        builder.buildDoor(1, 2);

        return builder.getMaze();
    }

    /**
     *  Description of the Method
     *
     * @param  builder  Description of the Parameter
     * @return          Description of the Return Value
     */
    public Maze createComplexMaze(MazeBuilder builder) {
        builder.buildRoom(1);
        // ...
        builder.buildRoom(1001);

        return builder.getMaze();
    }

    /**
     *  Description of the Method
     *
     * @return    Description of the Return Value
     */
    public Maze createMaze() {
        Maze aMaze = makeMaze();
        Room r1 = makeRoom(1);
        Room r2 = makeRoom(2);
        Door theDoor = makeDoor(r1, r2);
        aMaze.addRoom(r1);
        aMaze.addRoom(r2);
        r1.setSide(Direction.NORTH, makeWall());
        r1.setSide(Direction.EAST, theDoor);
        r1.setSide(Direction.SOUTH, makeWall());
        r1.setSide(Direction.WEST, makeWall());
        r2.setSide(Direction.NORTH, makeWall());
        r2.setSide(Direction.EAST, makeWall());
        r2.setSide(Direction.SOUTH, makeWall());
        r2.setSide(Direction.WEST, theDoor);

        return aMaze;
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
        return new Room(n);
    }

    /**
     *  Description of the Method
     *
     * @return    Description of the Return Value
     */
    public Wall makeWall() {
        return new Wall();
    }

    /**
     *  Description of the Method
     *
     * @param  r1  Description of the Parameter
     * @param  r2  Description of the Parameter
     * @return     Description of the Return Value
     */
    public Door makeDoor(Room r1, Room r2) {
        return new Door(r1, r2);
    }
}
