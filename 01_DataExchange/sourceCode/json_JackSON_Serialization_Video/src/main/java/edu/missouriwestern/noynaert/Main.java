package edu.missouriwestern.noynaert;

import edu.missouriwestern.noynaert.ipAddress.Location;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        String address = "https://ipapi.co/json/";
        Location location = new Location();
        System.out.println(location);
        System.out.println();

        try {
            String jsonString = sendHttpRequest(address);
            System.out.println("Raw JSON: "+jsonString+"\n============");
            System.out.println("-------");
            System.out.println(location);
            location = Location.fromJson("As an object: " +jsonString);
            System.out.println("As JSON: " +location.toJson());


        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            System.exit(46);
        }


        System.out.println("\uD83C\uDF10 Done! \uD83C\uDF10");
    }

    public static String sendHttpRequest(String address) throws IOException {
        String jsonString = "{}";
        URL url = new URL(address);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent","Mozilla/5.0");
        int responseCode = connection.getResponseCode();
        System.out.println("The response code is " + responseCode);
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        jsonString = response.toString();
        return jsonString;
    }
}
