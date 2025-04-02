package com.noynaert;

/**
 * This is a POJO and a JavaBean
 *
 * @author J. Evan Noynaert
 * @since March 2025
 */

public class Person {
    String name;
    String birthday;
    int id;
    String country;

    public Person(String name, String birthday, int id, String country) {
        setName(name);
        setBirthday(birthday);
        setId(id);
        setCountry(country);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String toString() {
        String result = String.format("%s was born on %s is from %s and has id %d", name, birthday, country, id);
        return result;
    }
}
