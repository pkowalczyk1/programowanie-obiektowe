package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    IWorldMap map = new RectangularMap(10, 10);

    @Test
    public void canMoveToTest() {
        Animal a = new Animal(map, new Vector2d(2, 4));
        map.place(a);
        assertTrue(map.canMoveTo(new Vector2d(3, 5)));
        assertFalse(map.canMoveTo(new Vector2d(11, 15)));
        assertFalse(map.canMoveTo(new Vector2d(-2, 4)));
        assertFalse(map.canMoveTo(new Vector2d(2, 4)));
    }

    @Test
    public void isOccupiedTest() {
        Animal a = new Animal(map, new Vector2d(3, 6));
        Animal b = new Animal(map, new Vector2d(4, 2));
        Animal c = new Animal(map, new Vector2d(8, 6));
        map.place(a);
        map.place(b);
        map.place(c);
        assertTrue(map.isOccupied(new Vector2d(3, 6)));
        assertTrue(map.isOccupied(new Vector2d(4, 2)));
        assertTrue(map.isOccupied(new Vector2d(8, 6)));
        assertFalse(map.isOccupied(new Vector2d(2, 4)));
    }

    @Test
    public void objectAtTest() {
        Animal a = new Animal(map, new Vector2d(4, 8));
        Animal b = new Animal(map, new Vector2d(1, 1));
        map.place(a);
        map.place(b);
        assertEquals(a, map.objectAt(new Vector2d(4, 8)));
        assertEquals(b, map.objectAt(new Vector2d(1, 1)));
        assertNull(map.objectAt(new Vector2d(2, 5)));
    }

    @Test
    public void placeTest() {
        Animal a = new Animal(map, new Vector2d(3, 9));
        Animal b = new Animal(map, new Vector2d(3, 9));
        Animal c = new Animal(map, new Vector2d(11, 15));
        assertTrue(map.place(a));
        assertFalse(map.place(b));
        assertFalse(map.place(c));
        assertEquals(a, map.objectAt(new Vector2d(3, 9)));
    }
}
