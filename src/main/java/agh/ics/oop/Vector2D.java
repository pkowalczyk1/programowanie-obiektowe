package agh.ics.oop;
import static java.lang.Math.max;
import static java.lang.Math.min;

class Vector2D {
    final public int x;
    final public int y;
    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    public boolean precedes(Vector2D other) {
        return this.x <= other.x && this.y <= other.y;
    }

    public boolean follows(Vector2D other) {
        return this.x >= other.x && this.y >= other.y;
    }

    public Vector2D upperRight(Vector2D other) {
        return new Vector2D(max(this.x, other.x), max(this.y, other.y));
    }

    public Vector2D lowerLeft(Vector2D other) {
        return new Vector2D(min(this.x, other.x), min(this.y, other.y));
    }

    public Vector2D add(Vector2D other) {
        return new Vector2D(this.x + other.x, this.y + other.y);
    }

    public Vector2D subtract(Vector2D other) {
        return new Vector2D(this.x - other.x, this.y - other.y);
    }

    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Vector2D))
            return false;
        Vector2D that = (Vector2D) other;
        return that.x == this.x && that.y == this.y;
    }

    public Vector2D opposite() {
        return new Vector2D(-1 * this.x, -1 * this.y);
    }
}
