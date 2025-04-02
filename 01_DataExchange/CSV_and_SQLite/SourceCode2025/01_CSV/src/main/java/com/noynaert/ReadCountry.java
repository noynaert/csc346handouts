package com.noynaert;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ReadCountry {
    public static void main(String[] args) {
        String fileName = "countries.csv";
        ArrayList<Country> countries;
        countries = readCountries(fileName);

    }
    static ArrayList<Country> readCountries(String fileName) {
        ArrayList<Country> countries = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            CsvToBean<Country> CsvReader = new CsvToBeanBuilder<Country>(reader)
                    .withType(Country.class)
                    .withSeparator(',')
                    .build();

            countries = (ArrayList<Country>) CsvReader.parse();

            for(Country country : countries){
                System.out.println(country);
            }

            reader.close();
            System.out.println("Done with readCounties ");
        }catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return countries;
    }
}
