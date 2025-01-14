/**
 * This is a driver program to test out Book objects
 *
 * @author J. Evan Noynaert
 * @since January, 2025
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Book book = new Book("Mistborn", 920);
        System.out.println(book);
        System.out.printf("Title: \"%s\", Pages: %d\n", book.getTitle(), book.getPages());

        Book warbreaker = new Book("Warbreaker, the Color of War", 1230);
        System.out.println(warbreaker);

        Book untitled = new Book();
        System.out.println(untitled);

        System.out.println(book.compareTo(warbreaker));

        System.out.println("Done");

    }
}