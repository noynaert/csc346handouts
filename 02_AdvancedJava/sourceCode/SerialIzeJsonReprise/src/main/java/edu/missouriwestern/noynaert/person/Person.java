package edu.missouriwestern.noynaert.person;


import java.io.Serializable;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Person class represents a person with a name and age. It implements the Serializable and Comparable interfaces.
 *
 * It provides methods for serialization and deserialization using JSON format.
 *
 * Example usage:
 *
 * Person fred = new Person();
 * fred.setName("Fred");
 * fred.setAge(29);
 *
 * System.out.println(fred);
 *
 * try {
 *     String jsonString = fred.toJson();
 *     System.out.println("The json is \n" + jsonString);
 *
 *     Person clone = Person.fromJson(jsonString);
 *     System.out.println("The clone is: \n"+ clone);
 *
 * } catch(Exception e){
 *     e.printStackTrace();
 *     System.out.println(e.getMessage());
 * }
 *
 * System.out.println("Done!");
 */

public class Person implements Serializable, Comparable<Person> {
    private String name;
    private int age;

    // Serialization code
    private static ObjectMapper personMapper = getPersonMapper();
    private static ObjectMapper getPersonMapper(){
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        return mapper;
    }

    public String toJson() throws JsonProcessingException{
        String json = personMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);

        return json;
    }
    public static Person fromJson(String jsonString) throws JsonProcessingException{
        Person pn = personMapper.readValue(jsonString, Person.class);

        return pn;
    }


    // end of serialization code
    public Person(){
        setName("Unknown");
        setAge(999);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = (age >= 0?age:0);
    }

    @Override
    public String toString() {
        return "Person(from toString){" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        int result = 0;
        result = name.compareToIgnoreCase(o.name);
        result = (result==0) ? (age-o.age) : result;
        return result;
    }

}
