package edu.missouriwestern.csc346.noynaert.courses;

import edu.missouriwestern.csc346.noynaert.people.*;


import java.util.ArrayList;

// Section "hasa" Course
// Section is in a "hasa" relationship with Course
public class Section {
    Course course;
    String crn;
    Faculty instructor;
    ArrayList<Student> roster = new ArrayList<>();

}
