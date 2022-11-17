package com.noynaert.People.HumanResources;

public class ContractWorker extends Employee {
    private double contractRate = 1000.00;
    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return contractRate;
    }
}
