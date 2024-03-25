package edu.missouriwestern.noynaert;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        String address = "http://woz.csmp.missouriwestern.edu/formDemo/processForm.php";
        String name;
        String email;

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = keyboard.nextLine().trim();
        System.out.print("Enter your email: ");
        email = keyboard.nextLine().trim();

        Map<String,String> fields = new ConcurrentHashMap<>();
        fields.put("name", name);
        fields.put("email", email);

        try{
            String body = getBody(address, fields);
            System.out.println("The body code is:\n " + body );
        }catch(Exception e){
            e.printStackTrace();
            System.err.println(e.getMessage());
            System.exit(46);
        }

        System.out.println("Done!");
    }


    //model: ?name=abc&email=def

    public static String getBody (String url, Map<String,String> fields) throws Exception{
        String body = "No Content Yet";
        String query = "?";

        for(String key: fields.keySet()){
            String encodedValue = URLEncoder.encode(fields.get(key));
            if(query.length() > 1)
                query += "&";
            query += key+"="+encodedValue;
        }
        System.out.println("The query is " + query  );
        String fullURL = url+query;

        HttpClient client = HttpClient.newHttpClient();

        //Create the request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(fullURL))
                .GET()
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .build();

        //fetch the response from the server
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //get status and take appropriate actions
        int statusCode = response.statusCode();
        System.out.printf("The status code is %d\n", statusCode);
        if(statusCode >=200 && statusCode <= 299){
            body = response.body();
        }

        return body;
    }
}
