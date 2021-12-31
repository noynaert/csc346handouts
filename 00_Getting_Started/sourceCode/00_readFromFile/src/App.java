import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This program illustrates reading from files and basic exception handling.
 * 
 * @author J. Evan Noynaert
 * @since December 2021
 * 
 */
public class App {
    public static void main(String[] args) {

        String fileName = "data.txt";

        try {
            Scanner input = new Scanner(new FileInputStream(fileName));
            System.out.println("\nFile is open!");

            while (input.hasNextLine()) {
                String line = input.nextLine();
                line = line.trim();
                if (line.length() > 0)
                    System.out.println("----> " + line);
            }

            input.close();
        } catch (FileNotFoundException e) {
            System.err.println("\nERROR:  Could not find file " + fileName);
            System.exit(1);
            // e.printStackTrace();
        }

        System.out.println("\nDone!\n");
    }
}
