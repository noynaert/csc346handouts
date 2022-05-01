package com.noynaert.monsters;

public class GiantRat extends Critter{
    public GiantRat(){
        super("Giant Rat", 50.0, 0.50, 1.0, .90, "\uD83D\uDC00");
        setNoDefenseMessage("Cleans its paws");
        setChar("\uD83D\uDC00");
    }
    @Override
    public void attack() {
        setAttackMessage("bites");
        setAttackEffectiveness(0.25);
    }
}
