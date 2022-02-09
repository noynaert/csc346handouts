import java.sql.*;

/**
 * Demonstrates jdbc select statement
 *
 * @author: J. Evan Noynaert
 * @since: February 2022
 */

public class App {
    public static void main(String[] args){
        String user = "csc";
        String password = "sandra4288";
        String host = "localhost";

        String connectionString = String.format("jdbc:mysql://%s:3306/misc", host);
        System.out.println(connectionString);

        String query = "select state, nickname, population from states order by nickname";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(connectionString,user,password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                String stateName = rs.getString(1);
                String nickname = rs.getString("nickname");
                long pop = rs.getLong(3);
                System.out.printf("%-15s %10d %s\n", stateName, pop, nickname);
            }

        }catch(Exception e){
            System.err.println("Error: " + e.getMessage());
        }
        System.out.println("\nDone!");
    }
}
