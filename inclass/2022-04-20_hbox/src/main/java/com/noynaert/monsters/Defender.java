package com.noynaert.monsters;

/** Defender is just a marker class.  Non-defenders SHOULD override the defend() method of the super class */
public interface Defender {
    /**
     * Defender should call setDefenseEffectiveness() and setDefenseMessage()
     */
    public void defend();
}
