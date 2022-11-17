import com.noynaert.People.*;
import com.noynaert.People.HumanResources.Hourly;
import com.noynaert.People.HumanResources.Salaried;
import com.noynaert.People.Sales.Customer;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String cook = "\uD83E\uDDD1\u200D\uD83C\uDF73";
        System.out.println(cook);
        Person p;
        Hourly pn = new Hourly();
        Person real = new Customer();
        Person boss = new Salaried();
        Customer client = new Customer();


        ArrayList<Person> people = new ArrayList<>();
        people.add(new Hourly());
        people.add(new Customer());
        //people.add(new Person());  //Person is abstract.  I cannot create an instance of a person.

        System.out.println(pn);
        System.out.println(real);
        System.out.println(boss);
        System.out.println(client);

        System.out.println("Hello world!");
    }
}
