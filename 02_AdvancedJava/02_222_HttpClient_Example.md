# 2.222 HttpClient Example

There are three classes we end up using, plus a couple of helpers.

- **HttpClient** This is the organizer for sending the request and getting the response.
- **HttpRequest** is sent by the client to the server
- **HttpResponse** Is sent by the server to the client

## Simple, unified URL

```java
public static String getBody (String url) throws Exception{
        String body = "No Content Yet";

        HttpClient client = HttpClient.newHttpClient();

        //Create the request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
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
    ```
    ## Discrete url and individual fields

    ``` public static String getBody (String url, String name, String email) throws Exception{
        String body = "No Content Yet";
        String query = "?";
//        query += "name=" + name +  "&";
//        query += "email="+email ;
        query += "name=" + URLEncoder.encode(name, "UTF-8") + "&";
        query += "email=" + URLEncoder.encode(email, "UTF-8");
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
```

## Passing a Map&lt;k,v&gt;

```java
//snippet from main:

    Scanner keyboard = new Scanner(System.in);
    System.out.print("Enter your name: ");
    name = keyboard.nextLine().trim();
    System.out.print("Enter your email: ");
    email = keyboard.nextLine().trim();

        Map<String,String> fields = new ConcurrentHashMap<>();
        fields.put("name", name);
        fields.put("email", email);



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
```