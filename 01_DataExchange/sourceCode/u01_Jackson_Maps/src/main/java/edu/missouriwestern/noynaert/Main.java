package edu.missouriwestern.noynaert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        //demoMaps();
        String jsonString = """
                {
                  "name" : "Fred",
                  "age" : 29,
                  "occupation" : {
                    "title" : "Heavy Equipment Operator",
                    "payRate" : 30.00
                  }
                }
                """;

                try{
                    doJson(jsonString);
                }catch(Exception e){
                    e.printStackTrace();
                    System.err.println(e.getMessage());
                    System.exit(46);
                }



        System.out.println("Done!");
    }
    public static void doJson(String jsonString) throws Exception{
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String,Object> map = objectMapper.readValue(jsonString, HashMap.class);

            for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));

            System.out.printf("My name is %s and I am %d years old\n", map.get("name"), map.get("age"));

            //get the Occupation
                Map<String, Object> occupation = (HashMap<String, Object>) map.get("occupation");
                System.out.printf("The occupation \"%s\" pays $%1.2f per hour\n", occupation.get("title"), occupation.get("payRate"));
        }
    }

    public static void demoMaps(){
        ArrayList<String> food = new ArrayList<>();

        food.add("Apple");
        food.add("Banana");
        food.add(2,"Orange");
        food.add(3,"Tomato");
        //food.add( 6, "Grape");

        for(String s : food){
            System.out.println(s);
        }
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("------Maps");
        Map<String,Double> favoriteNumbers = new TreeMap<>();
        favoriteNumbers.put("One", 1.0);
        favoriteNumbers.put("Two", 2.0);
        favoriteNumbers.put("Three", 3.0);
        favoriteNumbers.put("Pi", 3.14159);
        favoriteNumbers.put("E", Math.E);

        System.out.println( "Favorite is really " + favoriteNumbers.get("Pi"));

        for(String k : favoriteNumbers.keySet()){
            System.out.printf("%s is %f\n", k, favoriteNumbers.get(k));
        }
        System.out.println("Just the keys");
        for(String k: favoriteNumbers.keySet()){
            System.out.println(k);
        }
        System.out.println("Just the values");
        for(Double v : favoriteNumbers.values()){
            System.out.println(v);
        }


    }
}
