package com.noynaert.people;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;
public class PeopleList implements Runnable{

    private static ArrayList<Person> list;
    private static String fileName;

    public PeopleList(String fileName) {
        this.fileName = fileName;
        list = new ArrayList<>();
    }
    public ArrayList<Person> getList(){
        return list;
    }
    private static void readCSV(){
        try{
            String[] HEADERS = { "Name", "Height"};
            Reader in = new FileReader(fileName);
            CSVFormat csvFormat =  CSVFormat.DEFAULT.builder()
                    .setHeader(HEADERS)
                    .setSkipHeaderRecord(true)
                    .build();

            CSVParser parser = new CSVParser(in, CSVFormat.DEFAULT);

            List<CSVRecord> records = parser.getRecords();
            for (CSVRecord record : records) {
                String name = record.get(0);
                float height = (float)0.0;
                try {
                    height = Float.parseFloat(record.get(1));
                }catch(Exception e){
                    height=(float)0.0;
                }
                Person person = new Person(name, height);
                list.add(person);
            }

        }catch(Exception e){
            e.printStackTrace();
            System.err.println();
            System.err.println(e.getMessage());
            System.exit(47);
        }
    }
    @Override
    public void run() {
        System.out.println("Starting Read the CSV");
        readCSV();
        System.out.println("Finished reading the CSV");
    }
}
