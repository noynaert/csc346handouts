import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Demonstrates use of Map
 */

public class Main {

    public static void main(String[] args) {
        //Map<String, Person> people = new HashMap<String, Person>(30);
        Map<String, Person> people = new TreeMap<>();
        String fileName = "people.txt";

        readPeople(people, fileName);

//        Person pn = new Person("Maximillon", "Griffon", "St. Joseph", "Missouri");
//        System.out.println(pn);
//        long code = Math.abs(pn.hashCode()) %30;
//        System.out.println(code);
    }

    private static void readPeople(Map<String, Person> people, String fileName) {
        try {
            Scanner input = new Scanner(new File(fileName));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String fields[] = line.split(";");

                String gnumber = String.format("G00%06d", (int) (Math.random() * 1000000));
                Person pn = new Person(fields[1], fields[2], fields[3], fields[4]);
                people.put(gnumber, pn);

            }

            input.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(12);
        }
        print(people);
    }

    public static void print(Map m){
        System.out.printf("----There are %d entries-----\n", m.size());
        var keys = m.keySet();
        for(var key:keys){
            var value = m.get(key);
            System.out.printf("[%s]\t%s\n", key, value);
        }
    }
}
