import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * todo: PROGRAM DESCRIPTION
 *
 * @author: YOUR NAME
 * @since: MONTH YEAR program is started
 */

public class App {
    public static void main(String[] args) {
        Person p1 = new Person("Maximillion", "Griffon", 2000);
        Person p2 = new Person("Maxine", "Griffon", 1999);
        Person p3 = new Person();
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        Person[] people = {p1, p2, p3};

        //Gson gson = new Gson();
        Gson gson = new GsonBuilder().create();
        String s = gson.toJson(p2);
        System.out.println(s);
        s = gson.toJson(people);
        System.out.println(s);
        System.out.println("\nDone!");

        s = gson.toJson(p1);

        Person p4 = gson.fromJson(s,Person.class);
        System.out.println(p4);
    }

}
