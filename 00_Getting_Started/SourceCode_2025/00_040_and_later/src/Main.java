//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * This program reads from a URL.  It is intended to illustrate advanced exception handling
 *
 * @author J. Evan Noynaert
 * @since January, 2025
 */

public class Main {
    public static void main(String[] args) {
        final String ADDRESS = "https://raw.githubusercontent.com/noynaert/csc346handouts/refs/heads/main/dataFiles/sanderson.md";
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Book> books = new ArrayList<>();

        //temporary testing
        Book b = new Book();
        books.add(b);
        Book way = new Book("The Way of Kings", 1258);
        books.add(way);
        books.add(new Book("Oathbringer", 1243));
        books.add(new Book("Edgedancer",272));
        System.out.println(books);
        printList(books,"Books");



        readURL(ADDRESS, lines);
        printList(lines, "Stormlight Archive Novels");

        System.out.println ("Done!");
    }

    /**
     * This method reads lines of text from the url specified by address.  The lines of text are
     * stored in the lines ArrayList.
     *
     * @param address:String  The URL of the text file
     * @param lines:ArrayList<String> This is the list of lines that have been read.
     */
    private static void readURL(String address, ArrayList<String> lines) {

        try {
            URL url = new URL(address);

            InputStreamReader inStream = new InputStreamReader(url.openStream());
            BufferedReader input = new BufferedReader(inStream);

            //read the lines
            String line;
            while ( (line=input.readLine()) != null){
                line.trim();
                lines.add(line);
            }
            input.close();
            inStream.close();
        } catch (Exception e) {
            System.out.printf("Error reading URL (%s): %s\n", e.getMessage(),address);
            System.exit(1);
        }

    }

    /**
     * This method prints the title and skips a line.  Then it prints all the items
     * on the list.  Finally, it prints the number of items on the list.
     *
     * @param lines:ArrayList<String>  The list of lines to be printed.  It may be empty.
     * @param title:String  The title to be printed labove the data
     */

    private static <T>void printList(ArrayList<T> lines, String title) {
        //Print the title
        System.out.printf("\n%s\n\n",title);

        //Print the lines, if any
        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }
        /*
        for (line:lines){
           System.out.println(line);
         */

        //Print the total
        System.out.printf("\n There were %d lines in the list\n", lines.size());


    }
}