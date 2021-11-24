package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap {
    private final int width;
    private final int height;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Vector2d findRightUpper() {
        return new Vector2d(width, height);
    }

    public Vector2d findLeftLower() {
        return new Vector2d(0, 0);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (position.x < 0 || position.x > width || position.y < 0 || position.y > height) return false;

        return super.canMoveTo(position);
    }
}
