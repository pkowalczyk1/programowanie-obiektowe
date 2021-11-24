package agh.ics.oop;

import java.util.ArrayList;

abstract class AbstractWorldMap implements IWorldMap {
    protected ArrayList<Animal> animals = new ArrayList<>();

    abstract Vector2d findRightUpper();
    abstract Vector2d findLeftLower();

    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(findLeftLower().subtract(new Vector2d(1, 1)), findRightUpper().add(new Vector2d(1, 1)));
    }

    public boolean canMoveTo(Vector2d position) {
        Object object = objectAt(position);
        if (object instanceof Animal) {
            return false;
        }

        return true;
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            this.animals.add(animal);
            return true;
        }

        return false;
    }

    public boolean isOccupied(Vector2d position) {
        for (Animal animal : this.animals) {
            if (animal.isAt(position)) return true;
        }

        return false;
    }

    public Object objectAt(Vector2d position) {
        for (Animal animal : this.animals) {
            if (animal.isAt(position)) return animal;
        }

        return null;
    }
}
