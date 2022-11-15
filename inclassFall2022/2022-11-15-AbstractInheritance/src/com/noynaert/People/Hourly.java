package com.noynaert.People;

public class Hourly extends Employee{
    @Override
    public String toString(){
        String s = "Reg " + super.toString();

        return s;
    }
    public double hourlyPay(double hoursWorked){
        double result = hoursWorked * hourlyRate;
        return result;
    }
}
