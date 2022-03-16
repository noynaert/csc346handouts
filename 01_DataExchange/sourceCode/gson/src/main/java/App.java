import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Demonstration of Gson toJson.
 *
 * Outputs json from simple objects, arraylists, and maps
 */

public class App {
    public static void main(String[] args) {
        testPerson();
        obj2json();
        arrayList2json();
        map2json();
        System.out.println("\nDone!");
    }

    public static void arrayList2json() {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Leonard", "Hofstadter", 31));
        people.add(new Person("Penny", null, 28));
        people.add(new Person("Sheldon", "Cooper", 32));
        people.add(new Person("Amy Farrah", "Fowler", 34));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(people);
        System.out.println("\n----arrayList2json");
        System.out.println(s);
        System.out.println(new GsonBuilder().create().toJson(people));
        dump("peopleArray.json", gson.toJson(people));
    }

    public static void map2json() {
        TreeMap<String, Person> tree = new TreeMap<>();
        Person pn = new Person("Leonard", "Hofstadter", 31);
        tree.put(pn.getName().toString(), pn);
        pn = new Person("Penny", null, 28);
        tree.put(pn.getName().toString(), pn);
        pn = new Person("Sheldon", "Cooper", 32);
        tree.put(pn.getName().toString(), pn);
        pn = new Person("Amy Farrah", "Fowler", 34);
        tree.put(pn.getName().toString(), pn);

        System.out.println("\n----map2json()");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(tree);
        System.out.println(s);
        dump("personTree.json", gson.toJson(tree));
    }

    public static void obj2json() {
        Person pn = new Person("Leonard", "Hofstadter", 31);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(pn);
        System.out.println("\n----obj2json()");
        System.out.println(pn);
        System.out.println(s);
        dump("leonard.json", s);
        pn = new Person("Penny", null, 32);
        System.out.println(gson.toJson(pn));
        dump("penny.json", gson.toJson(pn));
        System.out.println("  --with nulls");
        gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        System.out.println(gson.toJson(pn));
        dump("pennyNull.json", gson.toJson(pn));
    }

    public static void testPerson() {
        System.out.println("\nTesting Person");
        Person pn = new Person("Sheldon", "Cooper", 32);
        System.out.println(pn);
        pn = new Person("Penny", null, 30);
        System.out.println(pn);
        System.out.println(new Person());
    }

    /**
     * Prints a json string to a file.
     *
     * @param fileName -- The name of the file to be written to
     * @param json     -- The json as a string
     */
    public static void dump(String fileName, String json) {
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(json);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
