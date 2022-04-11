package com.noynaert.csc346.inheritance.people;

public class Person extends Object implements Comparable<Person>{
    String name;
    String number;
//
//    public Person(String name, String number) {
//       setName(name);
//       setNumber(number);
//    }


    public Person(String name, String number) {
        this.name = name;
        this.number = number;
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
        return "Person{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }


    public static void print(){
        System.out.println("I am in a package");
    }

    @Override
    public int compareTo(Person o) {
        int result = this.number.compareTo(o.number);
        return 0;
    }
}
