package com.noynaert.People;

public class Customer extends Person{

    @Override
    public String toString(){
        String s = "HVC " + super.toString();

        return s;
    }
}
