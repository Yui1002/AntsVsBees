package ants;

import core.Ant;
import core.AntColony;



public class BodyguardAnt extends Ant {
    public BodyguardAnt() {
        super(2);
        this.foodCost = 4;
    }

    @Override
    public void action(AntColony colony) {
    }
    
}
