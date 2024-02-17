package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String minified = "{\"author\":\"Brandon Sanderson\",\"title\":\"The Way of Kings\",\"isbn\":\"9780765376671\",\"pages\":1008,\"publication date\":\"2014-03-04\",\"cosmere universe\":true,\"main characters\":[\"Kaladin\",\"Shallan\",\"Dalinar\",\"Szeth\"],\"publisher\":{\"name\":\"Tor Publishing Group\",\"location\":\"New York, New York\"}}";
        String beautified = """
                {
                  "author": "Brandon Sanderson",
                  "title": "The Way of Kings",
                  "isbn": "9780765376671",
                  "pages": 1008,
                  "publication date": "2014-03-04",
                  "cosmere universe": true,
                  "main characters": [
                    "Kaladin",
                    "Shallan",
                    "Dalinar",
                    "Szeth"
                  ],
                  "publisher": {
                    "name": "Tor Publishing Group",
                    "location": "New York, New York"
                  }
                }
                """;

        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode jsonNode = JsonUtility.parse(beautified);
            String author = jsonNode.get("author").asText();
            boolean cosmere = jsonNode.get("cosmere universe").asBoolean();
            int pages = jsonNode.get("pages").asInt();
            //var characters = jsonNode.get("main characters");
            ArrayNode characters = (ArrayNode) jsonNode.get("main characters");
//            List<String> characterList = new ArrayList<>();
//            for (JsonNode character : characters) {
//                characterList.add(character.asText());
//            }
//              String[] characterArray = mapper.readValue(minified, String[].class);
//              for(String s:characterArray)
//                  System.out.println("\t"+s);
            var publisherNode = jsonNode.get("publisher").asText();
            //Publisher publisher = publisherNode.read;

            System.out.println(author);
            System.out.println(cosmere);
            System.out.println(pages);
            System.out.println(characters);
        } catch (JsonProcessingException e) {
            System.err.println(e.getStackTrace());
            System.err.println(e.getMessage());
            System.exit(46);
        }


        System.out.println("Done!");
    }
}

class Publisher {
    private String name;
    private String location;

    public Publisher(String name, String location){
        setName(name);
        setLocation(location);
    }
    public Publisher(){
        this.name = "--";
        this.location = "--";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
