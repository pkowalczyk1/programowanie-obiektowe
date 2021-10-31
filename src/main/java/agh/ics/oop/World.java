package agh.ics.oop;
import java.util.ArrayList;
import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        Animal lion = new Animal();
        OptionsParser parser = new OptionsParser();
        ArrayList<MoveDirection> steps = parser.parse(args);
        for (MoveDirection step : steps) {
            lion.move(step);
        }
        out.println(lion);
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
