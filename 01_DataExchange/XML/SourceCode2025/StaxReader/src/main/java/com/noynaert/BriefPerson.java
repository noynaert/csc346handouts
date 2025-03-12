package com.noynaert;

import java.util.ArrayList;

public class BriefPerson {
    String lastName;
    String firstName;
    String middleName;
    String id;
    String email;
    ArrayList<String>   phoneNumbers;
    public BriefPerson() {
        lastName = firstName = middleName = id = email ="";
        phoneNumbers = new ArrayList<String>();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void addPhoneNumber(String phoneNumber){
        phoneNumbers.add(phoneNumber);
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String toString(){
        String line = "";
        String name = String.format("%s, %s %s", lastName, firstName, middleName).trim();
        line=String.format("|%s|%s|%s|%d|", id, name, email,phoneNumbers.size());
        return line;
    }
}