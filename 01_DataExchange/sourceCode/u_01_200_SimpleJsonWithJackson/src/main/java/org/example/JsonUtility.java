package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtility {
    private static ObjectMapper mainObjectMapper = getMainObjectMapper();
    private static ObjectMapper  getMainObjectMapper(){
        mainObjectMapper = new ObjectMapper();
        mainObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        //We will add stuff here later
        return mainObjectMapper;
    }
    public static JsonNode parse(String source) throws JsonProcessingException {
        // ObjectMapper mainObjectMapper = getMainObjectMapper();
        return mainObjectMapper.readTree(source);
    }
}
