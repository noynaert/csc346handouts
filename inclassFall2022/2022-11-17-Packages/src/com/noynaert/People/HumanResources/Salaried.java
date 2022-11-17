package com.noynaert.People.HumanResources;

import com.noynaert.People.HumanResources.Employee;
import com.noynaert.People.HumanResources.InsuranceEligible;

import java.io.Serializable;

public class Salaried extends Employee implements InsuranceEligible, Serializable {
    private double hourlyRate = 20.00;
    @Override
    public String toString(){
        String s = "Adm " + super.toString();

        return s;
    }

    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return 40.0 * hourlyRate;
    }

    @Override
    public double calculateInsurance() {
        return 0;
    }


}
