package agh.ics.oop;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Vector;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
//        ArrayList<MoveDirection> directions = new OptionsParser().parse(args);
//        IWorldMap map = new RectangularMap(10, 5);
//        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
        ArrayList<MoveDirection> directions = new OptionsParser().parse(args);
        RectangularMap map = new RectangularMap(10, 10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
    }
}
