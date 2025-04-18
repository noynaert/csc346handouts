package com.noynaert;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.bean.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
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
//        ArrayList<Map<String, String>> people = new ArrayList<>();
//        readMaps(fileName, people);

        // Read CSV file as an array of strings
//        ArrayList<String[]> people = new ArrayList<>();
//        readStrings(fileName, people);


  //       ArrayList<Person> people = read2BeanWithMap(fileName);
  //      ArrayList<Person> people = fuzzyRead2Bean(fileName);
          ArrayList<Person> people = read2BeanWithAnnotations(fileName);

        System.out.println("Done!");
    }
    public static ArrayList<Person> read2BeanWithAnnotations(String fileName) {
        ArrayList<Person> people = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            CsvToBean<Person> CsvReader = new CsvToBeanBuilder<Person>(reader)
                    .withType(Person.class)
                    .withSeparator(',')
                    .withSkipLines(1)
                    .build();

            people = (ArrayList<Person>) CsvReader.parse();

            for(Person person : people){
                System.out.println(person);
            }

            reader.close();
            System.out.println("Done with read2BeanWithMap");
        }catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return people;
    }


    public static ArrayList<Person> fuzzyRead2Bean(String fileName) {
        ArrayList<Person> people = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            MappingStrategy<Person> strategy = new FuzzyMappingStrategyBuilder<Person>()
                    .build();

            strategy.setType(Person.class);

            CsvToBean<Person> CsvReader = new CsvToBeanBuilder<Person>(reader)
                    .withType(Person.class)
                    .withSeparator(',')
                    .withMappingStrategy(strategy)
                    .build();

            people = (ArrayList<Person>) CsvReader.parse();

            for(Person person : people){
                System.out.println(person);
            }

            reader.close();
            System.out.println("Done with read2BeanWithMap");
        }catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return people;
    }

    public static ArrayList<Person> read2BeanWithMap(String fileName) {
        ArrayList<Person> people = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            Map<String,String> columnMap = new HashMap<>();
            columnMap.put(" Full Name", "name");
            columnMap.put("Birthday (Gregorian Calendar)", "birthday");
            columnMap.put("id", "id");
            columnMap.put("Country", "country");

            HeaderColumnNameTranslateMappingStrategy<Person> strategy = new HeaderColumnNameTranslateMappingStrategy<>();
            strategy.setType(Person.class);
            strategy.setColumnMapping(columnMap);

            CsvToBean<Person> CsvReader = new CsvToBeanBuilder<Person>(reader)
                    .withType(Person.class)
                    .withSeparator(',')
                    .withMappingStrategy(strategy)
                    .build();

            people = (ArrayList<Person>) CsvReader.parse();

            for(Person person : people){
                System.out.println(person);
            }

            reader.close();
            System.out.println("Done with read2BeanWithMap");
        }catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return people;
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
                people.add(record);
            }

            //Print the data in a loop
            for (Map<String, String> person : people) {
                String name = person.get(" Full Name");
                String birthday = person.get("Birthday (Gregorian Calendar)");
                int id = Integer.parseInt(person.get("id"));
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

            //print the list
            for (String[] person : people) {
                String name = person[0];
                String birthday = person[1];
                int id = Integer.parseInt(person[2]);
                System.out.printf("%s was born on %s and has id %d\n", name, birthday, id);
            }

            reader.close();
            System.out.println(" Done with readStrings");
        }catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


    }

}
