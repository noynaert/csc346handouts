package com.noynaert.monsters;

/**
 * Humans have an occupation such as "Cook" or "Breserker."
 * Humans use weapons, although the weapon may be things like fists or
 * head-butts. Preferably there should be a variety of weapons relevant for that
 * profession
 *
 * All humans have a weight of 100 kg, stamina of 1.0 and health of 1.0
 * Humans must have a male and female character specified. The actual character
 * used is determined randomly.
 */

public abstract class Human extends Critter implements Defender {
    private Gender gender; // Gender is set randomly to Male or Female.
    private static String maleSymbol;
    private static String femaleSymbol;

    public Human(String occupation, double aggressiveness, String male, String female) {
        super(occupation, 100.0, 1.0, 1.0, aggressiveness, (Math.random() < 0.5 ? male : female));
        maleSymbol = male;
        femaleSymbol = female;
        if (Math.random() < .5)
            gender = Gender.FEMALE;
        else
            gender = Gender.MALE;

        setImageCharacter((gender == Gender.FEMALE) ? female : male);
    }

    @Override
    public String toString() {
        String result = getImageCharacter() + super.toString();
        return result;
    }

    public void setGender(Gender gender) {
        switch (gender) {
            case MALE:
                setImageCharacter(maleSymbol);
                break;
            case FEMALE:
                setImageCharacter(femaleSymbol);
                break;
            case NONBINARY: // unfortunately there is no non-binary symbol, so pick randomly
                setImageCharacter((Math.random() < 0.5) ? maleSymbol : femaleSymbol);
                break;
        }
        this.gender = gender;
    }

}
