package com.noynaert.csc346.inheritance.people;

public abstract class Person extends Object implements Comparable<Person>{
    String name;
    String number;
    final int MAX_NAME_LENGTH = 20;
//
//    public Person(String name, String number, 0.0, 0) {
//       setName(name);
//       setNumber(number);
//    }


    public Person(String name, String number) {
        this.name = name;
        this.number = number;
    }
    public Person(){
        this("unknown", "G000000");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        String s = "Person{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';

        //The following is a BAD use of instanceOf
/*
        if(this instanceof Student){
            s = "Custom string for students";
        }
*/
        return s;
    }


    public static void print(){
        System.out.println("I am in a package");
    }

    @Override
    public int compareTo(Person o) {
        int result = this.number.compareTo(o.number);
        return 0;
    }
    public abstract String getStatus();
}
