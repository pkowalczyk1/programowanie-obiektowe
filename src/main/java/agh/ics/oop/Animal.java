package agh.ics.oop;

import agh.ics.oop.gui.App;

import java.util.ArrayList;
import java.util.List;

public class Animal implements IWorldMapElement {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);
    private IWorldMap map;
    private List<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(IWorldMap map) {
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.position = initialPosition;
        this.map = map;
    }

    public String toString() {
         return switch(orientation) {
             case NORTH -> "N";
             case SOUTH -> "S";
             case EAST -> "E";
             case WEST -> "W";
         };
    }

    public Vector2d getPosition() {
        return this.position;
    }

    public MapDirection getOrientation() {
        return this.orientation;
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> {
                this.orientation = this.orientation.next();
                positionChanged(this.position, this.position);
            }
            case LEFT -> {
                this.orientation = this.orientation.previous();
                positionChanged(this.position, this.position);
            }
            case FORWARD -> {
                Vector2d oldPosition = this.position;
                if (map.canMoveTo(position.add(orientation.toUnitVector()))) {
                    position = position.add(orientation.toUnitVector());
                    positionChanged(oldPosition, this.position);
                }
            }
            case BACKWARD -> {
                Vector2d oldPosition = this.position;
                if (map.canMoveTo(position.subtract(orientation.toUnitVector()))) {
                    position = position.subtract(orientation.toUnitVector());
                    positionChanged(oldPosition, this.position);
                }
            }
        }
    }

    public void addObserver(IPositionChangeObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        this.observers.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer : this.observers) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    public String getPath() {
        return switch (orientation) {
            case NORTH -> "src\\main\\resources\\up.png";
            case EAST -> "src\\main\\resources\\right.png";
            case WEST -> "src\\main\\resources\\left.png";
            case SOUTH -> "src\\main\\resources\\down.png";
        };
    }
}
