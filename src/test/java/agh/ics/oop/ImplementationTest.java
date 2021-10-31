package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ImplementationTest {
    @Test
    public void movementTest() {
        Animal a = new Animal();
        a.move(MoveDirection.FORWARD);
        a.move(MoveDirection.LEFT);
        a.move(MoveDirection.BACKWARD);
        a.move(MoveDirection.LEFT);
        a.move(MoveDirection.FORWARD);
        a.move(MoveDirection.FORWARD);
        a.move(MoveDirection.FORWARD);
        a.move(MoveDirection.FORWARD);
        a.move(MoveDirection.LEFT);
        assertEquals(new Vector2d(3, 0), a.getPosition());
        assertEquals(MapDirection.EAST, a.getOrientation());

        Animal b = new Animal();
        b.move(MoveDirection.BACKWARD);
        b.move(MoveDirection.BACKWARD);
        b.move(MoveDirection.BACKWARD);
        assertNotEquals(new Vector2d(2, -1), b.getPosition());
        assertEquals(new Vector2d(2, 0), b.getPosition());
        b.move(MoveDirection.LEFT);
        b.move(MoveDirection.FORWARD);
        b.move(MoveDirection.FORWARD);
        b.move(MoveDirection.FORWARD);
        assertNotEquals(new Vector2d(-1, 0), b.getPosition());
        assertEquals(new Vector2d(0, 0), b.getPosition());
    }



    @Test
    public void parserTest() {
        OptionsParser parser = new OptionsParser();
        String[] args = {"f", "forward", "b", "backward", "r", "right", "l", "left"};
        ArrayList<MoveDirection> parsed;
        parsed = parser.parse(args);
        ArrayList<MoveDirection> corr_parsed = new ArrayList<>();
        corr_parsed.add(MoveDirection.FORWARD);
        corr_parsed.add(MoveDirection.FORWARD);
        corr_parsed.add(MoveDirection.BACKWARD);
        corr_parsed.add(MoveDirection.BACKWARD);
        corr_parsed.add(MoveDirection.RIGHT);
        corr_parsed.add(MoveDirection.RIGHT);
        corr_parsed.add(MoveDirection.LEFT);
        corr_parsed.add(MoveDirection.LEFT);
        assertEquals(corr_parsed, parsed);
    }
}
