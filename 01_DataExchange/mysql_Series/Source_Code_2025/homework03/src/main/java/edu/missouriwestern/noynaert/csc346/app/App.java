package edu.missouriwestern.noynaert.csc346.app;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This program demonstrates reading from a mysql file.
 * <p>
 * The user and passwords must be stored in a file that is specified on the command line.
 * <p>
 * To avoid cluttering the tutorial code, all exceptions are caught in main()
 *
 * @author J. Evan Noynaert
 * @since February, 2025
 */
public class App {
    public static void main(String[] args) {
        ArrayList<String> people = new ArrayList<>();

        //LocalDate excursion
        LocalDate admissionDate = LocalDate.parse("1819-12-14");
        admissionDate = admissionDate.of(1819,12,14);
        System.out.println("Sample admission date: " + admissionDate);

        try {
            Credentials credentials = getCredentials(args);
            String query = "SELECT first_name, last_name, email FROM fakePeople ORDER BY last_name, first_name";

            retrievePeople(people, credentials, query);
            print(people, "People");


        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println("Aborting");
            System.exit(1);
        }
        System.out.println("Done!");
    }

    private static void retrievePeople(ArrayList<String> people, Credentials credentials, String query) throws SQLException {
        String connectionURL = "jdbc:mariadb://woz.csmp.missouriwestern.edu:3306/misc";
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        //connect to the database
        Connection connection = DriverManager.getConnection(connectionURL,username,password);

        //do the query
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        // Iterate through the result set
        while(resultSet.next()) {
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            String s = String.format("%s, %s %s", lastName, firstName, email);
            people.add(s);
        }
    }
    private static <T> void print(ArrayList<T> list, String title) {
        System.out.println(title);
        for (T item : list) {
            System.out.println(item);
        }
        System.out.printf("\n%,d items\n", list.size());
    }

    /**
     * The credentials file must be a single line with the username and password separated by a colon.
     * <p>
     * This takes the args list and reads the file.  It then attempts to read the file and splits the line.
     *
     * @param args -- This should the be the args array from main()
     * @return Returns a credential.  If the credential file was flawed, ??? is returned as the user and !!! is returned as the password.
     * @throws EmptyCommandLineException
     * @throws IOException
     */

    private static Credentials getCredentials(String[] args) throws EmptyCommandLineException, IOException {
        Credentials credentials = new Credentials("???", "!!!");
        if (args.length < 1) {
            throw new EmptyCommandLineException("No file name was on the command line");
        } else {
            String fileName = args[0].trim();
            System.out.println("The file name is " + fileName);
            String line = Files.readString(new File(fileName).toPath(), StandardCharsets.UTF_8);
            String[] parts = line.split(":");
            if (parts.length == 2) {
                credentials.setUsername(parts[0].trim());
                credentials.setPassword(parts[1].trim());
            }
            return credentials;
        }
    }
}