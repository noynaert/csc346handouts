package com.noynaert;

import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;
import com.opencsv.bean.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This program reads both of the files and creates a full person.
 * <p>
 * It also illustrates the use of an Iterator
 *
 * @author J. Evan Noynaert
 * @since April 2024
 */


public class ReadBothFiles {
    public static void main(String[] args) {
        ArrayList<Person> people = readBirthdays("birthdays.csv");
        addCountries("countries.csv", people);
        printPeople(people);
        createPeopleCSV("people.csv", people);
        System.out.println("Done");
    }

    private static void addCountries(String fileName, ArrayList<Person> people) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            CsvToBean<Country> CsvReader = new CsvToBeanBuilder<Country>(reader)
                    .withType(Country.class)
                    .withSeparator(',')
                    .build();

            Iterator<Country> iterator = CsvReader.iterator();
            while (iterator.hasNext()) {
                Country country = iterator.next();
                //System.out.println(country);
//                    for(Person person: people)
//                        if(person.getName().equalsIgnoreCase(country.getPerson())){
//                            person.setCountry(country.getCountry());
//                        }
                boolean found = false;
                Iterator<Person> personIterator = people.iterator();
                while (personIterator.hasNext() && !found) {
                    Person person = personIterator.next();
                    if (person.getName().equalsIgnoreCase(country.getPerson())) {
                        person.setCountry(country.getCountry());
                        found = true;
                    }
                }

            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void printPeople(ArrayList<Person> people) {
        if (people != null)
            for (Person person : people) {
                System.out.println(person);
            }
    }

    private static ArrayList<Person> readBirthdays(String fileName) {
        ArrayList<Person> people = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            CsvToBean<Person> CsvReader = new CsvToBeanBuilder<Person>(reader)
                    .withType(Person.class)
                    .withSeparator(',')
                    .withSkipLines(1)
                    .build();

            people = (ArrayList<Person>) CsvReader.parse();

            reader.close();
            System.out.println("Done with read2BeanWithMap");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return people;
    }

    private static void createPeopleCSV(String fileName, ArrayList<Person> people) {
            try{
                HeaderColumnNameTranslateMappingStrategy<Person> strategy = new HeaderColumnNameTranslateMappingStrategyBuilder<Person>()
                        .build();
                strategy.setType(Person.class);

                FileWriter fileWriter = new FileWriter(fileName);
                StatefulBeanToCsv<Person> beanToCvs = new StatefulBeanToCsvBuilder<Person>(fileWriter)
                        .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                        .withSeparator('|')
                       // .withMappingStrategy(strategy)
                        .build();
                beanToCvs.write(people);
                fileWriter.close();
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
    }
}
