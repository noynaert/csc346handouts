import edu.missouriwestern.noynaert.people.Person;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person);
        Person star = new Person("Fred", 29);
        System.out.println(star);
        System.out.println("Done!");
    }
}
