package edu.missouriwestern.noynaert;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Credentials credentials = new Credentials(args);
        System.out.println("\n\nWorking with " + credentials);

        String queryString = "SELECT first_name, last_name, email FROM fakePeople WHERE state like 'C%' ORDER BY last_name,first_name;";

        try {
            queryString = "select first_name, last_name, email from fakePeople where first_name like ? and last_name like ? order by last_name , first_name";
            //ArrayList<Person> people = directQuery(credentials, queryString);
            ArrayList<Person> people = preparedQuery(credentials,queryString);
            print(people,"People");
        }catch(Exception e){
            System.err.println(e.getMessage());
            System.exit(47);
        }

        System.out.println("Done!");
    }



    private static int getNumber(String message) {
        int number = 0;
        boolean numberIsValid = true;
        do {
            Scanner keyboard = new Scanner(System.in);
            System.out.print(message + ": ");
            String s = keyboard.next();
            try{
                number = Integer.parseInt(s);
            }catch(Exception e){
                numberIsValid = false;
            }
        }while(!numberIsValid);
        return number;
    }

    public static String getString(String message){
        Scanner keyboard = new Scanner(System.in);
        System.out.print(message + ": ");
        String s = keyboard.next();
        s += "%";  //SQL wildcard
        return s;
    }


    public static<E> void print(List<E> list, String message){
        System.out.printf("\n----- %s -----\n",message);
        for(E e:list){
            System.out.println(e);
        }
        System.out.printf("----- %d items -----",list.size() );
    }

    private static ArrayList<Person> preparedQuery(Credentials credentials, String queryString) throws SQLException, ClassNotFoundException {
        ArrayList<Person> people = new ArrayList<>();
        String host = "woz.csmp.missouriwestern.edu";
        int port = 3306;
        String database = "misc";
        String connectionString = String.format("jdbc:mysql://%s:%d/%s",host, port,database);
        System.out.println("Connection String: " + connectionString);

        Connection connection = DriverManager.getConnection(connectionString,credentials.user,credentials.password);
//        Statement stmt = connection.createStatement();
//        ResultSet rs = stmt.executeQuery(queryString);
        PreparedStatement preparedStatement = connection.prepareStatement(queryString);
        String first = getString("First Name stub");
        String last = getString("Last Name stub");

        preparedStatement.setString(1, first);
        preparedStatement.setString(2, last);

        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()){
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            Person pn = new Person();
            pn.setFirstName(firstName);
            pn.setLastName(lastName);
            pn.setEmail(email);
            people.add(pn);
        }
        connection.close();

        return people;
    }


    private static ArrayList<Person> directQuery(Credentials credentials, String queryString) throws SQLException, ClassNotFoundException {
        ArrayList<Person> people = new ArrayList<>();
        String host = "woz.csmp.missouriwestern.edu";
        int port = 3306;
        String database = "misc";
        String connectionString = String.format("jdbc:mysql://%s:%d/%s",host, port,database);
        System.out.println("Connection String: " + connectionString);

        Connection connection = DriverManager.getConnection(connectionString,credentials.user,credentials.password);
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(queryString);
        while(rs.next()){
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            Person pn = new Person();
            pn.setFirstName(firstName);
            pn.setLastName(lastName);
            pn.setEmail(email);
            people.add(pn);
        }
        connection.close();

        return people;
    }


}

/**
 * Holds the user name and password for a mysql database;
 */
class Credentials{
    String user;
    String password;

    public Credentials(String[] args){
        if(args.length == 2){
            user = args[0];
            password = args[1];
        }else{
            System.err.printf("ERROR: args[] is not correct.  There should be 4 arguments, but I only found %d.  ABORTING\n",args.length);
            System.exit(46);
        }
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
