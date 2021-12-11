package agh.ics.oop;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    @Test
    public void movementTest() {
        IWorldMap map_a = new RectangularMap(4, 4);
        Animal a = new Animal(map_a);
        map_a.place(a);
        a.move(MoveDirection.FORWARD);
        a.move(MoveDirection.LEFT);
        a.move(MoveDirection.BACKWARD);
        a.move(MoveDirection.LEFT);
        a.move(MoveDirection.FORWARD);
        a.move(MoveDirection.FORWARD);
        a.move(MoveDirection.FORWARD);
        a.move(MoveDirection.FORWARD);
        a.move(MoveDirection.LEFT);
        assertEquals(a.getPosition(), new Vector2d(3, 0));
        assertEquals(a.getOrientation(), MapDirection.EAST);

        IWorldMap map_b = new RectangularMap(4, 4);
        Animal b = new Animal(map_b);
        map_b.place(b);
        b.move(MoveDirection.BACKWARD);
        b.move(MoveDirection.BACKWARD);
        b.move(MoveDirection.BACKWARD);
        assertNotEquals(b.getPosition(), new Vector2d(2, -1));
        assertEquals(b.getPosition(), new Vector2d(2, 0));
        b.move(MoveDirection.LEFT);
        b.move(MoveDirection.FORWARD);
        b.move(MoveDirection.FORWARD);
        b.move(MoveDirection.FORWARD);
        assertNotEquals(b.getPosition(), new Vector2d(-1, 0));
        assertEquals(b.getPosition(), new Vector2d(0, 0));
    }

    @Test
    public void parserTest() {
        OptionsParser parser = new OptionsParser();
        String[] args1 = {"forward", "f", "left", "l", "backward", "b", "right", "r"};
        ArrayList<MoveDirection> parsed = parser.parse(args1);
        ArrayList<MoveDirection> corr_moves = new ArrayList<>();
        corr_moves.add(MoveDirection.FORWARD);
        corr_moves.add(MoveDirection.FORWARD);
        corr_moves.add(MoveDirection.LEFT);
        corr_moves.add(MoveDirection.LEFT);
        corr_moves.add(MoveDirection.BACKWARD);
        corr_moves.add(MoveDirection.BACKWARD);
        corr_moves.add(MoveDirection.RIGHT);
        corr_moves.add(MoveDirection.RIGHT);
        assertDoesNotThrow(() -> parser.parse(args1));
        assertEquals(parsed, corr_moves);
        String[] args2 = {"forward", "f", "left", "l", "backward", "b", "right", "r", "t"};
        assertThrows(IllegalArgumentException.class, () -> parser.parse(args2));
    }
}
