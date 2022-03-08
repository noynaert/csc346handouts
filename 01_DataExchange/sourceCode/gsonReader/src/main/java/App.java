import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

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
        }catch(Exception e){
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println("\nDone!");
    }
    public static void readObject() throws Exception{
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Path.of("leonard.json"));
        Person pn  = gson.fromJson(reader, Person.class);
        System.out.println(pn);

        reader = Files.newBufferedReader(Path.of("penny.json"));
        pn  = gson.fromJson(reader, Person.class);
        System.out.println(pn);

        reader = Files.newBufferedReader(Path.of("pennyNull.json"));
        pn  = gson.fromJson(reader, Person.class);
        System.out.println(pn);

    }

}
