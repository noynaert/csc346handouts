# 01.230 Parsing Top Level Fields

[Jackson API Documentation](https://javadoc.io/doc/com.fasterxml.jackson.core)

## Dependencies

Two dependencies are needed (We will add a third one later):

Both dependencies are from the com.fasterxml.jackson.core

- jackson-core
- jackson-databind

## ObjectMapper

[ObjectMapper API documentation](https://javadoc.io/doc/com.fasterxml.jackson.core/jackson-databind/latest/index.html)

ObjectMapper is a major workhorse.

There are several ways to do it.  The cleanest is to make a class for ObjectMapper.  Usually, we only need one ObjectMapper.  Notice that the objectMapper is static.

```java
/**
 * JsonUtility is a utility class that provides methods for working with JSON data.
 *
 * There is one static mapper for the entire class.  It is created in the default constructor for the class.
 */


public class JsonUtility {
    private static ObjectMapper mainObjectMapper = getMainObjectMapper();
    private static ObjectMapper getMainObjectMapper(){
        mainObjectMapper = new ObjectMapper();
        // Add some modifiers here
        return mainObjectMapper;
    }

    /**
     * Parses a JSON string and returns the corresponding JsonNode object.
     *
     * @param source a JSON string to be parsed
     * @return the JsonNode object representing the parsed JSON string
     * @throws JsonProcessingException if there is an error while parsing the JSON string
     */
    public static JsonNode parse(String source) throws JsonProcessingException {
       return mainObjectMapper.readTree(source);
    }
}
```

Here is the essence of the main() method.  To keep it simple, everything is happening in main, and the json is coming from a String literal.

```java
public static void main(String[] args) {

        String jsonString = """
                {
                    "author":"Brandon Sanderson",
                    "pages": 1008
                }""";

       // System.out.println(multiLine);

        try {
            JsonNode jsonNode = objectMapper.readTree(jsonString);
            
            var author = jsonNode.get("author").asText();
            System.out.println(author);
            var pages = jsonNode.get("pages").asInt();
            System.out.println(pages);
            
        } catch (JsonProcessingException e) {
            e.getMessage();
            e.printStackTrace();
            System.exit(46);
        }
        System.out.println("Done!");
    }
    ```
