package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Credentials woz = new Credentials();
        System.out.println ( woz.host);

        String connectionSting = String.format("jdbc:mysql://%s:3306/misc", woz.host);
        System.out.println("Connect String: " + connectionSting);

        String query = "select state, capital_city, nickname, population from states where state like 'M%'";

        try {
            Connection con = DriverManager.getConnection(connectionSting, woz.user, woz.password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String stateName = rs.getString(1);
                String nickName = rs.getString("nickname");
                String capital = rs.getString("capital_city");
                long population = rs.getLong("population");
                System.out.printf("%-14s %-14s %10d %s\n", stateName,capital, population, nickName);
                //states.add(new State(stateName, capital, population,nickName);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Goodbye, world!");
    }
    static class Credentials{
        String user;
        String password;
        String host;
        public Credentials(){
            try {
                Scanner input = new Scanner(new File("credentials.txt"));
                user = input.nextLine().trim();
                password = input.nextLine().trim();
                host = input.nextLine().trim();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
