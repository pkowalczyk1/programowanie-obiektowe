package agh.ics.oop;

import java.util.ArrayList;

public class OptionsParser {
    public ArrayList<MoveDirection> parse(String[] args) {
        ArrayList<MoveDirection> result = new ArrayList<>();
        for (String arg : args) {
            switch (arg) {
                case "f", "forward" -> result.add(MoveDirection.FORWARD);
                case "b", "backward" -> result.add(MoveDirection.BACKWARD);
                case "r", "right" -> result.add(MoveDirection.RIGHT);
                case "l", "left" -> result.add(MoveDirection.LEFT);
            }
        }

        return result;
    }
}
