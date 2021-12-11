package agh.ics.oop;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class SimulationEngine implements IEngine, Runnable{
    private ArrayList<MoveDirection> moves;
    private IWorldMap map;
    private Map<Vector2d, Animal> animals = new LinkedHashMap<>();

    public SimulationEngine(ArrayList<MoveDirection> moves, IWorldMap map, Vector2d[] initialPositions) {
        this.moves = moves;
        this.map = map;
        for (Vector2d position : initialPositions) {
            Animal a = new Animal(map, position);
            if (map.place(a)) {
                animals.put(position, a);
            }
        }
    }

    @Override
    public void run() {
        int moveInd = 0;
        System.out.println(map);
        while (moveInd < this.moves.size()){
            for (Map.Entry<Vector2d, Animal> entry : this.animals.entrySet()) {
                entry.getValue().move(this.moves.get(moveInd));
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                moveInd++;
                if (moveInd >= this.moves.size()) {
                    break;
                }
                System.out.println(map);
            }
        }
    }
}
