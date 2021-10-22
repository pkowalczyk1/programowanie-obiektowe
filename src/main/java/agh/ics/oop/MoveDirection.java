package agh.ics.oop;

enum MoveDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public String toString() {
        return switch (this) {
            case NORTH -> "Polnoc";
            case EAST -> "Wschod";
            case SOUTH -> "Poludnie";
            case WEST -> "Zachod";
        };
    }

    public MoveDirection next() {
        return switch (this) {
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }

    public MoveDirection previous() {
        return switch (this) {
            case NORTH -> WEST;
            case EAST -> NORTH;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
        };
    }

    public Vector2D toUnitVector() {
        return switch (this) {
            case NORTH -> new Vector2D(0, 1);
            case EAST -> new Vector2D(1, 0);
            case SOUTH -> new Vector2D(0, -1);
            case WEST -> new Vector2D(-1, 0);
        };
    }
}
