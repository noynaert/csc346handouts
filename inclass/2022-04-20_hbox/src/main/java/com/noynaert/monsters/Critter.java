package com.noynaert.monsters;

/**
 *
 * Generally, setters are protected, but getters are public.  This allows the game driver to access information for display purposes.
 */

abstract public class Critter {
    private String critterName;  //should be no longer than 10 characters
    private double weight; //in KG
    private double stamina; //1.000 is a normal healthy human adult
    private double health;  //Normally 1.0 (i.e. 100%), unless character was injured in previous combat
                            //Anything less than 0.0 is dead
                            //I can't think of a good justification for over 1.0.
    private double aggressiveness;  // probability character will attack on a round.
                                    // must be in a range from 0.0 to 1.0.
                                    // 0.0 would mean never attacks.  1.0 would be always attack

    private String attackMessage;  //Should be set by the attack() method on each round by calling setAttackMessage(String)
    private String noAttackMessage = "Does not attack";//Message if player is not aggressive enough to attack this round

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

    public String getNoAttackMessage() {
        return noAttackMessage;
    }

    public void setNoAttackMessage(String noAttackMessage) {
        this.noAttackMessage = noAttackMessage;
    }

    private double attackEffectiveness;  //How effective was an attack this round?  0.0 is an ineffective hit.
                                         //Should be set in attack by calling setAttackEffectiveness(double)
                                         // 1.0 is a kill shot and should be very rare.
                                         // A normal attack with fists would be about 0.02.
                                         // A sword strike by an ordinary human would be about 0.25.
                                         // A full attack by an adult tRex might be a 1.0 attack.
    private double defenceEffectiveness = 0.0;  //Should only in defend() method
    private String noDefenseMessage = "does nothing to defend itself";

    public String getNoDefenseMessage() {
        return noDefenseMessage;
    }

    /** Generally this message should be called in the constructor of subclasses.  If it is not called,
     *  the default message is "does nothing to defend itself."
     * @param noDefenseMessage
     */
    public void setNoDefenseMessage(String noDefenseMessage) {
        this.noDefenseMessage = noDefenseMessage;
    }

    public double getDefenceEffectiveness() {
        return defenceEffectiveness;
    }

    public String getDefenseMessage() {
        return defenseMessage;
    }

    private String defenseMessage = "";  //Should only be set in defend() method
    private double damageReceived;       // How much damage was received in this round
    private String effectivenessMessage; // Message about how effective the attack was.  Set in Critter, but may be used by the main app.

    public double getAggressiveness() {
        return aggressiveness;
    }

    public void setAggressiveness(double aggressiveness) {
        if (aggressiveness >= 0.0 && aggressiveness <= 1.0){
            this.aggressiveness = aggressiveness;
        }else{
            if(aggressiveness < 0.0)
                this.aggressiveness = 0.0;
            else
                this.aggressiveness = 1.0;
        }
    }

    protected String imageCharacter;   //see https://www.alt-codes.net/animal-symbols.php


    protected void setChar(String imageCharacter){
        this.imageCharacter = imageCharacter;
    }

    public String getCritterName() {
        return critterName;
    }

    protected void setCritterName(String critterName) {
        this.critterName = critterName;
    }

    public double getWeight() {
        return weight;
    }

    protected void setWeight(double weight) {
        this.weight = weight;
    }

    public double getStamina() {
        return stamina;
    }

    protected void setStamina(double stamina) {
        this.stamina = stamina;
    }

    public double getHealth() {
        return health;
    }

    final protected void setHealth(double health) {
        if(health > 1.0){
            this.health=1.0;  //No unkillable characters.
        }else{
            this.health = health;
        }
    }

    public String getImageCharacter() {
        return imageCharacter;
    }

    public void setImageCharacter(String imageCharacter) {
        this.imageCharacter = imageCharacter;
    }

    @Override
    public String toString() {
        String s = String.format("%10s\tHealth: %1.1f Stamina: %1.1f Weight: %1.1f Aggressiveness: %1.1f",
                critterName, health, stamina, weight, aggressiveness);
        return s;
    }

    public String getAttackMessage() {
        return attackMessage;
    }

    /**
     * Called by the attack() method of the instance.
     * @param attackMessage  Something like "swings its sword" or "gives a ferocious growl and bites"
     */
    protected void setAttackMessage(String attackMessage) {
        this.attackMessage = attackMessage;
    }

    public double getAttackEffectiveness() {
        return attackEffectiveness;
    }

    /** Should only be called by this method during an attack. */
    protected void setAttackEffectiveness(double attackEffectiveness) {
        this.attackEffectiveness = attackEffectiveness * Math.random();

    }

    public double getDamageReceived() {
        return damageReceived;
    }

    public void setDamageReceived(double damageReceived) {
        this.damageReceived = damageReceived;
    }

    public String getEffectivenessMessage() {
        return effectivenessMessage;
    }

    public void setEffectivenessMessage(String effectivenessMessage) {
        this.effectivenessMessage = effectivenessMessage;
    }

    /** attack returns the effectivness of the attack
     *
     * Effectiveness is a real number.
     * As a guideline, 0.0 would be an ineffective attack.  1.0 would do about as much damage as a
     *      human can do without a weapon, for example with a solid fist punch.  A butterfly attack might be 0.00001 while
     *      the maximum attack might be 100.0.  This might be from something like a trex or alien
     *      with a blaster
     *
     *      Maybe negative effectiveness could be used for healing, but I have not thought threw
     *      how that might work in practice.
     *
     *      Should be calling MESSAGE TO SET ATTACK EFFECTIVENESS AND ATTACK MESSAGE
     */
    abstract public void attack();

    /**
     * @param defenceEffectiveness  Ranges from 0.0 to 1.0.  0.0 would be totally ineffective defense.  1.0 would be perfect defense.  In practice, defenses almost never work perfectly.  And for game balance, For game balance, defense is limited to 60% effectiveness by the super class setter
     */
    final public void setDefenceEffectiveness(double defenceEffectiveness) {
        this.defenceEffectiveness = defenceEffectiveness * .6 * Math.random();
    }


    public void setDefenseMessage(String defenseMessage) {
        this.defenseMessage = defenseMessage;
    }

    /** Any class that implements the Defender interface should @Override defend() */
    public void defend(){
        setDefenceEffectiveness(0.0);
        setDefenseMessage("");
    }

    final public boolean isDead(){
        return (health <= 0);
    }
    final public boolean isAlive(){
        return (health > 0);
    }

}
