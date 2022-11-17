package com.noynaert.People.HumanResources;

public class Hourly extends Employee implements InsuranceEligible {

    private double hourlyRate = 15.00;
    @Override
    public String toString(){
        String s = "Reg " + super.toString();

        return s;
    }
    public double calculateWeeklyPay(double hoursWorked){
        double result = hoursWorked * hourlyRate;
        return result;
    }

    @Override
    public double calculateInsurance() {
        return 0;
    }
}
