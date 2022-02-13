import com.noynaert.sqlCredentials.SqlCredentials;

/**
 * todo: PROGRAM DESCRIPTION
 *
 * @author: YOUR NAME
 * @since: MONTH YEAR program is started
 */

public class App {
    //woz.xml or other suitable file should be in args[0]
    public static void main(String[] args){
        SqlCredentials credentials = new SqlCredentials(args[0]);
        System.out.println(credentials);
        System.out.println("\nDone!");
    }
}
