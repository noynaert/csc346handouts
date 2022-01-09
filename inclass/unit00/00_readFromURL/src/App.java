import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * Reads from a url and discusses exceptions in more depth
 * 
 * @author J. Evan Noynaert
 * @since December 2021
 */

public class App {
    public static void main(String[] args) {
        
        final String ADDRESS = "https://raw.githubusercontent.com/noynaert/csc346handouts/main/README.md";

        ArrayList<String> lines = new ArrayList<String>();
        readRemoteAddress(ADDRESS, lines);

        printLines(lines);

        System.out.println("\nDone!\n");
    }

    public static void printLines(ArrayList<String> lines) {
        int n = lines.size();
        System.out.printf("\nPrinting %d lines:\n", n);
        for(int i = 0; i<n; i++)
            System.out.printf("[%2d] %s\n", i, lines.get(i));

        System.out.printf("\nPrinting %d lines:\n", n);
        for (String line : lines) {
            System.out.printf(">>>%s<<<\n", line);
        }
    }

    private static void readRemoteAddress(String address, ArrayList<String> lines) {
        try {
            URL url = new URL(address);

            InputStreamReader inStream = new InputStreamReader(url.openStream());
            BufferedReader input = new BufferedReader(inStream);

            String line;
            while ( (line = input.readLine()) != null ){
                line = line.trim();
                if (line.startsWith("#")) {
                    lines.add(line);
                }
            }
            input.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
            // e.printStackTrace();
        }
    }
}
