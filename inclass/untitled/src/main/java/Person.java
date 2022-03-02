import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String first;
    private String last;
    public LocalDate birthday;
    private transient int age;

    public Person(String first, String last, LocalDate birthday) {
        setFirst(first);
        setLast(last);
        setBirthday(birthday);
    }
    public Person(){
        this("???", "???", LocalDate.now());
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        setAge();
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        LocalDate today = LocalDate.now();
        age = Period.between(birthday,today).getYears();
    }

    @Override
    public String toString() {
        return "Person{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                '}';
    }
}
