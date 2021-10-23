package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2DTest {
    @Test
    public void equalsTest() {
        Vector2D a = new Vector2D(1, 2);
        Vector2D b = new Vector2D(1, 2);
        Vector2D c = new Vector2D(2, 5);
        assertEquals(a, b);
        assertEquals(b, a);
        assertNotEquals(a, c);
        assertNotEquals(c, a);
    }

    @Test
    public void toStringTest() {
        Vector2D a = new Vector2D(1, 2);
        assertEquals(a.toString(), "(1, 2)");
    }

    @Test
    public void precedesTest() {
        Vector2D a = new Vector2D(1, 2);
        Vector2D b = new Vector2D(4, 8);
        assertTrue(a.precedes(b));
        assertFalse(b.precedes(a));
    }

    @Test
    public void followsTest() {
        Vector2D a = new Vector2D(1, 2);
        Vector2D b = new Vector2D(4, 8);
        assertTrue(b.follows(a));
        assertFalse(a.follows(b));
    }

    @Test
    public void upperRightTest() {
        Vector2D a = new Vector2D(1, 2);
        Vector2D b = new Vector2D(4, 8);
        Vector2D c = new Vector2D(7, 2);
        assertEquals(a.upperRight(b), b);
        assertEquals(b.upperRight(a), b);
        assertEquals(b.upperRight(c), new Vector2D(7, 8));
        assertEquals(c.upperRight(b), new Vector2D(7, 8));
    }

    @Test
    public void lowerLeftTest() {
        Vector2D a = new Vector2D(1, 2);
        Vector2D b = new Vector2D(4, 8);
        Vector2D c = new Vector2D(7, 2);
        assertEquals(a.lowerLeft(b), a);
        assertEquals(b.lowerLeft(a), a);
        assertEquals(c.lowerLeft(b), new Vector2D(4, 2));
        assertEquals(b.lowerLeft(c), new Vector2D(4, 2));
    }

    @Test
    public void addTest() {
        Vector2D a = new Vector2D(1, 2);
        Vector2D b = new Vector2D(4, 8);
        assertEquals(a.add(b), new Vector2D(5, 10));
        assertEquals(b.add(a), new Vector2D(5, 10));
    }

    @Test
    public void subtractTest() {
        Vector2D a = new Vector2D(1, 2);
        Vector2D b = new Vector2D(4, 8);
        assertEquals(a.subtract(b), new Vector2D(-3, -6));
    }

    @Test
    public void oppositeTest() {
        Vector2D a = new Vector2D(1, 2);
        assertEquals(a.opposite(), new Vector2D(-1, -2));
    }
}
