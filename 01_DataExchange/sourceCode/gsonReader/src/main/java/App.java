import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URL;
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
//            readArray();
//            readMap();
//            readFromURL();
        }catch(Exception e){
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println("\nDone!");
    }
    public static void readObject() throws Exception{
        String s ="{\"name\":{\"first\":\"Sheldon\",\"last\":\"Cooper\"},\"age\":32}";
        Gson gson = new Gson();
        Person pn = gson.fromJson(s, Person.class);
        System.out.println(pn);

        s = "{\n" +
                "  \"name\": {\n" +
                "    \"first\": \"Amy Farrah\",\n" +
                "    \"last\": \"Fowler\"\n" +
                "  },\n" +
                "  \"age\": 34\n" +
                "}";
        pn = gson.fromJson(s, Person.class);
        System.out.println(pn);

        BufferedReader input = new BufferedReader(new FileReader("sheldon.json"));
        s = input.readLine();
        pn = gson.fromJson(s, Person.class);
        System.out.println(pn);

        input = new BufferedReader(new FileReader("amy.json"));

        //read all of the lines
        s = "";
        String line;
        while((line = input.readLine()) != null) {
            s += line;
        }
        pn = gson.fromJson(s, Person.class);
        System.out.println(pn);

        //Quick way for a local file
        s = Files.readString(Path.of("leonard.json"));
        pn = gson.fromJson(s, Person.class);
        System.out.println(pn);

        String address = "http://woz.cs.missouriwestern.edu/data/json/penny.json";
        URL pennyLocation = new URL(address);
        BufferedReader urlInput = new BufferedReader(new InputStreamReader(pennyLocation.openStream()));

        s = "";
        //line is declared already
        while((line = urlInput.readLine()) != null) {
            s += line;
        }
        pn = gson.fromJson(s, Person.class);
        System.out.println(pn);
    }
    private static void readFromURL() throws Exception{
        String address = "http://woz.cs.missouriwestern.edu/data/json/leonard.json";
        java.net.URL lennieURL = new java.net.URL(address);
        BufferedReader br = new BufferedReader(new InputStreamReader(lennieURL.openStream()));
        String s = "" ; //will hold the json
        String line;
        while( (line = br.readLine()) != null){
            s += line.trim();
        }
        Gson gson = new Gson();
        Person pn = gson.fromJson(s, Person.class);
        System.out.println("\n----Leonard From URL");
        System.out.println(pn);
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



}
