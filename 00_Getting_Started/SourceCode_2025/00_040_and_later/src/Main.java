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
        ArrayList<Book> books;

        readURL(ADDRESS, lines);
        printList(lines, "Stormlight Archive Novels");

        books = makeBooks(lines);
        printList(books, "Stormlight Archive Books");


        System.out.println ("Done!");
    }

    private static ArrayList<Book> makeBooks(ArrayList<String> lines) {
        ArrayList<Book> books = new ArrayList<>();

        for(var line :lines){
            String[] parts = line.split("\\|");
            if(parts.length == 2){
                String title = parts[0];
                int pages = -99;
                //System.out.println(parts[1]);
                try{
                    pages = Integer.parseInt(parts[1]);
                }catch(NumberFormatException e){
                    System.out.printf("I caught %s\n", parts[1]);
                    //continue;  //aborts the rest of the loop if the line is Not a Number
                }
                if (pages != -99) {
                   // Book book = new Book(title, pages);
                   // books.add(book);
                    books.add(new Book(title, pages));
                }
            }
        }

        return books;
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