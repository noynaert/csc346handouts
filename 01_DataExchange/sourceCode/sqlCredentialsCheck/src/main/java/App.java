import com.noynaert.sqlCredentials.SqlCredentials;

import java.io.File;
import java.sql.*;
import java.util.Scanner;

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
        System.out.println("The raw host: " + credentials.getHost());
        System.out.println("The Password Hint: " + credentials.getPasswordHint());

        //Process by Direct Query
        queryString(credentials);
        System.out.println("-0-0-0-0-0-0-0-0-0-0-0-0");
        preparedRead("password.txt");
        System.out.println("-0-0-0-0-0-0-0-0-0-0-0-0");

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

    public static void preparedRead(String passwordFileName) {
        final String user = "csc";
        final String host = "woz.cs.missouriwestern.edu";
        String password;
        String connectString = String.format("jdbc:mysql://%s:3306/misc", host);
        System.out.printf("The connection string is \"%s\"\n", connectString);

        try {
            Scanner passwordFile = new Scanner(new File(passwordFileName));
            password = passwordFile.next();
            System.out.println("The password is " + password);

            // get connection
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    connectString, user, password);

            //Make the query
//            Scanner kbd = new Scanner(System.in);
//            System.out.print("What field?");
//            String field = kbd.next();
//            System.out.print("What criteria, or % for default");
//            String criteria = kbd.next();
//            kbd.close();

            String s1="capital_city";
            String s2="A%";
            //Prepare the statement
            String query = "select  state, capital_city from states where capital_city like ? ORDER BY capital_city";
            PreparedStatement stmt;
            stmt = con.prepareStatement(query);
            stmt.setString(1,s2);
            `

            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String state = rs.getString("state");
                String fld = rs.getString(s1);
                System.out.printf("%-15s %s\n",state,fld);
            }
            con.close();

            //ResultSet rs = stmt.executeQuery
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}
