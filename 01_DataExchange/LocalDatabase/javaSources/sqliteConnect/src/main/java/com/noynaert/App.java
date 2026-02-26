package com.noynaert;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Creates a connection to a sqlite database.  It also creates a table
 * and inserts some data into it.
 */
public class App 
{
    private static Connection conn;
    private static final String url = "jdbc:sqlite:resources/employees.db";

    public static void main( String[] args )
    {
        ArrayList<Employee> employees = new ArrayList<>();
        String pathToFiles = args[0];

        try{
            conn = DriverManager.getConnection(url);
            System.out.println("Opened database successfully");
//            getEmployees(employees, "SELECT * FROM employees ORDER BY last_name, first_name");
//            Utility.printList("Employees", employees);

            // Create a table for offices
            createOfficeTable();

            //insert some data into the offices table
            insertRecords();
            //addImages(pathToFiles);
            conn.close();
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        System.out.println( "Done!" );
    }

    private static void addImages(String pathToFiles) throws Exception{
       // Get a list of all the files in the directory
        List<File> files = getPictureFile(pathToFiles);
        System.out.println(files);

        //Get each file and add it to the database
        addImagesToDatabase(files);

    }

    private static void addImagesToDatabase(List<File> files) throws Exception {
        String createTable = """
    CREATE TABLE IF NOT EXISTS photoID (
    photo_id INTEGER PRIMARY KEY AUTOINCREMENT,
    filename TEXT NOT NULL,
    fileData BLOB
    )
    """;

    Statement statement = conn.createStatement();
    statement.executeUpdate(createTable);

    //for each file, add it to the database
        for(File file: files){
            System.out.println(file.getName());
            String fullPathName = file.getAbsolutePath();
            byte[] fileData = Files.readAllBytes(Paths.get(fullPathName));
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "INSERT INTO photoID (filename, fileData) VALUES (?, ?)");
            preparedStatement.setString(1, file.getName());
            FileInputStream byteStream = new FileInputStream(file);
            preparedStatement.setBinaryStream(2,byteStream,file.length());
            preparedStatement.executeUpdate();
        }
    }

    private static List<File> getPictureFile(String pathToFiles) {
        List<File> files = new ArrayList<>();
        File[] directory = new File(pathToFiles).listFiles();
        if(directory != null) {
            for (File file : directory) {
                if (file.isFile()) {
                    String extension = file.getName().substring(file.getName().lastIndexOf(".") + 1);
                    extension = extension.toLowerCase();
                    if(Arrays.asList("jpg", "jpeg", "png").contains(extension)){
                        files.add(file);
                    }
                }
            }
        }

        return files;
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

    public static void insertRecords() throws SQLException, IOException {
        //Statement statement = conn.createStatement();
        PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO offices (number, office_type, size) VALUES (?, ?, ?)");
// I moved this data to a file called offices.tdf
//        ArrayList<Office> inputData = new ArrayList<>();
//        inputData.add(new Office("101", "Window", 1000));
//        inputData.add(new Office("201B", "Cubical", 63.5));
//        inputData.add(new Office("301", "Corner", 1200));


        //Now I read the data from the file offices.tdf
//        for(Office office : inputData){
//            preparedStatement.setString(1, office.getNumber());
//            preparedStatement.setString(2, office.getType());
//            preparedStatement.setDouble(3, office.getSize());
//            preparedStatement.executeUpdate();
//        }

        BufferedReader input = new BufferedReader(new FileReader("resources/offices.tdf"));
        String line;
        while ((line = input.readLine()) != null) {
            Office oneOffice = makeOfficeFromLine(line);
            preparedStatement.setString(1, oneOffice.getNumber());
            preparedStatement.setString(2, oneOffice.getType());
            preparedStatement.setDouble(3, oneOffice.getSize());
            preparedStatement.executeUpdate();

        }

    }

    private static Office makeOfficeFromLine(String line) {
        int cursor = 0;
        Office o = new Office();
        o.setNumber(line.substring(cursor, cursor + 5));
        cursor += 5;
        o.setType(line.substring(cursor, cursor + 7));
        cursor += 7;
        String s = line.substring(cursor, cursor + 5);
        double squareFeet = Double.parseDouble(s);
        o.setSize(squareFeet);
        return o;
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
