import com.noynaert.sqlCredentials.SqlCredentials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Example for reading sql credentials from an xml file using
 * my custom SqlCredentials class
 *
 * @author: J. Evan Noynaert
 * @since: February 2022
 * <p>
 * Reads the name of the credentials file from args[0]
 */

public class App {
    //woz.xml or other suitable file should be in args[0]
    public static void main(String[] args) {
        SqlCredentials credentials = new SqlCredentials(args[0]);
        System.out.println(credentials);
        System.out.println("The raw user: " + credentials.getUser());
        System.out.println("The raw password: " + credentials.getPassword());
        System.out.println("The raw host: " + credentials.getHost());
        System.out.println("-=-=-=-=-=-=");
        System.out.println("The Password Hint: " + credentials.getPasswordHint());

        //Process by Direct Query
        queryString(credentials);

        System.out.println("\nDone!");
    }

    public static void queryString(SqlCredentials credentials) {
        String query = "select state, nickname from states order by nickname";
        String connectString = String.format("jdbc:mysql://%s:3306/misc", credentials.getHost());
        System.out.printf("The connection string is \"%s\"\n", connectString);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    connectString, credentials.getUser(), credentials.getPassword());
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String stateName = rs.getString(1);
                String nickname = rs.getString(2);
                System.out.printf("%-20s %s\n", stateName, nickname);
            }
            con.close();
        } catch (Exception e) {
            System.err.println("ERROR:\n" + e.getMessage());
        }
    }
}
