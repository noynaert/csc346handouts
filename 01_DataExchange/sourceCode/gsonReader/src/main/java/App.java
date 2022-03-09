import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Demonstrates reading json from a file and URL.
 *
 * For convenience, main() handles all Exceptions.
 *
 * https://attacomsian.com/blog/gson-read-json-file and others
 */

public class App {
    public static void main(String[] args){

        try{
            readObject();
            readArray();
            readMap();
            readGenericMap();
        }catch(Exception e){
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println("\nDone!");
    }

    private static void readGenericMap() throws Exception{
        Gson gson = new Gson();
        String s = Files.readString(Path.of("personTree.json"));
        Map<?,?> things = gson.fromJson(s, HashMap.class);

        System.out.println("\n----Generic Map");
        var keys = things.keySet();
        for(var key:keys){
            Object value = things.get(key);
            System.out.printf("[%s] %s\n", key, value);
        }
    }

    private static void readMap() throws Exception{
        Gson gson = new Gson();
        String s = Files.readString(Path.of("personTree.json"));
        TreeMap<String, Person> people = gson.fromJson(s, TreeMap.class);

        System.out.println("\n----map");
        var keys = people.keySet();
        for(String name:keys){
            Object value = people.get(name);
            System.out.printf("[%s] %s\n", name, value);
        }
    }

    private static void readArray() throws Exception{
        Gson gson = new Gson();
        String s = Files.readString(Path.of("peopleArray.json"));

        Person[] people = gson.fromJson(s,Person[].class);
        System.out.println("\n----Array");
        for(int i = 0;i<people.length;i++){
            System.out.printf("[%2d] %s\n", i, people[i]);
        }
    }

    public static void readObject() throws Exception{
        Gson gson = new Gson();
        //Reader reader = Files.newBufferedReader(Path.of("leonard.json"));
        //Person pn  = gson.fromJson(reader, Person.class);
        String s = Files.readString(Path.of("leonard.json"));
        Person pn = gson.fromJson(s, Person.class);
        System.out.println(pn);

        s = Files.readString(Path.of("penny.json"));
        pn = gson.fromJson(s, Person.class);
        System.out.println(pn);

        s = Files.readString(Path.of("pennyNull.json"));
        pn = gson.fromJson(s, Person.class);
        System.out.println(pn);

    }

}
