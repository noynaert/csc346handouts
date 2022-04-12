package edu.missouriwestern.csc346.monsters;

import java.util.Objects;

/**
 * Critter is the super class for monsters.
 * Generally getters are public.
 * Setters are mostly protected because only things in this package should use them.
 * Some are private and/or final if they are vital to game balance
 *
 * Do not print from a critter.  Only store messages in the strings.  Do not assume
 * that System.out will be available.
 *
 * Fields:
 *
 * critterName:String  -- Should be no more than 10 characters
 * imageCharacter:String  -- This should be a single Unicode character, although most of the
 *                   codes will deconstruct into two characters.
 *                   See https://www.alt-codes.net/animal-symbols.php  🦖
 *
 * weight:double  -- Weight in kg.  An adult human would be 100.0.
 *                   Weight was supposed to factor into survivability, but it is not
 *                   really used in the current version
 * stamina:double -- 1.0 for a healthy adult human.  Not really used in current except to set starting health.
 * health:double  -- 1.0 is 100% health.  It cannot be over 100% at the start of the game
 *                   and it should not increase unless the game incorporates recovery
 *                   Anything less than 0.0 is dead
 *                   Essentially, health is the percentage of life.
 * aggressiveness:double -- probability the critter will attack in a given round
 *                          Must be 0.0 to 1.0.  1.00 would be 100% chance of attack
 *
 *                 ATTACKS:
 *
 *                 Attack stats should be set in the attack method.  A critter's attack should
 *                 call setAttackMessage(String) and setAttackEffectiveness(double).
 *
 * attackMessage:String -- This message must be set by the concrete critter on each round.
 *                         A complex character might attack with different weapons, or
 *                         they might use the same weapon differently.
 * attackEffectiveness:double How effective was an attack this round?  0.0 is an ineffective hit.
 *                            Should be set in attack by calling setAttackEffectiveness(double)
 *                            1.0 is a kill shot and should be very rare.
 *                            A normal attack with fists would be about 0.02.
 *                            A sword strike by an ordinary human would be about 0.25.
 *                            A full attack by an adult tRex might be a 1.0 attack or greater.
 *                            The effectiveness will be reduced by a random factor in game play.
 *
 *                    DEFENSE
 *
 *                    Critters do not have to have a defense.  Generally only complex critters will have them.
 *                    If a critters has a defense it should implement the DEFENSE interface.
 *                    Critters are initialized with an empty string for their attack message.
 *                    (to be honest, defense is not working exactly as intended, and the having
 *                    a non-empty defense string is what triggers calling defend() )
 *
 *                    Defend works pretty much like attack.  There is a message and an effectiveness.
 *                    Defensive techniques should be very weak for game balance.
 *
 *  defenseEffectiveness:double
 *  defenseMessage:String
 *
 */
abstract public class Critter {
    private String critterName;
    private double weight;
    private double stamina;
    private double health;
    private double aggressiveness;
    private String attackMessage;
    private double attackEffectiveness;
    private double defenseEffectiveness;
    private String defenseMessage = "";
    String imageCharacter;

    public Critter(String critterName, double weight, double stamina, double health, double aggressiveness, String imageCharacter) {
        setCritterName(critterName);
        setWeight(weight);
        setAggressiveness(aggressiveness);
        setStamina(stamina);
        setHealth(health * stamina);
        setImageCharacter(imageCharacter);
    }

    public Critter(String critterName, String imageCharacter){
        this(critterName, 100.0, 1.0, 1.0,1.0, imageCharacter);
    }

    protected void setCritterName(String critterName) {
        this.critterName = critterName;
    }

    protected void setWeight(double weight) {
        this.weight = weight;
    }

    protected void setStamina(double stamina) {
        this.stamina = stamina;
    }

    final protected void setHealth(double health) {
        if(health > 1.0){
            this.health=1.0;  //No unkillable characters.
        }else{
            this.health = health;
        }
    }

    final protected void setAggressiveness(double aggressiveness) {
        if (aggressiveness >= 0.0 && aggressiveness <= 1.0){
            this.aggressiveness = aggressiveness;
        }else{
            if(aggressiveness < 0.0)
                this.aggressiveness = 0.0;
            else
                this.aggressiveness = 1.0;
        }
    }

    protected void setAttackMessage(String attackMessage) {
        this.attackMessage = attackMessage;
    }

    protected void setAttackEffectiveness(double attackEffectiveness) {
        this.attackEffectiveness = attackEffectiveness;
    }

    protected void setImageCharacter(String imageCharacter) {
        this.imageCharacter = imageCharacter;
    }

    public String getCritterName() {
        return critterName;
    }

    public double getWeight() {
        return weight;
    }

    public double getStamina() {
        return stamina;
    }

    public double getHealth() {
        return health;
    }

    public double getAggressiveness() {
        return aggressiveness;
    }

    public String getAttackMessage() {
        return attackMessage;
    }

    public double getAttackEffectiveness() {
        return attackEffectiveness;
    }

    public String getImageCharacter() {
        return imageCharacter;
    }
    public double getDefenseEffectiveness() {
        return defenseEffectiveness;
    }

    public void setDefenseEffectiveness(double defenseEffectiveness) {
        this.defenseEffectiveness = defenseEffectiveness * .6 * Math.random();
    }

    public String getDefenseMessage() {
        return defenseMessage;
    }

    public void setDefenseMessage(String defenseMessage) {
        this.defenseMessage = defenseMessage;
    }

    final public boolean isDead(){
        return (health <= 0.0);
    }
    final public boolean isAlive(){
        return (health > 0.0);
    }

    /**
     * There is no field for noAttackMessage.  You must write a method that returns a message.
     *                     The critter may have only one message, or the method might switch
     *                     between several at random (or with regard to its health)
     * @return a message that completes a sentence that starts with the critter's name.  "does nothing." would work.
     */

    @Override
    public String toString() {
        String s = String.format("%10s\tHealth: %1.1f Stamina: %1.1f Weight: %1.1f Aggressiveness: %1.1f",
                critterName, health, stamina, weight, aggressiveness);
        return s;
    }
    /** This version does nothing.  If Defender is impemented it should override this. */
    public void defend(){
        setDefenseEffectiveness(0.0);
        setDefenseMessage("");
    }

    abstract protected String getNoAttackMessage();

    /**
     * Must call setAttackMessage() and setAttackEffectiveness()
     */
    abstract protected void attack();
}
