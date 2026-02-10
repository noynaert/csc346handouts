package com.noynaert;

import java.time.LocalDate;

public class Employee {
    private String id;
    private String first_name;
    private String lastName;
    private int level;
    double payrate;
    LocalDate hireDate;

    public Employee(String id, String first_name, String lastName, int level, double payrate, LocalDate hireDate) {
        setId(id);
        setFirst_name(first_name);
        setLastName(lastName);
        setLevel(level);
        setPayrate(payrate);
        setHireDate(hireDate);
    }
    public Employee(String id, String first_name, String lastName, int level, double payrate, String hireDate) {
        setId(id);
        setFirst_name(first_name);
        setLastName(lastName);
        setLevel(level);
        setPayrate(payrate);
        setHireDate(hireDate);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getPayrate() {
        return payrate;
    }

    public void setPayrate(double payrate) {
        this.payrate = payrate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
    /**
     * setHireDate that parses the date as a string.
     */
    public void setHireDate(String date){
        this.hireDate = LocalDate.parse(date);
    }
    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", first_name=" + first_name + ", lastName=" + lastName + ", level=" + level + ", payrate=" + payrate + ", hireDate=" + hireDate + '}';
    }
}
