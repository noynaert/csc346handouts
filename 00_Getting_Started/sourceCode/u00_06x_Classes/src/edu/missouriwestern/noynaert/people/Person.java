package edu.missouriwestern.noynaert.people;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    //constructors
    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }
    public Person(String name){
        this(name, -2);
    }
    public Person(){
        this("Anonymous", -2);
    }

    //getters and setters
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
       if(age < 0 || age > 120){
           this.age = Integer.MIN_VALUE;
       }else{
           this.age = age;
       }
    }
    public void setAge(double age){
        setAge((int)Math.round(age));
    }

    //utility
    public String toString(){
        String s = "";
        if(ageIsValid()) {
            s = String.format("Name: %s, Age: %d", name, age);
        }else{
            s = String.format("Name: %s, Age: --", name);
        }
        return s;
    }
    public boolean ageIsValid(){
        return (age >= 0);
    }

    @Override
    public int compareTo(Person other) {
        int result = 0;
        result = this.name.compareToIgnoreCase(other.name);
        if(result == 0){
            result = this.age - other.age;
        }
        return result;
    }
}
