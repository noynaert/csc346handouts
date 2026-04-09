package com.noynaert;

public class Flintstone implements Comparable<Flintstone>{
    String name;
    int age;

    public Flintstone(String name, int age) {
        setName(name);
        setAge(age);
    }
    public Flintstone() {
        this("ROCKY", -99);
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
        this.age = age;
    }
    public String toString() {
        String s = String.format("%s is %d %s old", name, age, (age == 1) ? "year" : "years");
        return s;
    }
    public int compareTo(Flintstone other) {
        return this.name.compareTo(other.name);
    }
}
