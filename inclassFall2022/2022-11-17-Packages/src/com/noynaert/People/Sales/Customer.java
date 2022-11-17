package com.noynaert.People.Sales;

import com.noynaert.People.Person;

public class Customer extends Person {

    @Override
    public String toString(){
        String s = "HVC " + super.toString();

        return s;
    }
}
