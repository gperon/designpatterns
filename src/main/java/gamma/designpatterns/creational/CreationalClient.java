/*
 * @(#)CreationalClient.java   2011-11-01
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



package gamma.designpatterns.creational;

import gamma.designpatterns.creational.maze.BombedWall;
import gamma.designpatterns.creational.maze.Door;
import gamma.designpatterns.creational.maze.DoorNeedingSpell;
import gamma.designpatterns.creational.maze.Maze;
import gamma.designpatterns.creational.maze.MazeGame;
import gamma.designpatterns.creational.maze.Room;
import gamma.designpatterns.creational.maze.RoomWithABomb;
import gamma.designpatterns.creational.maze.Wall;
import gamma.designpatterns.creational.abstractfactory.BombedMazeFactory;
import gamma.designpatterns.creational.abstractfactory.EnchantedMazeFactory;
import gamma.designpatterns.creational.abstractfactory.MazeFactory;
import gamma.designpatterns.creational.builder.CountingMazeBuilder;
import gamma.designpatterns.creational.builder.MazeBuilder;
import gamma.designpatterns.creational.builder.StandardMazeBuilder;
import gamma.designpatterns.creational.factorymethod.BombedMazeGame;
import gamma.designpatterns.creational.factorymethod.EnchantedMazeGame;
import gamma.designpatterns.creational.prototype.MazePrototypeFactory;
import gamma.designpatterns.creational.singleton.MazeFactorySingleton;

import java.io.*;

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
 * @created    2 giugno 2002
 * @version    1.0
 */
public class CreationalClient {
    enum Creational {
        HALT, ABSTRACT_FACTORY, BUILDER, FACTORY_METHOD, PROTOTYPE, SINGLETON, QUIT
    }

    ;
    private static BufferedReader input;

    /**
     *  A unit test for JUnit
     */
    private static void testAbstractFactory() {
        Maze maze;
        // standard maze
        maze = MazeGame.createMaze(new MazeFactory());
        System.out.println(maze);
        // spell maze
        maze = MazeGame.createMaze(new EnchantedMazeFactory());
        System.out.println(maze);
        // bombed maze
        maze = MazeGame.createMaze(new BombedMazeFactory());
        System.out.println(maze);
    }

    /**
     *  A unit test for JUnit
     */
    private static void testBuilder() {
        Maze maze;
        MazeGame game = new MazeGame();
        MazeBuilder builder = new StandardMazeBuilder();
        game.createMaze(builder);
        maze = builder.getMaze();
        System.out.println(maze);
        // A more exotic MazeBuilder
        CountingMazeBuilder countingBuilder = new CountingMazeBuilder();
        game.createMaze(countingBuilder);
        System.out.println("The maze has " + countingBuilder.getRoomCount() + " rooms and "
                           + countingBuilder.getDoorCount() + " doors");
    }

    /**
     *  A unit test for JUnit
     */
    private static void testFactoryMethod() {
        Maze maze;
        MazeGame game;
        game = new MazeGame();
        maze = game.createMaze();
        System.out.println(maze);
        // Bombed game
        game = new BombedMazeGame();
        maze = game.createMaze();
        System.out.println(maze);
        // Enchanted game
        game = new EnchantedMazeGame();
        maze = game.createMaze();
        System.out.println(maze);
    }

    /**
     *  A unit test for JUnit
     */
    private static void testPrototype() {
        Maze maze;
        MazePrototypeFactory simpleMazeFactory = new MazePrototypeFactory(new Maze(), new Wall(),
                                                     new Room(), new Door());
        maze = MazeGame.createMaze(simpleMazeFactory);
        System.out.println(maze);
        MazePrototypeFactory bombedMazeFactory = new MazePrototypeFactory(new Maze(),
                                                     new BombedWall(), new RoomWithABomb(),
                                                     new DoorNeedingSpell());
        maze = MazeGame.createMaze(bombedMazeFactory);
        System.out.println(maze);
    }

    /**
     *  A unit test for JUnit
     */
    private static void testSingleton() {
        System.setProperty("mazestyle", "standard");
        Maze maze = MazeGame.createMaze(MazeFactorySingleton.getInstance());
        System.out.println(maze);
    }

    /**
     *  The main program for the CreationalClient class
     *
     * @param  args  The command line arguments
     */
    public static void main(String[] args) {
        while (true) {
            switch (showMenu()) {
                case ABSTRACT_FACTORY :
                    testAbstractFactory();

                    break;

                case BUILDER :
                    testBuilder();

                    break;

                case FACTORY_METHOD :
                    testFactoryMethod();

                    break;

                case PROTOTYPE :
                    testPrototype();

                    break;

                case SINGLETON :
                    testSingleton();

                    break;

                case QUIT :
                    System.exit(1);
                case HALT :
                    return;

                default :
                    break;
            }
        }
    }

    private static Creational showMenu() {
        String s;
        System.out.println("*** Design Patterns Examples - Creational ***");
        System.out.println("0) Back");
        System.out.println("");
        System.out.println("1) Abstract Factory");
        System.out.println("2) Builder");
        System.out.println("3) Factory Method");
        System.out.println("4) Prototype");
        System.out.println("5) Singleton");
        System.out.println("");
        System.out.println("Press q to quit");
        System.out.println("");
        System.out.print("-> ");
        System.out.flush();
        if (input == null) {
            input = new BufferedReader(new InputStreamReader(System.in));
        }
        try {
            s = input.readLine();
        } catch (IOException e) {
            return Creational.QUIT;
        }
        if (s.length() > 0) {
            try {
                return Creational.values()[Integer.parseInt(s)];
            } catch (ArrayIndexOutOfBoundsException aioobe) {
                return Creational.HALT;
            } catch (NumberFormatException nfe) {
                return Creational.QUIT;
            }
        } else {
            return Creational.HALT;
        }
    }
}
