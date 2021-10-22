package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Vector2DTest {
    @Test
    public void equalsTest() {
        Vector2D a = new Vector2D(1, 2);
        Vector2D b = new Vector2D(1, 2);
        Vector2D c = new Vector2D(2, 5);
        assertTrue(a.equals(b));
        assertTrue(b.equals(a));
        assertFalse(a.equals(c));
        assertFalse(c.equals(a));
    }
}
