package org.example;

public class Person {
    private String firstName;
    private String lastName;
    private String city;
    private String state;

    public Person(String firstName, String lastName, String city, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
    }
    public Person(){
        this("john","doe", "somewhere", "qq");
    }

    @Override
    public String toString() {
        return
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' ;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
