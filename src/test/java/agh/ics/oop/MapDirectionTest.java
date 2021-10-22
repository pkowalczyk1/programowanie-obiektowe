package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {
    @Test
    public void nextTest() {
        assertEquals(MoveDirection.NORTH.next(), MoveDirection.EAST);
        assertEquals(MoveDirection.EAST.next(), MoveDirection.SOUTH);
        assertEquals(MoveDirection.SOUTH.next(), MoveDirection.WEST);
        assertEquals(MoveDirection.WEST.next(), MoveDirection.NORTH);
    }

    @Test
    public void previousTest() {
        assertEquals(MoveDirection.NORTH.previous(), MoveDirection.WEST);
        assertEquals(MoveDirection.EAST.previous(), MoveDirection.NORTH);
        assertEquals(MoveDirection.SOUTH.previous(), MoveDirection.EAST);
        assertEquals(MoveDirection.WEST.previous(), MoveDirection.SOUTH);
    }

    @Test
    public void toUnitVectorTest() {
        assertEquals(MoveDirection.NORTH.toUnitVector(), new Vector2D(0, 1));
        assertEquals(MoveDirection.EAST.toUnitVector(), new Vector2D(1, 0));
        assertEquals(MoveDirection.SOUTH.toUnitVector(), new Vector2D(0, -1));
        assertEquals(MoveDirection.WEST.toUnitVector(), new Vector2D(-1, 0));
    }
}
