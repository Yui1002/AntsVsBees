package ants;

import core.Ant;
import core.AntColony;
import core.Bee;
import core.Containing;
import core.Insect;

public class BodyguardAnt extends Ant implements Containing {
    private Ant antContained;

    public BodyguardAnt() {
        super(2);
        this.foodCost = 4;
        this.antContained = null;
    }

    @Override
    public void action(AntColony colony) {
    }

    @Override
    public boolean add(Insect insect) {
        /*
         * Check if bodyguard ant (this) already contains ant
         * If already contains, return false, else set return true
         */
        if (insect instanceof Bee) {
            //ideally throw error
            return false;
        }
        if (this.antContained != null) {
            //there is something already here
            return false;
        }
        this.antContained = (Ant)insect;
        return true;
    }

    @Override
    public boolean remove() {

        if (this.antContained == null) {
            // there is nothing to remove
            return false;
        }
        
        this.antContained = null;
        return true;
    }

    @Override
    public Insect get() {
        return this.antContained;
    }
    
}
