package agh.ics.oop;
import java.lang.reflect.Array;
import java.util.ArrayList;
import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        ArrayList<MoveDirection> directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
    }

    public static ArrayList<MoveDirection> enumList(String[] args) {
        ArrayList<MoveDirection> result = new ArrayList<>();
        for (String arg : args) {
            switch(arg) {
                case "f" -> result.add(MoveDirection.FORWARD);
                case "b" -> result.add(MoveDirection.BACKWARD);
                case "r" -> result.add(MoveDirection.RIGHT);
                case "l" -> result.add(MoveDirection.LEFT);
            }
        }
        return result;
    }

    public static void run(ArrayList<MoveDirection> args) {
        for (MoveDirection arg : args) {
            switch (arg) {
                case FORWARD -> out.println("Zwierzak idzie do przodu");
                case BACKWARD -> out.println("Zwierzak idzie do tyłu");
                case RIGHT -> out.println("Zwierzak idzie w prawo");
                case LEFT -> out.println("Zwierzak idzie w lewo");
            }
        }
    }
}
