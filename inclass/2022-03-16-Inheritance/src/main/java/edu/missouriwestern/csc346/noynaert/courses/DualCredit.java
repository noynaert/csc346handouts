package edu.missouriwestern.csc346.noynaert.courses;

import edu.missouriwestern.csc346.noynaert.people.Faculty;

public class DualCredit extends Course {
    protected Faculty cooperatingTeacher;

    public DualCredit(String id, String title, int hours, String description, cooperatingTeacher){
        super(id,title,hours,description);
        setCooperatingTeacher(cooperatingTeacher);
    }

    public Faculty getCooperatingTeacher() {
        return cooperatingTeacher;
    }

    public void setCooperatingTeacher(Faculty cooperatingTeacher) {
        this.cooperatingTeacher = cooperatingTeacher;
    }
}
