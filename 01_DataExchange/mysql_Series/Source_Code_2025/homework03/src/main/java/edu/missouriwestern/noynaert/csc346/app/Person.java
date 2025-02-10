package edu.missouriwestern.noynaert.csc346.app;

import java.util.Objects;

/**
 * Demonstration class of Persons
 *
 * @author J. Evan Noynaert
 * @since February, 2025
 *
 */
public class Person implements Comparable<Person>{
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String county;
    private String state;
    private String zip;
    private String email;

    public Person(String firstName, String lastName, String address, String city, String county, String state, String zip, String email) {
        this.email = email;
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setCity(city);
        setCounty(county);
        setState(state);
        setZip(zip);
        setEmail(email);
    }
    public Person() {
        this("John", "Doe", "???", "???", "???", "???", "???", "???");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }

    @Override
    public int compareTo(Person other) {
        int result = this.lastName.compareTo(other.lastName);
        if (result == 0) {
            result = this.firstName.compareTo(other.firstName);
        }
        if (result == 0) {
            result = this.email.compareTo(other.email);
        }
        return result;
    }
}
