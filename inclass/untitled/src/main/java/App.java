import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;

/**
 * todo: PROGRAM DESCRIPTION
 *
 * @author: YOUR NAME
 * @since: MONTH YEAR program is started
 */

public class App {
    public static void main(String[] args){

        LocalDate bd = LocalDate.of(2000,01,01);
        SimplePerson p1 = new SimplePerson("Maximillion", "Griffon", 2000);
        SimplePerson p2 = new SimplePerson("Maxine", "Griffon", 1999);
        SimplePerson p3 = new SimplePerson();
        SimplePerson[] people = {p1, p2, p3};
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        //Gson gson = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(p2);
        System.out.println(json);
        System.out.println(gson.toJson(people));

        System.out.println("\nDone!");
    }
}
