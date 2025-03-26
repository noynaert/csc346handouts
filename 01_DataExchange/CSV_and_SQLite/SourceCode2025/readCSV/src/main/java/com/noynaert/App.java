package com.noynaert;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.CSVReaderHeaderAwareBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

        ArrayList<Map<String,String>> people = new ArrayList<>();
        readLines(people);
        //readAll();
        System.out.println("Done!");
    }
    public static void readAll(){
        try {

            String fileName="birthdays.csv";
            BufferedReader reader =
                    new BufferedReader(new FileReader(fileName));
            CSVParser parser = new CSVParserBuilder().withSeparator(',')
                    .withSeparator(':')
                    .withQuoteChar('"')
                    //.withIgnoreQuotations(true)
                    .build();
            CSVReaderHeaderAware csvReader = new CSVReaderHeaderAware(reader);
           List<String[]> list = csvReader.readAll();

           for(String[] record:list){
               String person = record[0];
               String birthday = record[1];
               int id = Integer.parseInt(record[2]);
               System.out.printf("%s was born on %s and has an id of %d\n",person,birthday,id);
           }

            reader.close();
            System.out.println("Almost Done!");
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    public static void readLines(ArrayList<Map<String,String>> people){
        try {

            String fileName="birthdays.csv";
            BufferedReader reader =
                    new BufferedReader(new FileReader(fileName));
            CSVParser parser = new CSVParserBuilder().withSeparator(',')
                    .withSeparator(':')
                    .withQuoteChar('"')
                    //.withIgnoreQuotations(true)
                    .build();
            CSVReaderHeaderAware csvReader = new CSVReaderHeaderAware(reader);
            Map<String,String> record;
            while ((record = csvReader.readMap()) != null) {
                //System.out.println(record);
                String person = record.get("Name");
                String birthday = record.get("Birthday");
                int id = Integer.parseInt(record.get("ID"));
                people.add(record);
                System.out.printf("%s was born on %s and has an id of %d\n",person,birthday,id);
            }
            reader.close();
            System.out.println("Almost Done!");
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
