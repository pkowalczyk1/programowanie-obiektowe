package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    public void equalsTest() {
        Vector2d a = new Vector2d(1, 2);
        Vector2d b = new Vector2d(1, 2);
        Vector2d c = new Vector2d(2, 5);
        assertEquals(a, b);
        assertEquals(b, a);
        assertNotEquals(a, c);
        assertNotEquals(c, a);
    }

    @Test
    public void toStringTest() {
        Vector2d a = new Vector2d(1, 2);
        assertEquals(a.toString(), "(1, 2)");
    }

    @Test
    public void precedesTest() {
        Vector2d a = new Vector2d(1, 2);
        Vector2d b = new Vector2d(4, 8);
        assertTrue(a.precedes(b));
        assertFalse(b.precedes(a));
    }

    @Test
    public void followsTest() {
        Vector2d a = new Vector2d(1, 2);
        Vector2d b = new Vector2d(4, 8);
        assertTrue(b.follows(a));
        assertFalse(a.follows(b));
    }

    @Test
    public void upperRightTest() {
        Vector2d a = new Vector2d(1, 2);
        Vector2d b = new Vector2d(4, 8);
        Vector2d c = new Vector2d(7, 2);
        assertEquals(a.upperRight(b), b);
        assertEquals(b.upperRight(a), b);
        assertEquals(b.upperRight(c), new Vector2d(7, 8));
        assertEquals(c.upperRight(b), new Vector2d(7, 8));
    }

    @Test
    public void lowerLeftTest() {
        Vector2d a = new Vector2d(1, 2);
        Vector2d b = new Vector2d(4, 8);
        Vector2d c = new Vector2d(7, 2);
        assertEquals(a.lowerLeft(b), a);
        assertEquals(b.lowerLeft(a), a);
        assertEquals(c.lowerLeft(b), new Vector2d(4, 2));
        assertEquals(b.lowerLeft(c), new Vector2d(4, 2));
    }

    @Test
    public void addTest() {
        Vector2d a = new Vector2d(1, 2);
        Vector2d b = new Vector2d(4, 8);
        assertEquals(a.add(b), new Vector2d(5, 10));
        assertEquals(b.add(a), new Vector2d(5, 10));
    }

    @Test
    public void subtractTest() {
        Vector2d a = new Vector2d(1, 2);
        Vector2d b = new Vector2d(4, 8);
        assertEquals(a.subtract(b), new Vector2d(-3, -6));
    }

    @Test
    public void oppositeTest() {
        Vector2d a = new Vector2d(1, 2);
        assertEquals(a.opposite(), new Vector2d(-1, -2));
    }
}
