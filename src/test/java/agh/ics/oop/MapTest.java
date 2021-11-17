package agh.ics.oop;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

public class MapTest {
    @Test
    public void borderTest() {
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2, 0), new Vector2d(3, 5), new Vector2d(0, 2), new Vector2d(10, 4)};
        String[] args = {"r", "f", "l", "r", "r", "f", "f", "f", "f"};
        ArrayList<MoveDirection> moves = (new OptionsParser()).parse(args);
        IEngine engine = new SimulationEngine(moves, map, positions);
        Animal a = (Animal) map.objectAt(positions[0]);
        Animal b = (Animal) map.objectAt(positions[1]);
        Animal c = (Animal) map.objectAt(positions[2]);
        Animal d = (Animal) map.objectAt(positions[3]);
        engine.run();
        assertEquals(MapDirection.SOUTH, a.getOrientation());
        assertEquals(MapDirection.EAST, d.getOrientation());
        assertEquals(MapDirection.WEST, c.getOrientation());
        assertNotEquals(new Vector2d(2, -1), a.getPosition());
        assertNotEquals(new Vector2d(3, 6), b.getPosition());
        assertNotEquals(new Vector2d(-1, 2), c.getPosition());
        assertNotEquals(new Vector2d(11, 4), d.getPosition());
    }

    @Test
    public void twoOnSameSpotTest() {
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2, 3), new Vector2d(3, 3)};
        String[] args = {"r", "l", "f"};
        ArrayList<MoveDirection> moves = (new OptionsParser()).parse(args);
        IEngine engine = new SimulationEngine(moves, map, positions);
        Animal a = (Animal) map.objectAt(positions[0]);
        engine.run();
        assertNotEquals(new Vector2d(3, 3), a.getPosition());
    }
    
    @Test
    public void movingTest() {
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        String[] args = {"f", "backward", "right", "l", "f", "forward", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        ArrayList<MoveDirection> moves = (new OptionsParser()).parse(args);
        IEngine engine = new SimulationEngine(moves, map, positions);
        Animal a = (Animal) map.objectAt(positions[0]);
        Animal b = (Animal) map.objectAt(positions[1]);
        engine.run();
        assertEquals(new Vector2d(2, 0), a.getPosition());
        assertEquals(new Vector2d(3, 5), b.getPosition());
        assertEquals(MapDirection.SOUTH, a.getOrientation());
        assertEquals(MapDirection.NORTH, b.getOrientation());
    }
}
