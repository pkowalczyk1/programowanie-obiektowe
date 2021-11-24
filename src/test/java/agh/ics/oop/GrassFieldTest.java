package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Vector;

import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {
    IWorldMap map = new GrassField(5);

    @Test
    public void canMoveToTest() {
        Animal a = new Animal(map, new Vector2d(3, 10));
        Animal b = new Animal(map, new Vector2d(15, 20));
        map.place(a);
        map.place(b);
        assertTrue(map.canMoveTo(new Vector2d(4, 10)));
        assertFalse(map.canMoveTo(new Vector2d(3, 10)));
        assertFalse(map.canMoveTo(new Vector2d(15, 20)));
    }

    @Test
    public void objectAtTest() {
        Animal a = new Animal(map, new Vector2d(4, 11));
        Animal b = new Animal(map, new Vector2d(12, 7));
        map.place(a);
        map.place(b);
        assertTrue(map.objectAt(new Vector2d(4, 11)) instanceof Animal);
        assertTrue(map.objectAt(new Vector2d(12, 7)) instanceof Animal);
        assertEquals(a, map.objectAt(new Vector2d(4, 11)));
        assertEquals(b, map.objectAt(new Vector2d(12, 7)));
        for (int i=0; i<(int)sqrt(50) + 2; i++) {
            for (int j=0; j<(int)sqrt(50) + 2; j++) {
                if (map.objectAt(new Vector2d(i, j)) != null && !(map.objectAt(new Vector2d(i, j)) instanceof Animal)) {
                    assertTrue(map.objectAt(new Vector2d(i, j)) instanceof Grass);
                }
            }
        }
    }

    @Test
    public void isOccupiedTest() {
        Animal a = new Animal(map, new Vector2d(2, 15));
        Animal b = new Animal(map, new Vector2d(4, 8));
        map.place(a);
        map.place(b);
        assertTrue(map.isOccupied(new Vector2d(2, 15)));
        assertTrue(map.isOccupied(new Vector2d(4, 8)));
        for (int i=0; i<(int)sqrt(50) + 2; i++) {
            for (int j=0; j<(int)sqrt(50) + 2; j++) {
                if (map.objectAt(new Vector2d(i, j)) != null) {
                    assertTrue(map.isOccupied(new Vector2d(i, j)));
                }
                else {
                    assertFalse(map.isOccupied(new Vector2d(i, j)));
                }
            }
        }
    }

    @Test
    public void placeTest() {
        Animal a = new Animal(map, new Vector2d(4, 8));
        Animal b = new Animal(map, new Vector2d(9, 6));
        Animal c = new Animal(map, new Vector2d(4, 8));
        assertTrue(map.place(a));
        assertTrue(map.place(b));
        assertFalse(map.place(c));
        assertEquals(a, map.objectAt(new Vector2d(4, 8)));
        assertEquals(b, map.objectAt(new Vector2d(9, 6)));
    }
}
