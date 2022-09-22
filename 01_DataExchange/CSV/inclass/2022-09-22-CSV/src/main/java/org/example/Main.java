package org.example;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args ) {
        String fileName = "countries.csv";
        try {
            parseRecords(fileName);
            directToObject(fileName);
        }catch(Exception e){
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("DONE!");

    }

    private static void directToObject(String fileName) throws FileNotFoundException {
        ArrayList<Country> countries;
        countries = (ArrayList<Country>) new CsvToBeanBuilder<Country>(new FileReader(fileName))
                .withType(Country.class)
                .build()
                .parse();
        for(Country c:countries){
            System.out.println(c);
        }
    }

    public static void parseRecords(String fileName) throws IOException, CsvException {
        CSVReader reader;
        List<String[]> data;
        ArrayList<Country> countries = new ArrayList<>(200);

        reader = new CSVReader(new FileReader(fileName));
        data = reader.readAll();
        for(String[] record: data){
//            System.out.println(record);
//            for(String field: record) {
//                System.out.println("\t" +field);
//            }
            if (record.length != 7){
                System.err.println(record.length +" "+record[0]);
            }else{
                if(!record[0].equals("entity")) {
                    Country c = new Country();
                    c.setName(record[0]);
                    c.setUrl(record[1]);
                    c.setGec(record[2]);
                    c.setIso(record[3]);
                    c.setStanag(record[4]);
                    c.setInternet(record[5]);
                    c.setComment(record[6]);
                    System.out.println(c);
                    countries.add(c);
                }
            }

        }
    }
}
