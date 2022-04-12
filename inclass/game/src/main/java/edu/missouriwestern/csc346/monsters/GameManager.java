package edu.missouriwestern.csc346.monsters;

import java.util.ArrayList;
import java.util.Collections;

/**
 * GameManager runs a series of battles between players.
 * <p>
 * The main input is an ArrayList<Player>
 * <p>
 * The main output is a single winner from the ArrayList of Players.
 * <p>
 * The GameManager is responsible for ALL output during actual gameplay.
 * <p>
 * GameManager calls the getMessage methods for critters when output is needed from the critter.
 * <p>
 * The only thing that actually sends output to the console is the displayMessage(String) method.
 * All other methods should call displayMessage when they need to print something.
 */


/**
 * Contest takes a roster of players.  It then runs a series of fights beween
 * pairs of contestants.  The players are matched randomly.
 * <p>
 * As players die they are removed from the roster.
 * <p>
 * When there is only one person on the roster, they are the winner.
 */

final public class GameManager {
    public static double log2(int n) {

        // calculate log2 N indirectly
        // using log() method
        double result = (Math.log(n) / Math.log(2));

        return result;
    }

    public static String displayMessage(String message) {
        System.out.println(message);
        return message;
    }

    public Player contest(ArrayList<Player> roster) {
        Player winner = null;
        int round = 0;
        while (roster.size() > 1) {
            Collections.shuffle(roster);
            displayRoundStart(roster, round);

            //Pair off adjacent players.  If one is left, then they get a bye.
            for (int i = 0; i < roster.size(); i += 2) {
                if (i == (roster.size() - 1)) {  //Give bye to single player at end of list
                    displayMessage("----- " + roster.get(i).name + " gets a bye -----");
                } else {
                    Player p1 = roster.get(i);
                    Player p2 = roster.get(i + 1);
                    fightAnnouncement(p1, p2);

                    while (p1.body.isAlive() && p2.body.isAlive()) {
                        onePlayerAttack(p1, p2);
                        onePlayerAttack(p2, p1);
                        //Announce the results
                        displayMessage(String.format("%s at %1.0f%%, %s at %1.0f%%", p1.getName(), p1.body.getHealth() * 100.0, p2.getName(), p2.body.getHealth() * 100.0));
                    }
                }
            }
            //Remove dead players from the arraylist.
            //This gets tricky because the array size keeps shrinking as th program runs.
            int i = 0;
            while (i < roster.size()) {
                if (roster.get(i).body.isDead()) {
                    roster.remove(i);
                    //We do not increment i because there is now 1 less player.
                } else {
                    i++;  //Player is alive, so move on
                }
            }

        }
        if (roster.size() > 0) {
            winner = roster.get(0);
            displayMessage("\uD83C\uDFC6 " + winner + " WINS! \uD83C\uDFC6");
        } else {
            displayMessage("EVERYONE DIED.  THERE WAS NO WINNER!");
            winner = null;
        }
        return winner;
    }

    private void onePlayerAttack(Player attacker, Player defender) {
        double damage = 0;
        if (attacker.body.isAlive()) {
            //Decide if player will attack this round
            if (Math.random() <= attacker.body.getAggressiveness()) {
                attacker.body.attack();//sets attack effectiveness and message
                displayMessage(attacker.name + " " + attacker.body.getAttackMessage());
                damage = Math.random() * attacker.body.getAttackEffectiveness();
                defender.body.defend();
                String defenseMessage = defender.body.getDefenseMessage();
                if (defender instanceof Defender  || defenseMessage.length()>0) {
                    defender.body.defend();
                    displayMessage(defender.body.getDefenseMessage());
                    double reduction = 0.1 * Math.random() * defender.body.getDefenseEffectiveness();
                    //Make sure protection is not larger than damage
                    if (reduction < damage) {
                        damage -= reduction;
                    } else {
                        damage = .90 * damage; //if reduction is too large, give 10% damage.
                    }
                }
                String report = "";
                if (damage < 0.05) {
                    report = "\tThere was barely a barely a scratch";
                } else if (damage < 0.20) {
                    report = "\tIt was a solid hit";
                } else {
                    report = "\tIt was a devastating hit.";
                }
                report += String.format(" (%1.3f)", damage);
                displayMessage(report);

                //Subtract the damage from the health and reset the health.
                defender.getBody().setHealth(defender.getBody().getHealth() - damage);
                if (defender.getBody().isDead()) {
                    displayMessage("\t \uD83D\uDC80 " + defender.getName() + " is dead \uD83D\uDC80\n");
                }
            }
        } else {
            displayMessage(attacker.name + " does not attack on account of being dead at the moment.");
        }
    }

    private void displayRoundStart(ArrayList<Player> roster, int round) {

        String s = "";
        s += String.format("═════════ Round %d .  Maximum remaining rounds: %d ══════════\n", ++round, (int) Math.ceil(log2(roster.size())));
        for (int i = 0; i < roster.size(); i++) {
            s += String.format("  %d %s\n", i, roster.get(i));
        }
        s += "═════════════════════════════════════════════════════════════\n";
        displayMessage(s);
    }

    private void fightAnnouncement(Player p1, Player p2) {
        String message = String.format("\n----- %s (%1.0f%%) and %s (%1.0f%%) enter the game -----", p1, p1.body.getHealth() * 100.0, p2, p2.body.getHealth() * 100.0);
        displayMessage(message);
    }
}

