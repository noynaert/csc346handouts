import java.sql.*;
import java.util.Scanner;
/**
 * Demonstrates a simple mysql/mariadb connection
 *
 * @author: J. Evan Noynaert
 * @since: February 2022
 */

public class App {
    public static void main(String[] args) {
        String user = "csc";
        String password = "sandra4288";
        String host = "localhost";

        String connectString = String.format("jdbc:mysql://%s:3306/misc", host);
        System.out.printf("The connection string is \"%s\"\n", connectString);

        directQuery(user, password, connectString);
        preparedStatement(user, password, connectString);
        System.out.println("\nDone!");
    }


    public static void directQuery(String user, String password, String connectString) {
        String query = "select state, nickname from states order by nickname";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(connectString, user, password);
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

    private static void preparedStatement(String user, String password, String connectString) {
        String field; // User selected field
        Scanner kbd = new Scanner(System.in);
        System.out.print("What field? ");
        field = kbd.next();
        // Magic code to validate the field is legit should be inserted here.

        String query = "select state, ? from states order by state";
        try {
            Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection(connectString, user, password);

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, field);  //plugs the field value into the first ? in query

        ResultSet rs = ps.executeQuery();
        while(rs.next() ){
            String stateName = rs.getString("state");
            String other = rs.getString(2);
            System.out.printf("%-15s %s\n", stateName,other);
        }

        ps.close();
        } catch (Exception e) {
            System.err.println("ERROR in preparedStatement: " + e.getCause()  + " : " +e.getMessage());
        }
    }
}
/*
Note, to fix the missing Maven-assembly-plugin, see
https://stackoverflow.com/questions/20496239/maven-plugins-can-not-be-found-in-intellij

Look at the "newer" ide instructions:

Click File 🡒 Settings.
Expand Build, Execution, Deployment 🡒 Build Tools 🡒 Maven.
Check Use plugin registry.
Click OK or Apply.
For IntelliJ 14.0.1, open the preferences---not settings---to find the plugin registry option:

Click File 🡒 Preferences.
Regardless of version, also invalidate the caches:

Click File 🡒 Invalidate Caches / Restart.
Click Invalidate and Restart.
When IntelliJ starts again the problem should be vanquished.


 */
