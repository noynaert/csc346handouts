import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *  Demonstrates use of Map
 */

public class Main {

    public static void main(String[] args) {
        String fileName = "people.txt";

        //Map<String, Person> people = new HashMap<>();
        Map<String, Person> people = new TreeMap<>();

        readPeople(people, fileName);
        showAll(people);
    }

    private static void showAll(Map<String,Person> people) {
      var everyone = people.keySet();
        System.out.println("People size is " + people.size());
        for(String key : everyone){
            System.out.printf("%-10s: %s\n", key, people.get(key));
        }
    }

    public static void readPeople(Map<String, Person> people, String fileName){
        try {
            Scanner input = new Scanner(new File(fileName));

            while(input.hasNextLine()){
                String line = input.nextLine();
                System.out.println(line);
                String[] fields = line.split(";");
                String email = fields[0];
                String gnumber = String.format("G00%06d", (int)(Math.random() * 1000000));
                String key = gnumber;

                Person pn = new Person(fields[1], fields[2], fields[3], fields[4]);
                System.out.println (email);

                //people.put(gnumber, pn);
                people.put(key, pn);
            }

            input.close();
        } catch (FileNotFoundException e) {
            System.err.printf("Error reading file: " + e.getMessage());
            System.exit(1);
        }

    }
}
