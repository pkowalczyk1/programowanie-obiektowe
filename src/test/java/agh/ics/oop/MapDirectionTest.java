package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {
    @Test
    public void nextTest() {
        assertEquals(MapDirection.NORTH.next(), MapDirection.EAST);
        assertEquals(MapDirection.EAST.next(), MapDirection.SOUTH);
        assertEquals(MapDirection.SOUTH.next(), MapDirection.WEST);
        assertEquals(MapDirection.WEST.next(), MapDirection.NORTH);
    }

    @Test
    public void previousTest() {
        assertEquals(MapDirection.NORTH.previous(), MapDirection.WEST);
        assertEquals(MapDirection.EAST.previous(), MapDirection.NORTH);
        assertEquals(MapDirection.SOUTH.previous(), MapDirection.EAST);
        assertEquals(MapDirection.WEST.previous(), MapDirection.SOUTH);
    }

    @Test
    public void toUnitVectorTest() {
        assertEquals(MapDirection.NORTH.toUnitVector(), new Vector2D(0, 1));
        assertEquals(MapDirection.EAST.toUnitVector(), new Vector2D(1, 0));
        assertEquals(MapDirection.SOUTH.toUnitVector(), new Vector2D(0, -1));
        assertEquals(MapDirection.WEST.toUnitVector(), new Vector2D(-1, 0));
    }
}
