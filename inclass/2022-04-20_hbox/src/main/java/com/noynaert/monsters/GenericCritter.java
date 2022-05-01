package com.noynaert.monsters;
/**
 * The generic critter class is intended just for testing.
 *
 * Generic characters are only for testing.  They may be set up to be
 */
public class GenericCritter extends Critter {

    //this constructor may be used to create a dead or nearly-dead critter.
    public GenericCritter(double health){
        super("a generic critter","???");
        setHealth(health);
    }
    @Override
    public void attack() {
        setAttackEffectiveness(0.2);
        setAttackMessage("Attacks generically");
    }
}
