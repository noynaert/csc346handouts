package edu.missouriwestern.noynaert.person;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;

public class FavoriteQuote implements Serializable {
    private String quote;
    private String author;
    private static ObjectMapper quoteMapper = new ObjectMapper();
    public String toJson(){
        try {
            return quoteMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static  FavoriteQuote fromJson(String jsonString){
        FavoriteQuote result = null;
        try {
            result = quoteMapper.readValue(jsonString, FavoriteQuote.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    public FavoriteQuote(){
        quote = "some fancy words go here";
        author = "whoever";
    }
    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "FavoriteQuote " +
                "quote='" + quote + '\'' +
                ", author='" + author + '\'' ;
    }
}
