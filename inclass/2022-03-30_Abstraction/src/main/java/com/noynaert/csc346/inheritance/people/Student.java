package com.noynaert.csc346.inheritance.people;


// Student isa Person
public class Student extends Person{
  double gpa;

  public Student(String name, String number, double gpa){
      super(name, number);
  }
  public Student(){
      //System.out.println();
      this("Anonymous","Gxxxxxxxx", 0.000);
      System.out.println();
  }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    @Override
    public String toString(){
        String result = super.toString();
        result += String.format(" GPA: %1.3f", this.gpa);
        return result;
    }
}
