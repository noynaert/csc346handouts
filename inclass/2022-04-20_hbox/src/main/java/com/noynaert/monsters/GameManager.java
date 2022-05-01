package com.noynaert.monsters;


import java.util.ArrayList;
import java.util.Collections;

public class GameManager {

    public Player contest(ArrayList<Player> players){
        Player winner = null;
        int round = 0;
        while(players.size() > 1) {
            displayMessage(String.format("\nRound %d.  Maximum rounds remaining: %d",
                    ++round,(int)Math.ceil(log2(players.size()))));
            Collections.shuffle(players);

            for(int i = 0; i < players.size(); i += 2){
                if(i == players.size()-1){  //if there is an odd number of players, someone gets a bye.
                    displayMessage("----- "+players.get(i).getName()+ " gets a bye -----");
                }else {
                    Player p1 = players.get(i);
                    Player p2 = players.get(i+1);
                    fightAnnouncement(p1, p2);
                    while (p1.getBody().isAlive() && p2.getBody().isAlive()) {
                        onePlayerAttacks(p1, p2);
                        onePlayerAttacks(p2, p1);
                        displayMessage(String.format("%s at %1.0f%%, %s at %1.0f%%",
                                p1.getName(), p1.body.getHealth()*100.0, p2.getName(), p2.body.getHealth()*100.0));
                    }
                    String message = "The fight ends.";
                    message += p1.name + ((p1.body.isAlive())?" is still alive." : " is quite dead.");
                    message += "  " + p2.name + ((p2.body.isAlive())?" is still alive." : " is quite dead.");
                    displayMessage(message);
                }
            }
            //Remove dead players from the arraylist.
            //This gets tricky because the array size keeps shrinking as th program runs.
            int i=0;
            while(i < players.size()){
                if(players.get(i).body.isDead()){
                    players.remove(i);
                    //We do not increment i because there is now 1 less player.
                }else{
                    i++;  //Player is alive, so move on
                }
            }


        }
        if(players.size()>0) {
            winner = players.get(0);
            displayMessage("\uD83C\uDFC6 " + winner + " WINS! \uD83C\uDFC6");
        }else{
            displayMessage("EVERYONE DIED.  THERE WAS NO WINNER!");
            winner = null;
        }
        return winner;
    }

    //    public static String displayMessage(String message){
//        System.out.println(message);
//        return message;
//    }
    public double onePlayerAttacks(Player attacker, Player defender){
        double damage = 0;
        if(attacker.getBody().isAlive()) {
            if (Math.random() <= attacker.getBody().getAggressiveness()) {
                attacker.getBody().attack();
                displayMessage(attacker.getName()+" "+attacker.getBody().getAttackMessage());
                damage = Math.random() * attacker.getBody().getAttackEffectiveness();
                if(true || defender instanceof Defender){  //instanceOf not working, so I improvised
                    String s = defender.body.getDefenseMessage();
                    if(defender.body.getDefenseMessage().length() > 0) {
                        defender.body.defend();
                        double reduction = 0.1 * Math.random() * defender.getBody().getDefenceEffectiveness();
                        displayMessage(defender.name + " " + defender.getBody().getDefenseMessage());
                        
                        if(reduction < damage)
                          damage -= reduction;
                        else
                          damage = .90 * damage;  //If reduction is greater than damage, just knock 10% off damage.
                    }
                }
                String report = "";
                if(damage < 0.10)
                    report = "\tThere was barely a barely a scratch";
                else if(damage < 0.30)
                    report = "\tIt was a solid hit";
                else
                    report = "\tIt was a devastating hit.";
                report += String.format(" (%1.3f)", damage);
                displayMessage(report);

                //Subtract the damage from the health and reset the health.
                defender.getBody().setHealth(defender.getBody().getHealth() - damage);
                if(defender.getBody().isDead()){
                    displayMessage("\t \uD83D\uDC80 "+defender.getName()+" is dead \uD83D\uDC80\n");
                }
            } else {
                displayMessage(attacker.getName() + " "+attacker.getBody().getNoAttackMessage());
            }
        }else{
            displayMessage(attacker.getName() + " does not attack on account of being dead at the moment.");
        }
        return damage;
    }
    private void fightAnnouncement(Player p1, Player p2) {
        String message = String.format("\n----- %s (%1.0f%%) and %s (%1.0f%%) enter the game -----",
                p1, p1.body.getHealth()*100.0, p2, p2.body.getHealth()*100.0);
        displayMessage(message);
    }

    public static double log2(int n)
    {

        // calculate log2 N indirectly
        // using log() method
        double result = (Math.log(n) / Math.log(2));

        return result;
    }
    public static String displayMessage(String message){
        System.out.println(message);
        return message;
    }
}
