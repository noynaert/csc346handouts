package edu.missouriwestern.csc346.monsters;

/**
 * A ghost is effectively unkillable.  It is also totally harmless.
 * Ghosts are for testing purposes only, and should not be included in a regular contest.
 */

public class Ghost extends Critter{
    public Ghost(){
        super("Ghost", 0.0, Double.MAX_VALUE, 1.0, 0.50, "\uD83D\uDC7B");
    }
    @Override
    protected String getNoAttackMessage() {
        return "hovers ephemerally just out of reach()";
    }

    @Override
    protected void attack() {
        setAttackMessage("advances menacingly");
        setAttackEffectiveness(0.0);
    }
}
