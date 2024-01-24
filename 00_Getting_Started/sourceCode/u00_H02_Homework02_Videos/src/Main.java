import edu.missouriwestern.noynaert.bookDemo.Book;

/**
 * This program illustrates reading a CSV file.
 *
 * It is a model for homework 02
 *
 * @author J. Evan Noyanert
 * @since  January 2024
 */
public class Main {
    public static void main(String[] args) {

        Book book = new Book("1234567890", "Brandon Sanderson","The Way of Kings", 2010.9);

        System.out.println(book);
        System.out.println("\nDone!");
    }
}
