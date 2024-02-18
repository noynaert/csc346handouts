package edu.missouriwestern.noynaert;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import edu.missouriwestern.noynaert.book.*;

import static edu.missouriwestern.noynaert.BookMapper.*;

/**
 * This program demonstrates the use of Jackson to interact with
 * JSon.
 *
 * This program focuses on configuring the ObjectMapper.  Use of Annotations to do similar things is ignored in this set of demonstrations.
 *
 * <ol>
 *     <li>Reading individual fields</li>
 *     <li>Serializing a simple POJO to JSon</li>
 *     <li>Handling objects that contain LocalDate fields</li>
 *     <li>Deserializing a simple JSON string to a POJO</li>
 *     <li>Handing JSON fields to be ignored</li>
 *     <li>Renaming JSON fields that do not match the POJO</li>
 *     <li>Handling arrays in JSON</li>
 *     <li>Handling nested objects</li>
 *     <li>Moving Serialization/Deserialization into the POJO</li>
 * </ol>
 *
 * @author J. Evan Noynaert
 * @since February, 2024
 */

public class Main {
    public static void main(String[] args) {
        String inputFileName = "data/publisher.json";

        try {
            String jsonString = readJsonString(inputFileName);
            System.out.println("The input file is : "+jsonString);

            //Read the fields from the publisher json
            demoFetchFields(jsonString);

            //Serialization (toJson)
         //   demoToJson();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            //System.exit(46);
        } finally {
            System.out.println("Almost Done");
        }
        System.out.println(" \uD83D\uDD6E Done! \uD83D\uDD6E");
    }

    private static void demoToJson() throws Exception {
        //set up the object
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Book");
        publisher.setLocation("Westminster, London");

        //Serialize to an minified string
        String jsonString = BookMapper.toJson(publisher);
        System.out.println("As a minified String: " + jsonString);
        jsonString = BookMapper.toJsonPretty(publisher);
        System.out.println("As a pretty String: " + jsonString);

        //Output to a file
        BookMapper.toJson(publisher, "dataOut/publisher.json");
        BookMapper.toJsonPretty(publisher, "dataOut/publisherPretty.json");

        //Configuring BookMapper
        Book book = new Book();
        book.setAuthor("Sanderson, Brandon");
        book.setTitle("Words of Radiance");
        book.setPublication(LocalDate.of(2014,05,04));
        book.setPages(1088);
        System.out.println("Book as json: " + BookMapper.toJsonPretty(book));



    }


    private static void demoFetchFields(String jsonString) throws IOException {
        System.out.println("Fetching two fields:");
        JsonNode theTree = BookMapper.parse(jsonString);
        String name = theTree.get("name").asText();
        String location = theTree.get("location").asText();
        System.out.println("The name is " + name);
        System.out.println("The location is " + location);
   }

    public static String readJsonString(String fileName) throws Exception{
        String result = "";
        Scanner input = new Scanner(new File(fileName));
        while(input.hasNextLine()){
            result += input.nextLine();
        }
        return result;
    }
}
