package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

import java.util.ArrayList;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
//        ArrayList<MoveDirection> directions = new OptionsParser().parse(args);
//        IWorldMap map = new RectangularMap(10, 5);
//        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//        try {
//            GrassField map = new GrassField(10);
//            Vector2d[] positions = {new Vector2d(15, 4), new Vector2d(10, 13)};
//            ArrayList<MoveDirection> directions = new OptionsParser().parse(args);
//            IEngine engine = new SimulationEngine(directions, map, positions);
//            engine.run();
//        }
//        catch (IllegalArgumentException ex) {
//            out.println(ex);
//        }
        Application.launch(App.class, args);
    }
}
