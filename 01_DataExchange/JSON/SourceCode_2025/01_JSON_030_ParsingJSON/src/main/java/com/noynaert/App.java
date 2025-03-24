package com.noynaert;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

/**
 * Illustrates parsing JSON by fields
 *
 */
public class App 
{
    public static void main( String[] args ) {
        try {
            String fileName = "person.json";

            ObjectMapper objectMapper = new ObjectMapper();

            //Getting single fields as text and as integer
            JsonNode rootNode = objectMapper.readTree(new File(fileName));
            String name = rootNode.get("name").asText();
            int age = rootNode.get("age").asInt();
            System.out.printf("Name: %s, Age: %d\n", name, age);

            //Getting an array
            String[] children = objectMapper.readValue(rootNode.get("children").toString(), String[].class);
            for (String child : children) {
                System.out.println("\tChild: " + child);
            }
            JsonNode friendsNode = rootNode.get("friends");
            for (JsonNode friend : friendsNode) {
                String friendName = friend.get("name").asText();
                System.out.println("\tFriend: "+ friendName);
                if (friend.has("age")) {
                    int friendAge = friend.get("age").asInt();
                    System.out.println("\t\tAge: " + friendAge);
                }
            }
            System.out.println("Done!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
