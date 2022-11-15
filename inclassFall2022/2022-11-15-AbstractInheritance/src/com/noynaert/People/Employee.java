package com.noynaert.People;

public abstract class Employee extends Person {
    private double hourlyRate;

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    abstract public String toString();

    public abstract double hourlyPay(double hoursWorked);

    public double seniority() {
        return 0;
    }
}
