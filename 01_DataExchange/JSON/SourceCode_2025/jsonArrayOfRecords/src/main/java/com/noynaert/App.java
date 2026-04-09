package com.noynaert;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.io.File;

/**
 * This program illustrates using Jackson to iterate over a
 * JSON file and print out the individual records
 *
 * The program is set uses an class called Flintstone.
 */
public class App 
{
    public static void main( String[] args )
    {
        String filename = "resources/group.json";
        try {
            readAndPrintRecords(filename);
        }catch(Exception e) {
            System.err.println(e.getMessage());
            System.err.println("Aborting");
            System.exit(1);
        }

        System.out.println( "Done" );
    }

    private static void readAndPrintRecords(String filename) throws Exception{
        System.out.println("Reading file " + filename);

        // Open the file initialize the ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(new File(filename));

        if (node.isArray()) {  //The data is specified as an array, but it is good to check
           for(JsonNode record : node) {
               String name = record.get("name").asText();
               int age = record.get("age").asInt();
               Flintstone f = new Flintstone(name, age);
               System.out.println(f);
           }
        }else{
            throw new Exception("The data is not an array");
        }

        System.out.println("Finished reading the file");
    }
}
