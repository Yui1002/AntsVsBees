package ants;

import core.Ant;
import core.AntColony;
import core.Bee;
import core.Containing;
import core.Insect;

public class BodyguardAnt extends Ant implements Containing{
    private Ant antContaind;

    public BodyguardAnt() {
        super(2);
        this.foodCost = 4;
        this.antContaind = null;
    }
 
    @Override
    public void action(AntColony colony) {
        // get antContained
        // if there is no antContained, do nothing
        if (this.antContaind == null) return;
        
        // as long as armor is more than 0, it can shield contained ant
        // otherwise contained ant performs
        if (this.armor <= 0) {
            this.antContaind.action(colony);
        } else {
            // blocks bee's movement (shield)
            this.setDoesAntBlocks(true);
        }
    }

    public Ant getAntContained() {
        return this.antContaind;
    }

    @Override
    public boolean add(Insect insect) {
        if (insect instanceof Bee) {
            return false;
        }

        // if bodyguard ant already contains ant
        if (this.antContaind != null) {
            return false;
        }

        // set antContained to ant you want to add
        this.antContaind = (Ant)insect;
        return true;
    }

    @Override
    public boolean remove() {

        // if there is no ant contained
        if (this.antContaind == null) {
            return false;
        }

        this.antContaind = null;
        return true;
    }

    @Override
    public Insect get() {
        return this.antContaind;
    }
    
}
