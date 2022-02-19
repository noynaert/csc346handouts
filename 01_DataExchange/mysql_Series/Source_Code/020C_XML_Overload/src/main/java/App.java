import com.noynaert.sqlCredentials.SqlCredentials;
/**
 * Uses a custom .jar file to read credentials from an xml file
 *
 * @author: YOUR NAME
 * @since: MONTH YEAR program is started
 */

public class App {
    public static void main(String[] args){
        SqlCredentials creds = new SqlCredentials("woz.xml");
        System.out.println(creds);

        String user = creds.getUser();
        System.out.println(user);
        System.out.println("\nDone!");
    }
}
