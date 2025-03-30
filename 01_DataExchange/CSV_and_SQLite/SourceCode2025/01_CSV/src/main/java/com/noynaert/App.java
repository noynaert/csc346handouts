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
        ArrayList<Map<String, String>> people = new ArrayList<>();
        readLines(fileName, people);
        people.clear();
        readAsArrayOfStrings(fileName);
        System.out.println("Done!");
    }

    public static void readAsArrayOfStrings(String fileName) {
        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader(fileName));
            CSVParser parser = new CSVParserBuilder().withSeparator(',')
                    .withSeparator(':')
                    .withQuoteChar('"')
                    //.withIgnoreQuotations(true)
                    .build();
            CSVReaderHeaderAware csvReader = new CSVReaderHeaderAware(reader);
            List<String[]> list = csvReader.readAll();

            for (String[] record : list) {
                String person = record[0];
                String birthday = record[1];
                int id = Integer.parseInt(record[2]);
                System.out.printf("%s was born on %s and has an id of %d\n", person, birthday, id);
            }

            reader.close();
            System.out.println("Almost Done!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void readLines(String fileName,ArrayList<Map<String, String>> people) {
        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader(fileName));
            CSVParser parser = new CSVParserBuilder().withSeparator(',')
                    .withSeparator(':')
                    .withQuoteChar('"')
                    //.withIgnoreQuotations(true)
                    .build();
            CSVReaderHeaderAware csvReader = new CSVReaderHeaderAware(reader);
            Map<String, String> record;
            while ((record = csvReader.readMap()) != null) {
                //System.out.println(record);
                String name = record.get(" Full Name");
                String birthday = record.get("Birthday (Gregorian Calendar)");
                int id = Integer.parseInt(record.get("id"));
                people.add(record);
                System.out.printf("%s was born on %s and has an id of %d\n", name, birthday, id);
            }
            reader.close();
            System.out.println("Almost Done!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
