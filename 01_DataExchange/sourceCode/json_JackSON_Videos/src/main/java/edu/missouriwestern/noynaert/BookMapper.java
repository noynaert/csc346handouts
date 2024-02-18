package edu.missouriwestern.noynaert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BookMapper {
    private static ObjectMapper bookMapper = getBookMapper();
    private static ObjectMapper getBookMapper(){
        if (bookMapper == null) {
            bookMapper = new ObjectMapper();
        }

        // add customization configuration to handle books.

        return bookMapper;
    }
    public static JsonNode parse(String jsonString) throws JsonProcessingException {
        JsonNode result;
        result = getBookMapper().readTree(jsonString);
        return result;
    }

}
