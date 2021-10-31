package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    public String toString() {
         return "Pozycja: " + this.position.toString() + ", orientacja: " + this.orientation.toString();
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
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> {
                this.position = this.position.add(this.orientation.toUnitVector());
                if (this.position.x > 4 || this.position.x < 0 || this.position.y > 4 || this.position.y < 0)
                    this.position = this.position.subtract(this.orientation.toUnitVector());
            }
            case BACKWARD -> {
                this.position = this.position.subtract(this.orientation.toUnitVector());
                if (this.position.x > 4 || this.position.x < 0 || this.position.y > 4 || this.position.y < 0)
                    this.position = this.position.add(this.orientation.toUnitVector());
            }
        }
    }
}
