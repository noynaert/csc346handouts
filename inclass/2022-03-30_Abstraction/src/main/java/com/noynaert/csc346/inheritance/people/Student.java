package com.noynaert.csc346.inheritance.people;


import java.util.ArrayList;

// Student isa Person
public class Student extends Person implements isAssignedClasses {
    double gpa;
    int creditHours;
    private ClassRank rank;

    public Student(String name, String number, double gpa, int creditHours) {
        super(name, number);
        setCreditHours(creditHours);
    }

    public Student() {
        //System.out.println();
        this("Anonymous", "Gxxxxxxxx", 0.000, 0);
        System.out.println();
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
       this.creditHours = creditHours;
        if (creditHours < 30)
            rank = ClassRank.FRESHMAN;
        else if (creditHours <= 60)
            rank = ClassRank.SOPHOMORE;
        else if (creditHours <= 90)
            rank = ClassRank.Junior;
        else if (creditHours <= 120)
            rank = ClassRank.Senior;
        else
            rank = ClassRank.Graduate;
    }

    public ClassRank getRank() {
        return rank;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        String result = super.toString();
        result += String.format(" GPA: %1.3f Credit Hours: %3d (%s)", this.gpa, creditHours, rank);
        return result;
    }

    @Override
    public String getStatus() {
        //in a real example, I would either reference a local variable or pull information from a database.
        String status = "Good academic standing";
        if(gpa < 2.0 && creditHours > 0)
            status = "Probation";
        else if (gpa < 0.)
            status = "Suspended";
        return status;
    }

    @Override
    public ArrayList<Object> getSchedule() {
        return null;
    }
}
