package com.noynaert;

import com.noynaert.utility.Utility;

import java.sql.*;
import java.util.ArrayList;

/**
 * Creates a connection to a sqlite database.  It also creates a table
 * and inserts some data into it.
 */
public class App 
{
    private static Connection conn;
    private static String url = "jdbc:sqlite:resources/employees.db";

    public static void main( String[] args )
    {
        ArrayList<Employee> employees = new ArrayList<>();

        try{
            conn = DriverManager.getConnection(url);
            System.out.println("Opened database successfully");
            getEmployees(employees, "SELECT * FROM employees ORDER BY last_name, first_name");
            Utility.printList("Employees", employees);

            // Create a table for offices
            createOfficeTable();

            //insert some data into the offices table
            insertRecords();

            conn.close();
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        System.out.println( "Done!" );
    }
    public static void createOfficeTable()throws SQLException{
        String createTable = """
    CREATE TABLE IF NOT EXISTS offices (
    office_id INTEGER PRIMARY KEY AUTOINCREMENT,
    number text NOT NULL,
    office_type text,
    size real );
    """;
        Statement statement = conn.createStatement();
        statement.executeUpdate(createTable);
    }

    public static void insertRecords()throws SQLException{
        //Statement statement = conn.createStatement();
        PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO offices (number, office_type, size) VALUES (?, ?, ?)");
        ArrayList<Office> inputData = new ArrayList<>();
        inputData.add(new Office("101", "Window", 1000));
        inputData.add(new Office("201B", "Cubical", 63.5));
        inputData.add(new Office("301", "Corner", 1200));

        for(Office office : inputData){
            preparedStatement.setString(1, office.getNumber());
            preparedStatement.setString(2, office.getType());
            preparedStatement.setDouble(3, office.getSize());
            preparedStatement.executeUpdate();
        }
    }

    private static void getEmployees(ArrayList<Employee> employees, String query) throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while(resultSet.next()){
            String id = resultSet.getString("employee_id");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            int level = resultSet.getInt("level");
            double payrate = resultSet.getDouble("payrate");
            String hireDate = resultSet.getString("hire_date");

            employees.add(new Employee(id, first_name, last_name, level, payrate, hireDate));
        }
    }
}
