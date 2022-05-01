package com.noynaert.monsters;

/**
 * Player consists of player name and a critter body
 */

public class Player {
    String name;
    Critter body;

    public Player(String name, Critter body) {
        setName(name);
        setBody(body);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Critter getBody() {
        return body;
    }

    public void setBody(Critter body) {
        this.body = body;
    }

    @Override
    public String toString(){
        String s = String.format("%s %s (a %s) ", body.getImageCharacter(), name, body.getCritterName());
              s+=  (getBody().isDead())?"\u2620":"\u2661";  //Dead or alive symbol
        return s;
    }

}
