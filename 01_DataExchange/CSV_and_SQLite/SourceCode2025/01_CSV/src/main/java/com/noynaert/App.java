package com.noynaert;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderHeaderAware;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Demonstrates various methods of reading and writing CSV files
 *
 * @author J. Evan Noynaert
 * @since March 2025
 */
public class App {
    public static void main(String[] args) {
        String fileName = "birthdays.csv";

           //Read an ArrayList of maps.  Each record is a map.
        ArrayList<Map<String, String>> people = new ArrayList<>();
        readMaps(fileName, people);

        //Read an ArrayList of arrays of Strings.  Each record is an array of string
        //No labels are involved, everything is positional
//        ArrayList<String[]> people = new ArrayList<>();
//        readStrings(fileName, people);



        System.out.println("Done!");
    }

    public static void readMaps(String fileName, ArrayList<Map<String, String>> people) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(',')
                    .withQuoteChar('"')
                    .withIgnoreQuotations(true)
                    .build();
            CSVReaderHeaderAware csvReader = new CSVReaderHeaderAware(reader);

            Map<String, String> record;
            while ((record = csvReader.readMap()) != null) {
                String name = record.get(" Full Name");
                String birthday = record.get("Birthday (Gregorian Calendar)");
                int id = Integer.parseInt(record.get("id"));
                people.add(record);
                System.out.printf("%s was born on %s and has id %d\n", name, birthday, id);
            }

            reader.close();
            System.out.println("\uD83D\uDDFA\uFE0F Done with readMaps \uD83D\uDDFA\uFE0F");
        }catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static void readStrings(String fileName, List<String[]> people) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(',')
                    .withQuoteChar('"')
                    .withIgnoreQuotations(true)
                    .build();
            CSVReaderHeaderAware csvReader = new CSVReaderHeaderAware(reader);

            people.addAll(csvReader.readAll());

            for (String[] record : people) {
                String name = record[0];
                String birthday = record[1];
                int id = Integer.parseInt(record[2]);
                System.out.printf("%s was born on %s and has id %d\n", name, birthday, id);
            }

            reader.close();
            System.out.println(" Done with readStrings");
        }catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


    }

}
