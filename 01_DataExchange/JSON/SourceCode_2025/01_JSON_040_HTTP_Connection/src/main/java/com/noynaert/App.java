package com.noynaert;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Demonstrates reading from API using HTTP Connection
 *
 * @since March, 2025
 * @author J. Evan Noynaert
 *
 */
public class App {
    static final String USER_AGENT="Mozilla/5.0";
    static String baseURL = "https://catfact.ninja/fact?max_length=60";
    static int responseCode=0;

    public static void main( String[] args )
    {
        String jsonResult = sendGet(5,59,"How long is a cat's tail?");
        printTheFact(jsonResult);

        System.out.println( "Done!" );
    }

    private static String sendGet(int limit, int max_length, String question) {
        String jsonResult = null;
        try{
            //set up the HTTP Header
            String urlString = makeURL(baseURL,max_length, limit, question);
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", USER_AGENT);

            //Make the connection
            responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            //Process the data
            if(responseCode==200){
                StringBuffer response = new StringBuffer();
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                jsonResult = response.toString();
            }
            System.out.println(jsonResult);
        }catch(Exception e){
            System.err.println( e.getMessage() );
            System.exit(1);
        }

        return jsonResult;
    }

    private static String makeURL(String baseURL, int maxLength, int limit, String question) {
        String url = "";
        Map<String,String> parameters= new LinkedHashMap<>();
        parameters.put("max_length", Integer.toString(maxLength));
        parameters.put("limit", Integer.toString(limit));
        parameters.put("question", question);

        StringBuilder builder = new StringBuilder(baseURL);
        for(String key: parameters.keySet()){
            builder.append((builder.length()==0) ? "?" : "&");
            String value = parameters.get(key);
            builder.append(key);
            builder.append("=");
            value = URLEncoder.encode(value);
            builder.append(value);
        }
        url = builder.toString();
        System.out.println(url);

        return url;
    }

    private static void printTheFact(String jsonResult) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = mapper.readTree(jsonResult);
            String fact = rootNode.get("fact").asText();
            int length = rootNode.get("length").asInt();
            System.out.printf("\"%s\" (%d chars)\n", fact, length);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
