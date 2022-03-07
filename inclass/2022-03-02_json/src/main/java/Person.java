import java.time.LocalDate;

public class Person {
    private String first;
    private String last;
    private int yearBorn;
    private transient int age;

    public Person(String first, String last, int yearBorn) {
        setFirst(first);
        setLast(last);
        setYearBorn(yearBorn);
    }

    public Person() {
        this("???", "???", 1970);
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

    public int getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn(int yearBorn) {
        this.yearBorn = yearBorn;
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
        this.age = currentYear - this.yearBorn;


    }

    @Override
    public String toString() {
        return "Person{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", yearBorn=" + yearBorn +
                ", age=" + age +
                '}';
    }
}
