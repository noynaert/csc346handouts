import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Reads all credentials from a file
 */

public class App {
    public static void main(String[] args){
        String user;
        String password;
        String host;

        Credentials creds = new Credentials("password.txt");
        user = creds.getUser();
        password = creds.getPassword();
        host = creds.host;
    }
    static class Credentials{
        String user;
        String password;
        String host;

        public Credentials(String fileName){
            try {
                Scanner input = new Scanner(new File(fileName));
                password = input.nextLine().trim();
                user  = input.nextLine().trim();
                host = input.nextLine().trim();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.exit(1);
            }

        }

        public String getUser() {return user;}
        public String getPassword() {return password;}
        public String getHost() {return host;}
    }
}
