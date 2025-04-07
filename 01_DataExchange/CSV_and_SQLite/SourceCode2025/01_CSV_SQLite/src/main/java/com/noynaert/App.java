package com.noynaert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Program to illustrate doing a query on an SQLite database
 *
 * @since April, 2025
 * @author J. Evan Noynaert
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try{
            String dbURL = "jdbc:sqlite:zipcodes.db";
            Connection connection = DriverManager.getConnection(dbURL);

            String queryString = "SELECT * FROM places";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryString);

            while(resultSet.next()){
                String zipCode = resultSet.getString("zipcode");
                String place = resultSet.getString("place");
                String state = resultSet.getString("state");
                Double latitude = resultSet.getDouble("latitude");
                Double longitude = resultSet.getDouble("longitude");

                System.out.println(zipCode + " " + place + " " + state + " " + latitude + " " + longitude);
            }
            connection.close();

        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }


        System.out.println( "Done!" );
    }
}
