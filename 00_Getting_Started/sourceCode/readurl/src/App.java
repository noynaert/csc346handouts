import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Reading from a URL
 * 
 * @author J. Evan Noynaert
 * @since December 2021
 * 
 *        Reads from a file and handles exceptions
 * 
 *        Reference:
 *        https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html
 
 */
public class App {
    public static void main(String[] args) {
        final String address = "https://raw.githubusercontent.com/noynaert/csc346handouts/main/README.md";
        ArrayList<String> lines = new ArrayList<String>();

        remoteRead(address, lines);
        print(lines);

        System.out.println("\nDone!");
    }

    /**
     * Prints the number of items on the list and the list itself.
     * @param lines  An arrayList of strings.  It may be empty.
     */
    private static void print(ArrayList<String> lines) {
        int n = lines.size();
        System.out.printf("\nPrinting %d items\n", n);
        for (int i = 0; i < n; i++) {
            System.out.printf("\t[%2d] %s\n", i, lines.get(i));
        }

        System.out.printf("\n Printing %d items without the index:\n", n);
        for (String line : lines) {
            System.out.printf("\t -- %s\n", line);
        }

    }

    /**
     * Attempts to read all the lines of text from the address.
     * 
     * Any lines read are added to the list.
     * 
     * If the URL cannot be read a message is printed to stderr and no change is made to the list.
     * 
     * @param address  -- A URL such as https://example.com
     * @param lines    -- An ArrayList.  Normally the list will be empty when the method is called
     *               
     */

    private static void remoteRead(String address, ArrayList<String> lines) {
        try {
            URL url = new URL(address);
            InputStreamReader inStream = new InputStreamReader(url.openStream());
            BufferedReader input = new BufferedReader(inStream);

            String line; //One line from the file
            while ((line = input.readLine()) != null) {
                // if(line.trim().length() > 0)
                if (line.trim().startsWith("#"))
                    lines.add(line);
            }

            input.close();

        } catch (Exception e) {

            System.err.println(e.getMessage() + " (Continuing execution)");
            // e.printStackTrace();
        }
    }

    private static void readWithTwoExceptions(String address) {
        
        try {
            URL url = new URL(address);
            InputStreamReader inStream = new InputStreamReader(url.openStream());
        } catch (MalformedURLException e) {
            System.err.println("BAD URL: " + address + "*** ABORTING ***");
            System.exit(1);
            // e.printStackTrace();
        } catch (IOException e) {
            System.err.print  ("IO EXCEPTION: " + e.getMessage());
            System.err.println("   Execution will continue");
            // e.printStackTrace();
        }
    }
}