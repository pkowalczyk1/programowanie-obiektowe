package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static java.lang.System.out;

public class App extends Application implements IPositionChangeObserver {
    private AbstractWorldMap map;
    private final GridPane gridPane = new GridPane();
    private SimulationEngine engine;
    private int moveDelay;

    @Override
    public void init() {
        try {
            this.map = new GrassField(5);
            Vector2d[] positions = {new Vector2d(4, 4), new Vector2d(5, 2)};
            ArrayList<MoveDirection> directions = new OptionsParser().parse(getParameters().getRaw().toArray(new String[0]));
            this.engine = new SimulationEngine(directions, map, positions);
        }
        catch (IllegalArgumentException ex) {
            out.println(ex);
        }
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Platform.runLater(() -> {
            try {
                makeGrid();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        for (Animal animal : map.getAnimals().values()) {
            animal.addObserver(this);
        }

        makeGrid();

        Scene scene = new Scene(gridPane, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();

        Thread thread = new Thread(engine);
        thread.start();
    }

    private void makeGrid() throws FileNotFoundException {
        gridPane.setGridLinesVisible(false);
        gridPane.getChildren().clear();
        gridPane.getColumnConstraints().clear();
        gridPane.getRowConstraints().clear();

        Vector2d leftLower = this.map.findLeftLower();
        Vector2d rightUpper = this.map.findRightUpper();
        Label label0 = new Label("y/x");
        gridPane.add(label0, 0, 0, 1, 1);
        gridPane.getColumnConstraints().add(new ColumnConstraints(50));
        gridPane.getRowConstraints().add(new RowConstraints(50));
        GridPane.setHalignment(label0, HPos.CENTER);
        gridPane.setGridLinesVisible(true);

        for (int i = leftLower.x; i<= rightUpper.x; i++) {
            Label label = new Label(String.valueOf(i));
            gridPane.add(label, i - leftLower.x + 1, 0, 1, 1);
            gridPane.getColumnConstraints().add(new ColumnConstraints(50));
            GridPane.setHalignment(label, HPos.CENTER);
        }

        for (int i = leftLower.y; i<= rightUpper.y; i++) {
            Label label = new Label(String.valueOf(i));
            gridPane.add(label, 0, rightUpper.y - i + 1, 1, 1);
            gridPane.getRowConstraints().add(new RowConstraints(50));
            GridPane.setHalignment(label, HPos.CENTER);
        }

        for (int i = leftLower.x; i<= rightUpper.x; i++) {
            for (int j = leftLower.y; j<= rightUpper.y; j++) {
                if (map.objectAt(new Vector2d(i, j)) != null) {
                    VBox vBox = new GuiElementBox((IWorldMapElement) map.objectAt(new Vector2d(i, j))).getVBox();
                    gridPane.add(vBox, i - leftLower.x + 1, rightUpper.y - j + 1, 1, 1);
                    GridPane.setHalignment(vBox, HPos.CENTER);
                }
            }
        }
    }
}
