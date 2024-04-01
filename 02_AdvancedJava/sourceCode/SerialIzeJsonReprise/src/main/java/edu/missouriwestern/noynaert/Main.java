package edu.missouriwestern.noynaert;

import com.fasterxml.jackson.core.type.TypeReference;
import edu.missouriwestern.noynaert.person.Person;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {

        Person fred = new Person();
        fred.setName("Fred");
        fred.setAge(29);


        System.out.println(fred);
        Person mystery = new Person();
        System.out.println(mystery);
        String spouseString = """
                { "name":"Wilma" , "age":30}
                """;

        try {
            String jsonString = fred.toJson();
            System.out.println("The json is \n" + jsonString);
            System.out.println(mystery.toJson());

            Person spouse = Person.fromJson(spouseString);
            System.out.println("Spouse is " + spouse);

//
//            Person clone = Person.fromJson(jsonString);
//            System.out.println("The clone is: \n"+ clone);

            // Now with an ArrayList
            System.out.println("-=-=-=-=-=-ArrayList=-=-=-=-=-=-=-");
            ArrayList<Person> people = new ArrayList<>();
            File inputFile = new File("input.json");
            File outputFile = new File("output.json");

            ObjectMapper listMapper = new ObjectMapper();

            people = listMapper.readValue(inputFile, new TypeReference<ArrayList<Person>>(){ });
            System.out.println("The arrayList:");
            for(Person pn : people)
                System.out.println(pn);
            System.out.println("----End of arraylist---\n");

            listMapper.writerWithDefaultPrettyPrinter().writeValue(outputFile,people);

            //create the output.json file




        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        System.out.println("Done!");
    }


}
