package ants;

import core.Ant;
import core.AntColony;

public class ScubaThrowerAnt extends Ant {
    public ScubaThrowerAnt() {
        super(1);
        this.foodCost = 5;
        this.watersafe = true;
    }

    @Override
    public void action(AntColony colony) {

    }
}
