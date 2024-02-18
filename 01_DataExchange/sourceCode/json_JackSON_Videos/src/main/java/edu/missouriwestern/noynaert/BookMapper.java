package edu.missouriwestern.noynaert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.missouriwestern.noynaert.book.Publisher;

import java.io.File;
import java.io.IOException;

public class BookMapper {
    private static ObjectMapper bookMapper = getBookMapper();
    private static ObjectMapper getBookMapper(){
        if (bookMapper == null) {
            bookMapper = new ObjectMapper();
        }

        // add customization configuration to handle books.
        bookMapper.registerModule(new JavaTimeModule());
        bookMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);

        return bookMapper;
    }
    public static JsonNode parse(String jsonString) throws JsonProcessingException {
        JsonNode result;
        result = getBookMapper().readTree(jsonString);
        return result;
    }
    public static<T> String toJson(T t) throws JsonProcessingException {
        String result = "{}";
        result = bookMapper.writeValueAsString(t);
        return result;
    }
    public static<T> void toJson(T t, String outputFileName) throws IOException {
        bookMapper.writeValue(new File(outputFileName),t);
    }
    public static <T> String toJsonPretty(T t) throws JsonProcessingException{
        String pretty = "{}";
        pretty = bookMapper.writerWithDefaultPrettyPrinter().writeValueAsString(t);
        return pretty;
    }
    public static<T> void toJsonPretty(T t, String outputFileName) throws IOException {
        bookMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFileName),t);
    }

}
