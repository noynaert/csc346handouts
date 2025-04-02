package com.noynaert;

import java.io.Serializable;

public class Country implements Serializable {
    private String person;
    private String country;

    public Country(){
        setPerson("???");
        setCountry("???");
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Country{" +
                "person='" + person + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
