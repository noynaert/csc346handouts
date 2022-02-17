import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Reads a password from a file
  */

public class App {
    public static void main(String[] args){

        String password = getPassword("password.txt");
        System.out.println(password);
        System.out.println("\nDone!");
    }

    public static String getPassword(String fileName){
        String password = "";
        try {
            Scanner input = new Scanner(new File(fileName));
            password = input.nextLine().trim();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return password;
    }
}
