package com.noynaert.People.HumanResources;

public abstract interface InsuranceEligible {
    public final static String[]plans = {"Opt-out", "Gold", "Platinum"};
    public abstract double calculateInsurance();

}
