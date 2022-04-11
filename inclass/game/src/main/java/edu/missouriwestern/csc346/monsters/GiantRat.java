package edu.missouriwestern.csc346.monsters;

public class GiantRat extends Critter{
    public GiantRat(){
        super("Giant Rat", 50.0, 0.50, 1.0, .90, "\uD83D\uDC00");
        setImageCharacter("\uD83D\uDC00");
    }

    @Override
    protected String getNoAttackMessage() {
        return "cleans its massive claws.";
    }

    @Override
    public void attack() {
        setAttackMessage("bites");
        setAttackEffectiveness(0.25);
    }
}
