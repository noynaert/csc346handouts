
/**
 * Illustrates splitting strings
 * 
 * @author J. Evan Noynaert
 * @since December 2021
 * 
 */
public class App {
    public static void main(String[] args) {

        // Simulate a colon-delimited line read from a file.
        String line = "Fred:Flinstone:Yes";

        String[] fields = line.split(":");

        if (fields.length == 3) {
            String first = fields[0];
            String last = fields[1];
            int age;
            try {
                age = Integer.parseInt(fields[2]);
            } catch (NumberFormatException e) {
                age = -1;
            }
            Person pn = new Person(first, last, age);
            System.out.println(pn);
            System.out.println("Is the person's age known? " + pn.ageIsKnown());
        }

        System.out.println("\nDone!");
    }
}
