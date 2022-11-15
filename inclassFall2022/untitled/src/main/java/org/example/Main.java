package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileName = "credentials.txt";
        ArrayList<Person> people;

        try {
            people = getPeople(fileName);
            for(Person pn : people){
                System.out.println(pn);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Hello world!");
    }

    private static ArrayList<Person> getPeople(String fileName) throws SQLException {
        ArrayList<Person> people = new ArrayList<>();
        String connectionString = "jdbc:mariadb://woz.csmp.missouriwestern.edu:3306/misc";
        String queryString = "SELECT * from fakePeople WHERE state like ? AND city LIKE ?";

        Credentials woz = new Credentials(fileName);
        System.out.println(woz.host);

        Connection connection = DriverManager.getConnection(connectionString,woz.user, woz.password);

//        Statement foundation  = connection.createStatement();
//        ResultSet rs = foundation.executeQuery(queryString);
          PreparedStatement preparedStatement = connection.prepareStatement(queryString);

          preparedStatement.setString(1,"IL");
          preparedStatement.setString(2,"Chicago");

        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()){
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String state = rs.getString("state");
            String city = rs.getString("city");

            Person person = new Person(firstName,lastName,city,state);
            people.add(person);

        }

        return people;
    }

    static class Credentials{
        String user;
        String password;
        String host;
        public Credentials(String fileName){
//            try {
//                Scanner input = new Scanner(new File(fileName));
//                user = input.nextLine().trim();
//                password = input.nextLine().trim();
//                host=input.nextLine().trim();
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            }
              host="woz.csmp.missouriwestern.edu";
              user="csc";
              password="sandy2714288";

        }
    }

}
