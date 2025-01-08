package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

public class NinjaAnt extends Ant {
    private int damage;

    public NinjaAnt() {
        super(1);
        this.foodCost = 6;
        this.doesAntBlocks = false;
        this.damage = 1;
    }

    @Override
    public void action(AntColony colony) {
        Bee[] bees = this.place.getBees();
        
        for (Bee bee : bees) {
            bee.reduceArmor(this.damage);
        }
    }
}
