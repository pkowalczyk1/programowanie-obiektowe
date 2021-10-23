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
        out.println(MapDirection.NORTH.next());
        out.println(MapDirection.EAST.previous());
        out.println(MapDirection.SOUTH.toUnitVector());
        out.println(MapDirection.WEST);
    }

    public static ArrayList<MoveDirection> enumList(String[] args) {
        ArrayList<MoveDirection> result = new ArrayList<MoveDirection>();
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
