package com.noynaert.People;

public class Salaried extends Employee{
    @Override
    public String toString(){
        String s = "Adm " + super.toString();

        return s;
    }

    @Override
    public double hourlyPay(double hoursWorked) {
        return 40.0 * hoursWorked;
    }
}
