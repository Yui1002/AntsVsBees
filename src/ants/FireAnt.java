package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

public class FireAnt extends Ant {
    private int damage;

    public FireAnt() {
        super(1);
        this.foodCost = 4;
        this.damage = 3;
    }

    @Override
    public void action(AntColony colony) {
        this.armor = 0;

        // if its armor is less than or equal to 0
        if (this.armor <= 0) {
            // get all the bees in the same place 
            Bee[] bees = this.place.getBees();
            
            // for each bee
            for (Bee bee : bees) {
                // reduce armor 
                bee.reduceArmor(this.damage);
            }
        }
    }
}
