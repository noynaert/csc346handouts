import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * This is a driver program to demonstrate a simple object.
 * 
 * @author J. Evan Noynaert
 * @since December 2021
 * 
 */

public class App {
    public static void main(String[] args) {

        Person a = new Person("Fred", "Flintstone", 30);
        Person b = new Person("Barney", "Rubble");
        Person c = new Person();
        Object o = new Object();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(o);

        ArrayList<Person> people = new ArrayList<Person>();

        people.add(a);
        people.add(b);
        people.add(c);
        people.add(new Person("Wilma", "Flintstone", 31));
        people.add(new Person("Pebbles","Flintstone", 1));
        people.add(new Person("Betty", "Rubble"));
        people.add(new Person("Dino","Flinstone"));
        people.add(new Person("Bam-Bam","Rubble",1));
        people.add(new Person());

        printList(people);
        Collections.sort(people);
        printList(people);
        
    }

    private static void printList(ArrayList<Person> people) {
        System.out.println("-----People-----");
        for (Person pn : people) {
            System.out.println(pn);
        }
    }
}
