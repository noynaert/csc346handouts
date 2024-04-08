package com.noynaert;

import com.noynaert.people.Person;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class H2personDB implements Runnable {
    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:./personDB";

    private static final String USER = "sa";
    private static final String PASSWORD = "";

    private static Connection connection = null;
    private static Statement statement = null;

    public static void getConnection() {
        connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            if (connection == null)
                System.out.println("Connection to DB Failed.");
            else
                System.out.println("Connection to DB Successful.");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println();
            System.err.println(e.getMessage());
        }
    }

    public static void close() {
        try {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
            System.out.println("The Database is closed");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println();
            System.err.println(e.getMessage());
        }
    }

    public void createTable() {
        String sqlString = "";
        boolean success = false;
        try {
            statement = connection.createStatement();

            //Drop Table, if it exists
            sqlString = "DROP TABLE IF EXISTS people";
            success = statement.execute(sqlString);
            System.out.println("Drop Table: " + success);

            //Create the people table
            sqlString =
                    """
                            CREATE TABLE people(
                               id INT PRIMARY KEY AUTO_INCREMENT,
                               name VARCHAR(255),
                               height float
                            )
                            """;
            success = statement.execute(sqlString);
            System.out.println("Create Table: " + success);


        } catch (Exception e) {
            e.printStackTrace();
            System.err.println();
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        System.out.println("Starting the connection to the DB");
        getConnection();
        createTable();
        System.out.println("Done with getting the connection to the DB");
    }

       public void insertRecords(ArrayList<Person> people) {

        try{
            statement = connection.createStatement();
            for(Person person:people){
                String sqlString = String.format("INSERT INTO people (name, height) VALUES ('%s',%1.1f)",person.getName(),person.getHeight());
                statement.executeUpdate(sqlString);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println();
            System.err.println(e.getMessage());
        }
    }

    public ArrayList getList(String sqlString) {
        ArrayList<Person> list = new ArrayList<>();
        System.out.println(sqlString);

        try{
            getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlString);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double height = resultSet.getDouble("height");
                Person person = new Person(name, height);
                list.add(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println();
            System.err.println(e.getMessage());
        }
        return list;
    }
}
