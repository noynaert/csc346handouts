import java.time.LocalDate;

/**
 * Illustrates parsing a date from a mm/dd/yyyy string
 * 
 * @author J. Evan Noynaert
 * @since December, 2021
 */

public class App {
    public static void main(String[] args) throws Exception {

        String s = "4/2/2022";
        LocalDate date = parseDate(s);
        System.out.printf("\n%s is %s in ISO format.\n", s, date);

        System.out.println("\nDone!");
    }

    /**
     * Parses a US-style month/day/year notation to ISO standard date format in a
     * Java LocalDate object.
     * 
     * @param usDate a string in month/day/year format with integer values for
     *               month, day of month, and year
     * @return A Java localDate object
     */
    public static LocalDate parseDate(String usDate) {
        LocalDate date = null;
        String[] fields = usDate.split("/");
        int month = Integer.parseInt(fields[0]);
        int day = Integer.parseInt(fields[1]);
        int year = Integer.parseInt(fields[2]);

        date = LocalDate.of(year, month, day);

        return date;
    }
}
