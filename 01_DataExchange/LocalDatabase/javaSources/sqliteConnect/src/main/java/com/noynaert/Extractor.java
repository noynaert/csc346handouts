package com.noynaert;

import com.noynaert.utility.Utility;

import java.io.File;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Extractor {
    private static Connection conn;
    private static String url = "jdbc:sqlite:resources/employees.db";

    public static void main(String[] args) {
        System.out.println("Extracting images");
        String outputPath = "resources"+ File.separator;

        try {
            conn = DriverManager.getConnection(url);

            PreparedStatement preparedStatement = conn.prepareStatement("SELECT filename, fileData FROM photoID");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String filename = resultSet.getString("filename");
                byte[] fileData = resultSet.getBytes("fileData");
                File outputFile = new File(outputPath + filename);
                Files.write(outputFile.toPath(),fileData);
                System.out.println("Extracted " + filename);
            }
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
