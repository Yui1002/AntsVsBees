package ants;

import core.Ant;
import core.AntColony;

public class WallAnt extends Ant {

    public WallAnt() {
        super(4);
        this.foodCost = 4;
    }

    @Override
    public void action(AntColony colony) {}
}
