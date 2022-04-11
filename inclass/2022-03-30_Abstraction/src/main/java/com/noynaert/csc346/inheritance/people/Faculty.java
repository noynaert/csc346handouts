package com.noynaert.csc346.inheritance.people;

import java.io.Serializable;
import java.util.ArrayList;

public class Faculty extends Employee implements Alumni, isAssignedClasses, Serializable {
//This is a bad interface example.  It should not be implemented as an interface.

    @Override
    public String getStatus() {
        return "Unknown for now";
    }

    @Override
    public int yearGraduated() {
        return 0;
    }

    @Override
    public ArrayList<Object> getSchedule() {
        return null;
    }
}
