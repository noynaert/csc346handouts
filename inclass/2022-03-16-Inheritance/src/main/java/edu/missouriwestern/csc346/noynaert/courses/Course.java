package edu.missouriwestern.csc346.noynaert.courses;

public class Course {
    String id;  //like CSC 436
    String title;
    int hours;
    String description;

    public Course(String id, String title, int hours, String description) {
      setId(id);
      setTitle(title);
      setHours(hours);
      setDescription(description);
    }
    public Course(){
        this("zzz123","Unknown Course", 0,"No description Available");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
