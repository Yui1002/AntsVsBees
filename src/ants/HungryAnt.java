package ants;

import java.util.ArrayList;

import core.Ant;
import core.AntColony;
import core.Bee;

public class HungryAnt extends Ant {
    private int digestingTime;

    public HungryAnt() {
        super(1);
        this.foodCost = 4;
        this.digestingTime = 0; // ant can kill bee immediately
    }

    @Override
    public void action(AntColony colony) {
        if (this.digestingTime > 0) { // can't kill, need to digest
            this.digestingTime--;
        } else {
            ArrayList<Bee> bees = colony.getAllBees();
            if (!bees.isEmpty()) {
                int random = (int)(Math.random() * (bees.size() -1)) + 1;
                Bee bee = bees.get(random);
                bee.reduceArmor(bee.getArmor());
                this.digestingTime = 4;
            }
        }
    }
}
