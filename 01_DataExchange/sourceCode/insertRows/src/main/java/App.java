import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import com.noynaert.sqlCredentials.SqlCredentials;

/**
 * inserts data from a .csv file into an sql table
 *
 * @author J. Evan Noynaert
 * @since February 2022
 */

public class App {
    public static void main(String[] args){
        String csvFileName = "/home/noynaert/classes/data/us-cities-demographics.csv";

        try {
            int counter = 0;
            String sqlUser;
            String sqlPassword;
            String sqlHost;
            SqlCredentials credentials = new SqlCredentials("sql.xml");
            sqlUser = credentials.getUser();
            sqlPassword = credentials.getPassword();
            sqlHost = credentials.getHost();

            String connectString = String.format("jdbc:mysql://%s/misc", sqlHost);
            System.out.println("Connection string: " + connectString);
            Connection conn = DriverManager.getConnection(connectString,sqlUser,sqlPassword);
            System.out.println("conn is "+conn);

            Statement stmt = conn.createStatement();

            Scanner csvDataInput = new Scanner(new File(csvFileName));

            //Discard header line
            String line = csvDataInput.nextLine();
            int maxLength = 0;
            while(csvDataInput.hasNextLine()){
                line = csvDataInput.nextLine();
                String[] fields = line.split(";");
                if(fields.length == 12){
                    String city = fields[0].trim();
                    String state = fields[1].trim();
                    float medianAge = parseFloat(fields[2]);
                    int males = parseInt(fields[3]);
                    int females = parseInt(fields[4]);
                    int total_population = parseInt(fields[5]);
                    int veterans = parseInt(fields[6]);
                    int foreign = parseInt(fields[7]);
                    float ave_hh_size = parseFloat(fields[8]);
                    String state_abbr = fields[9].trim();
                    String race = fields[10].trim();
                    int count = parseInt(fields[11]);

                    String update = String.format("INSERT INTO uscities (city, state, medianage,males, females,total_population, veterans,foreign_born,ave_hh_size,state_abbr,race,count) "
                    + "VALUES('%s', '%s', %f, %d, %d, %d, %d, %d, %f, '%s', '%s', %d)",city, state ,medianAge, males, females, total_population, veterans, foreign, ave_hh_size, state_abbr, race, count);

                    counter++;
                    System.out.println(update + " -- "+  counter);
                    stmt.executeUpdate(update);

                }

            }
            csvDataInput.close();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("\nDone!");
    }

    private static float parseFloat(String field) {
        float value = 0;
        try{
            value = Float.parseFloat(field);
        }catch(NumberFormatException e){
            value = (float)0.0;
        }
        return value;
    }
    private static int parseInt(String field) {
        int value = 0;
        try{
            value = Integer.parseInt(field);
        }catch(NumberFormatException e){
            value = 0;
        }
        return value;
    }

}
