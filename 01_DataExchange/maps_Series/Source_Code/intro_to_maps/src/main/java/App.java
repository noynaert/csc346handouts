import java.util.*;
import java.time.*;

/**
 * Demonstrates basic Maps
 */

public class App {
    public static void main(String[] args) {
        Color purple = new Color(255, 0, 255);

        HashMap<String, Color> favorites = new HashMap<>(20);
        favorites.put("Purple",purple);
        favorites.put("Blue", new Color(0,0,255));
        favorites.put("Pink",new Color(255,128, 128));
        favorites.put("Green",new Color(0,255,0));
        favorites.put("Black",new Color(0,0,0));

        //printColors(favorites);

        Map<Double, String> constants = new TreeMap<>();

        Double pi = new Double(3.14159);
        Double sr2 = 1.14159;
        constants.put(pi, "Pi");
        constants.put(sr2, "Square Root of 2");
        constants.put(Math.E, "e");
        constants.put(0., "Zero");

        printMap(favorites, "Favorite Colors");
        printMap(constants, "Some Math Constants");
    }
    private static void printMap(Map m, String heading){
        System.out.printf("======= %s =======\n", heading);
        var keys = m.keySet();
        for(var key : keys){
            var value = m.get(key);
            System.out.printf("[%s]\t%s\n", key, value);
        }
        System.out.printf("======= %d entries\n", m.size());
    }

    private static void printColors(HashMap<String,Color> favorites) {
        System.out.println("----- Favorite Colors -----");
        Set<String> colorNames = favorites.keySet();
        for(String name: colorNames){
            Color color = favorites.get(name);
            System.out.printf("[%s] is %s\n", name, color);
        }
        System.out.printf("----- Printing %d favorite colors", favorites.size());
    }
}
