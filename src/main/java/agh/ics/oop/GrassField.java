package agh.ics.oop;

import java.lang.Math;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class GrassField extends AbstractWorldMap {
    private Map<Vector2d, Grass> fields = new LinkedHashMap<>();
    private MapBoundary boundary = new MapBoundary();

    public GrassField(int numberOfFields) {
        for (int i=0; i<numberOfFields; i++) {
            int x = 0, y = 0;
            boolean added = false;
            while (!added) {
                x = (int) (Math.random() * Math.sqrt(10 * numberOfFields));
                y = (int) (Math.random() * Math.sqrt(10 * numberOfFields));
                added = true;
                if (this.fields.get(new Vector2d(x, y)) != null) {
                    added = false;
                }
            }

            Grass newField = new Grass(new Vector2d(x, y));
            this.fields.put(new Vector2d(x, y), newField);
            boundary.grassOrderedByX.add(newField.getPosition());
            boundary.grassOrderedByY.add(newField.getPosition());
        }
    }

    public Vector2d findRightUpper() {
        int x = max(boundary.animalsOrderedByX.last().x, boundary.grassOrderedByX.last().x);
        int y = max(boundary.animalsOrderedByY.last().y, boundary.grassOrderedByY.last().y);
        return new Vector2d(x, y);
    }

    public Vector2d findLeftLower() {
        int x = min(boundary.animalsOrderedByX.first().x, boundary.grassOrderedByX.first().x);
        int y = min(boundary.animalsOrderedByY.first().y, boundary.grassOrderedByY.first().y);
        return new Vector2d(x, y);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (super.isOccupied(position)) {
            return true;
        }

        return this.fields.get(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object x = super.objectAt(position);

        if (x != null) {
            return x;
        }

        return this.fields.get(position);
    }

    @Override
    public boolean place(Animal animal) {
        super.place(animal);
        animal.addObserver(boundary);
        boundary.animalsOrderedByX.add(animal.getPosition());
        boundary.animalsOrderedByY.add(animal.getPosition());
        return true;
    }
}
