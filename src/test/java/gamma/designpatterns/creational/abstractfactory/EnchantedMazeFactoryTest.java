package gamma.designpatterns.creational.abstractfactory;

import gamma.designpatterns.creational.maze.Door;
import gamma.designpatterns.creational.maze.DoorNeedingSpell;
import gamma.designpatterns.creational.maze.EnchantedRoom;
import gamma.designpatterns.creational.maze.Room;
import gamma.designpatterns.creational.maze.Spell;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EnchantedMazeFactoryTest {
    MazeFactory mazeFactory;

    @BeforeEach
    void setUp() {
        mazeFactory = new EnchantedMazeFactory();
    }

    @AfterEach
    void tearDown() {
        mazeFactory = null;
    }

    @Test
    @DisplayName("Door should be not null and instance of DoorNeedingSpell")
    void makeDoor() {
        Room r1 = mazeFactory.makeRoom(1);
        Room r2 = mazeFactory.makeRoom(2);
        Door door = mazeFactory.makeDoor(r1, r2);
        assertNotNull(door);
//        assertTrue(door);
        assertEquals(DoorNeedingSpell.class, door.getClass());
    }

    @Test
    @DisplayName("Room should be not null and instance of EnchantedRoom")
    void makeRoom() {
        Room room = mazeFactory.makeRoom(1);
        assertNotNull(room);
        assertEquals(EnchantedRoom.class, room.getClass());
    }

    @Test
    @DisplayName("Spell should be not null and English")
    void castSpell() {
        Spell spell = ((EnchantedMazeFactory) mazeFactory).castSpell();
        assertNotNull(spell);
        assertEquals(Spell.ENGLISH, spell);
    }
}