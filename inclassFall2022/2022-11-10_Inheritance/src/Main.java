import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Name name = new Name("John", "Doe", "Q.");

        ArrayList<Person> people = new ArrayList();
        people.add(new Person("John", "Doe", "", "2002-01-07"));
        people.add(new Person("Ann", "Nonymous","", "2005-07-08"));
        //people.add(new //Name("abc", "def", ""));  //Won't work because a name is not a person.
        people.add(new Employee());


        //Person pn = new Person();

        Employee emp = new Employee();
        System.out.println("Your salary is " + emp.getSalary());
        for(Person pn : people){
            System.out.println(pn);
        }

        System.out.println("Hello world!");
    }
}
