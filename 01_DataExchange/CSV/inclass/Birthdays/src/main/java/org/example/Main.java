package org.example;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        Scanner keyboard = new Scanner(System.in);
//        System.out.println ("Type something. ");
//        String someRandomString = keyboard.nextLine()
//                .trim()
//                .replaceAll(" ", "_")
//                .toUpperCase(Locale.ROOT);
        // System.out.println(someRandomString);

//        Birthday b = new Birthday();
//        System.out.println(b);

        ArrayList<Birthday> people;
        String fileName = "birthdays.csv";
        people = getPeople(fileName);

        Collections.sort(people);
    print("The string-based array list", people);

        System.out.println("Goodbye world!");
    }

    private static <E> void print(String message, List<E> people) {
        System.out.printf("------- %s (%d Records) -------", message, people.size());
        for(E e:people){
            System.out.println(e);
        }
    }

    private static ArrayList<Birthday> getPeople(String fileName) {
        ArrayList<Birthday> list = null;
        try{

            Reader reader = new FileReader(fileName);
            CsvToBean<Birthday> bean =new CsvToBeanBuilder<Birthday>(reader)
                    .withType(Birthday.class)
                    .withSkipLines(1)
                    .withSeparator(':')
                    .withQuoteChar('\'')
                    .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
                    .build();
            list = (ArrayList<Birthday>) bean.parse();

        }catch(Exception e){
            System.err.println(e.getMessage());
            System.err.println(e.getStackTrace());
            System.exit(1);
        }

        return list;
    }
}
