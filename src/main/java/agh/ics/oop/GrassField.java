package agh.ics.oop;

import java.util.ArrayList;
import java.lang.Math;

public class GrassField extends AbstractWorldMap {
    private ArrayList<Grass> fields = new ArrayList<>();

    public GrassField(int numberOfFields) {
        for (int i=0; i<numberOfFields; i++) {
            int x = 0, y = 0;
            boolean added = false;
            while (!added) {
                x = (int) (Math.random() * Math.sqrt(10 * numberOfFields));
                y = (int) (Math.random() * Math.sqrt(10 * numberOfFields));
                added = true;
                for (Grass field : this.fields) {
                    if (field.getPosition().equals(new Vector2d(x, y))) {
                        added = false;
                        break;
                    }
                }
            }

            Grass newField = new Grass(new Vector2d(x, y));
            this.fields.add(newField);
        }
    }

    public Vector2d findRightUpper() {
        Vector2d rightUp = new Vector2d((int) (-2 * Math.pow(10, 9)), (int) (-2 * Math.pow(10, 9)));
        for (Animal animal : this.animals) {
            rightUp = rightUp.upperRight(animal.getPosition());
        }

        for (Grass field : this.fields) {
            rightUp = rightUp.upperRight(field.getPosition());
        }

        return rightUp;
    }

    public Vector2d findLeftLower() {
        Vector2d leftLow = new Vector2d((int) (2 * Math.pow(10, 9)), (int) (2 * Math.pow(10, 9)));
        for (Animal animal : this.animals) {
            leftLow = leftLow.lowerLeft(animal.getPosition());
        }

        for (Grass field : this.fields) {
            leftLow = leftLow.lowerLeft(field.getPosition());
        }

        return leftLow;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (super.isOccupied(position)) {
            return true;
        }

        for (Grass field : this.fields) {
            if (field.getPosition().equals(position)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object x = super.objectAt(position);

        if (x != null) {
            return x;
        }

        for (Grass field : this.fields) {
            if (field.getPosition().equals(position)) return field;
        }

        return null;
    }
}
