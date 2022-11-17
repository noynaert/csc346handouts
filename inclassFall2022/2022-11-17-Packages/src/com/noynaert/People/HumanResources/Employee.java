package com.noynaert.People.HumanResources;

import com.noynaert.People.Person;


public abstract class Employee extends Person  {
    private double hourlyRate;

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return null;
    }

    public abstract double calculateWeeklyPay(double hoursWorked);

    public double seniority() {
        return 0;
    }
}
