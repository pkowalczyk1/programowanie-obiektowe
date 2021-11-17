package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private final int width;
    private final int height;
    private List<Animal> animals = new ArrayList<>();

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(new Vector2d(0, 0), new Vector2d(width, height));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.x >= 0 && position.x <= width && position.y >= 0 && position.y <= height && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (animal.getPosition().x < 0 || animal.getPosition().x > width || animal.getPosition().y < 0 || animal.getPosition().y > height) {
            return false;
        }
        if (!isOccupied(animal.getPosition())) {
            animals.add(animal);
            return true;
        }

        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) return true;
        }

        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) return animal;
        }

        return null;
    }
}
