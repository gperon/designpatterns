/*
 * @(#)AbstractMazeFactory.java   2011-11-01
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


package gamma.designpatterns.creational.abstractfactory;

import gamma.designpatterns.creational.maze.Door;
import gamma.designpatterns.creational.maze.Maze;
import gamma.designpatterns.creational.maze.Room;
import gamma.designpatterns.creational.maze.Wall;

/**
 * Description of the Interface
 *
 * @author giorgio
 * @created 2 giugno 2002
 */
public interface AbstractMazeFactory {

    /**
     * Description of the Method
     *
     * @return Description of the Return Value
     */
    Maze makeMaze();

    /**
     * Description of the Method
     *
     * @return Description of the Return Value
     */
    Wall makeWall();

    /**
     * Description of the Method
     *
     * @param r1 Description of the Parameter
     * @param r2 Description of the Parameter
     * @return Description of the Return Value
     */
    Door makeDoor(Room r1, Room r2);

    /**
     * Description of the Method
     *
     * @param roomNumber Description of the Parameter
     * @return Description of the Return Value
     */
    Room makeRoom(int roomNumber);
}
