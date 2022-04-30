import edu.missouriwestern.csc346.monsters.Cook;
import edu.missouriwestern.csc346.monsters.GameManager;
import edu.missouriwestern.csc346.monsters.GiantRat;
import edu.missouriwestern.csc346.monsters.Player;

import java.util.ArrayList;


public class App {
    public static void main(String[] args){

        char ch = '\uD83D';
        char ch2='\uDC35';
        String animal = "\uD83D\uDC35";
        Player p = new Player ("Ptomain Tony", new Cook());
        Player q = new Player("Broccoli Spears", new Cook());
        ArrayList<Player> roster = new ArrayList<>();
        roster.add(p);
        roster.add(q);
        roster.add(new Player("Ricky", new GiantRat()));
        roster.add(new Player("Randy", new GiantRat()));

        GameManager game = new GameManager();
        game.contest(roster);

        System.out.println("\nDone!");
    }
}
