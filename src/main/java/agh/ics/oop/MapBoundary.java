package agh.ics.oop;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver{
    private final Comparator<Vector2d> comparatorX = new XComparator();
    private final Comparator<Vector2d> comparatorY = new YComparator();
    public SortedSet<Vector2d> animalsOrderedByX = new TreeSet<>(comparatorX);
    public SortedSet<Vector2d> animalsOrderedByY = new TreeSet<>(comparatorY);
    public SortedSet<Vector2d> grassOrderedByX = new TreeSet<>(comparatorX);
    public SortedSet<Vector2d> grassOrderedByY = new TreeSet<>(comparatorY);


    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        animalsOrderedByX.remove(oldPosition);
        animalsOrderedByY.remove(oldPosition);
        animalsOrderedByX.add(newPosition);
        animalsOrderedByY.add(newPosition);
    }
}
