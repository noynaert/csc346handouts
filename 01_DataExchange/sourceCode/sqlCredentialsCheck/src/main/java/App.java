import com.noynaert.sqlCredentials.SqlCredentials;

/**
 * Example for reading sql credentials from an xml file using
 * my custom SqlCredentials class
 *
 * @author: J. Evan Noynaert
 * @since: February 2022
 *
 * Reads the name of the credentials file from args[0]
 *
 */

public class App {
    //woz.xml or other suitable file should be in args[0]
    public static void main(String[] args){
        SqlCredentials credentials = new SqlCredentials(args[0]);
        System.out.println(credentials);
        System.out.println("The raw user: "+ credentials.getUser());
        System.out.println("The raw password: "+ credentials.getPassword());
        System.out.println("The raw host: " + credentials.getHost());
        System.out.println("-=-=-=-=-=-=");
        System.out.println("The Password Hint: "+credentials.getPasswordHint());

        System.out.println("\nDone!");
    }
}
