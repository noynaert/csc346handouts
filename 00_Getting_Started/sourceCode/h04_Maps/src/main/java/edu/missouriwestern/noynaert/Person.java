package edu.missouriwestern.noynaert;

public class Person {
    String firstName;
    String lastName;
    String email;
    String photoURL;

    public Person(){
        firstName = "--";
        lastName = "--";
        email = "--";
        photoURL = "--";
    }
    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String toString(){
        String result = "";
        String name = lastName + ", " + firstName;
        result = String.format("%-25s %-25s %-1s",name,email,photoURL);
        return result;
    }
}
