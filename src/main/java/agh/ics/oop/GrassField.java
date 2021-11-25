package agh.ics.oop;

import java.lang.Math;
import java.util.LinkedHashMap;
import java.util.Map;

public class GrassField extends AbstractWorldMap {
    private Map<Vector2d, Grass> fields = new LinkedHashMap<>();

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
        }
    }

    public Vector2d findRightUpper() {
        Vector2d rightUp = new Vector2d((int) (-2 * Math.pow(10, 9)), (int) (-2 * Math.pow(10, 9)));
        for (Map.Entry<Vector2d, Animal> entry : this.animals.entrySet()) {
            rightUp = rightUp.upperRight(entry.getKey());
        }

        for (Map.Entry<Vector2d, Grass> entry : this.fields.entrySet()) {
            rightUp = rightUp.upperRight(entry.getKey());
        }

        return rightUp;
    }

    public Vector2d findLeftLower() {
        Vector2d leftLow = new Vector2d((int) (2 * Math.pow(10, 9)), (int) (2 * Math.pow(10, 9)));
        for (Map.Entry<Vector2d, Animal> entry : this.animals.entrySet()) {
            leftLow = leftLow.lowerLeft(entry.getKey());
        }

        for (Map.Entry<Vector2d, Grass> entry : this.fields.entrySet()) {
            leftLow = leftLow.lowerLeft(entry.getKey());
        }

        return leftLow;
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
}
