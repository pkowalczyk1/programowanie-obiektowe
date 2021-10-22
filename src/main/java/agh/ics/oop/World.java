package agh.ics.oop;
import java.util.ArrayList;
import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
//        out.println("Start");
//        run(enumList(args));
//        out.println("Stop");
//        Vector2D position1 = new Vector2D(1,2);
//        System.out.println(position1);
//        Vector2D position2 = new Vector2D(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));
        out.println(MoveDirection.NORTH.next());
        out.println(MoveDirection.EAST.previous());
        out.println(MoveDirection.SOUTH.toUnitVector());
        out.println(MoveDirection.WEST);
    }

    public static ArrayList<Direction> enumList(String[] args) {
        ArrayList<Direction> result = new ArrayList<Direction>();
        for (String arg : args) {
            switch(arg) {
                case "f" -> result.add(Direction.FORWARD);
                case "b" -> result.add(Direction.BACKWARD);
                case "r" -> result.add(Direction.RIGHT);
                case "l" -> result.add(Direction.LEFT);
            }
        }
        return result;
    }

    public static void run(ArrayList<Direction> args) {
        for (Direction arg : args) {
            switch (arg) {
                case FORWARD -> out.println("Zwierzak idzie do przodu");
                case BACKWARD -> out.println("Zwierzak idzie do tyłu");
                case RIGHT -> out.println("Zwierzak idzie w prawo");
                case LEFT -> out.println("Zwierzak idzie w lewo");
            }
        }
    }
}
