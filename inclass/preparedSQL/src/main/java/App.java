import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;


/**
 * Demonstrates prepared statements
 * Also, file for password.txt
 *
 *
 * @author J. Evan Noynaert
 * @since February 2022 program is started
 */

public class App {
    public static void main(String[] args){
        String password = getPassword("passwords.txt");
        System.out.println("The password is " + password);
        String user="csc";
        String connectString = String.format("jdbc:mysql://%s:3306/misc", "woz.cs.missouriwestern.edu");
        System.out.println("connection string is " + connectString);

        try{
//            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectString,user,password);

           // DIRECT METHOD
//            String query = "SELECT city, state from usCityDemographics WHERE city like 'Springfield' and state LIKE 'Missouri' ";
//              String query = "DROP TABLE students
//                             "SELECT user, password FROM users;
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(query);

            //PREPARED STATEMENTS
            String query = "SELECT city, state FROM usCityDemographics WHERE city LIKE ? and state like ?";
            PreparedStatement stmt;
            stmt = conn.prepareStatement(query);

            stmt.setString(1, "Springfield");
            stmt.setString(2, "Missouri");

            ResultSet rs = stmt.executeQuery();
            boolean foundRecord = rs.next();
            if(foundRecord){
                System.out.println("At least one record was found");
            }else{
                System.out.println("No records found");
            }

            while(rs.next()){
                String  state = rs.getString("city");
                String  thing = rs.getString(2);
                System.out.printf("%-20s %s\n", state, thing);
            }

            conn.close();
        }catch(Exception e){
            System.err.println("Could not connect: " + e.getMessage());
        }

        System.out.println("\nDone!");
    }

    public static String getPassword(String fileName){
        String password = "";
        try {
            Scanner input = new Scanner(new File(fileName));
            password = input.next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return password;
    }
}
