package com.noynaert.people;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private double height;

    public Person(String name, double height){
        setName(name);
        setHeight(height);
    }
    public Person(){
        this("????",0.0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHeight() {
        return height;
    }


    public void setHeight(double height) {
        this.height = height;
    }
    public void setHeight(String heightString) {
        this.height = Double.parseDouble(heightString);
    }
    @Override
    public String toString(){
        return String.format("%s, %3.1f cm", name, height);
    }

    @Override
    public int compareTo(Person other) {
        int result = 0;
        result = this.name.compareToIgnoreCase(other.name);
        if (result == 0) {
            result = Double.compare(this.height, other.height);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Double.compare(height, person.height) == 0 && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, height);
    }
}
