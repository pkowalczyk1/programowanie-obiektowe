package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{
    private ArrayList<MoveDirection> moves;
    private IWorldMap map;
    private List<Animal> animals = new ArrayList<>();

    public SimulationEngine(ArrayList<MoveDirection> moves, IWorldMap map, Vector2d[] initialPositions) {
        this.moves = moves;
        this.map = map;
        for (Vector2d position : initialPositions) {
            Animal a = new Animal(map, position);
            if (map.place(a)) {
                animals.add(a);
            }
        }
    }

    @Override
    public void run() {
        int animalInd = 0;
//        System.out.println(map);
        for (MoveDirection move : moves) {
            animals.get(animalInd).move(move);
            animalInd += 1;
            animalInd %= animals.size();
//            System.out.println(map);
        }
    }
}
