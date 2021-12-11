package agh.ics.oop.gui;

import agh.ics.oop.IWorldMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    private Image image;
    private ImageView imageView;
    private Label label;
    private VBox vBox;

    public GuiElementBox(IWorldMapElement element) throws FileNotFoundException {
        image = new Image(new FileInputStream(element.getPath()));
        imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        label = new Label(element.getPosition().toString());
        vBox = new VBox(imageView, label);
        vBox.setAlignment(Pos.CENTER);
    }

    public VBox getVBox() {
        return this.vBox;
    }
}
