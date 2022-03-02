import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Calendar;
import java.util.Date;

public class SimplePerson {
    private String first;
    private String last;
    private int year;
    private transient int age;

    public SimplePerson(String first, String last, int year){
        setFirst(first);
        setLast(last);
        setYear(year);
    }
    public SimplePerson(){
        this("???", "???", Calendar.YEAR);
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
        setAge();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        setAge();
    }
    public void setAge() {
        int currentYear = LocalDate.now().getYear();
        age =  currentYear - year;
    }

    @Override
    public String toString() {
        return "SimplePerson{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", year=" + year +
                ", age=" + age +
                '}';
    }
}
