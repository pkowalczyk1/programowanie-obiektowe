package agh.ics.oop;

import java.util.LinkedHashMap;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d, Animal> animals = new LinkedHashMap<>();

    abstract Vector2d findRightUpper();
    abstract Vector2d findLeftLower();

    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(findLeftLower().subtract(new Vector2d(1, 1)), findRightUpper().add(new Vector2d(1, 1)));
    }

    public boolean canMoveTo(Vector2d position) {
        Object object = objectAt(position);
        return !(object instanceof Animal);
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            this.animals.put(animal.getPosition(), animal);
            animal.addObserver(this);
            return true;
        }

        return false;
    }

    public boolean isOccupied(Vector2d position) {
        return animals.get(position) != null;
    }

    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal moved = this.animals.get(oldPosition);
        this.animals.remove(oldPosition, moved);
        this.animals.put(newPosition, moved);
    }
}
