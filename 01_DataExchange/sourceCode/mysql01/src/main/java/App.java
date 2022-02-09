import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Demonstrates a simple mysql/mariadb connection
 *
 * @author: J. Evan Noynaert
 * @since: February 2022
 */

public class App {
    public static void main(String[] args){
        String user = "csc";
        String password="sandra4288";
        String connectString = "jdbc:mysql://localhost:3306/misc";
        String query = "select state, nickname from states order by nickname";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(connectString, user,password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                String stateName = rs.getString(1);
                String nickname = rs.getString(2);
                System.out.printf("%-20s %s\n",stateName,nickname);
            }
            con.close();
        }catch(Exception e){
            System.err.println("ERROR:\n" + e.getMessage());
        }


        System.out.println("\nDone!");
    }
}
