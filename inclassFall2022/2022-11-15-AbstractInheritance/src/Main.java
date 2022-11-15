import com.noynaert.People.*;

public class Main {
    public static void main(String[] args) {

        Hourly pn = new Hourly();
        Person real = new Customer();
        Person boss = new Salaried();
        Customer client = new Customer();

        System.out.println(pn);
        System.out.println(real);
        System.out.println(boss);
        System.out.println(client);

        System.out.println("Hello world!");
    }
}
