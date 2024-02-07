package edu.missouriwestern.noynaert;

import java.sql.*;
import java.util.ArrayList;

/*
JDBC  Java DataBase Connector
 */
public class Main {
    public static void main(String[] args) {
        String user = "";
        String password = "";
        String queryString = "SELECT fakePeople.first_name, fakePeople.last_name, fakePeople.email FROM fakePeople WHERE state like 'C%' order by last_name,first_name";
        ArrayList<Person> people;
        if(args.length==2) {
            user = args[0];
            password = args[1];

        }else{
            System.err.println("There must be 2 args");
            System.exit(46);
        }
        System.out.println("User name: " + user);
        System.out.println("Password: " + password);

        try {
            people = directQuery(user, password, queryString);
        }catch(Exception e){
            System.err.println("ERROR: " + e.getMessage());
            System.exit(47);
        }
        System.out.println("Done!");
    }

    private static ArrayList<Person> directQuery(String user, String password, String queryString) throws SQLException {
        ArrayList<Person> list = new ArrayList<>();
        String host = "woz.csmp.missouriwestern.edu";
        int port = 3306;
        String database = "misc";
        String connectionString = String.format(
          "jdbc:mysql://%s:%d/%s",host,port,database);
        System.out.println("Connection String: "+connectionString);

        Connection connection = DriverManager.getConnection(connectionString,user,password);
        System.out.println("Connected successfully");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(queryString);
        while(rs.next()){
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            Person person = new Person();
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setEmail(email);
            list.add(person);
            System.out.println(person);
        }


        connection.close();
        return list;
    }
}
