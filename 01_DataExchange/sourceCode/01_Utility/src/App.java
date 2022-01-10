
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import CSC346Utility.Logger;
import CSC346Utility.Person;

@SuppressWarnings("unchecked")
public class App {
    static Logger log = new Logger(App.class.getName());

    public static void main(String[] args) {

        // Tests the person
        log.info("Starting App");
        Person pn = new Person();
        System.out.println(pn);
        log.info("Person is " + pn);

        // Do some slow stuff
        tossException();
        doSomethingSlow();

        System.out.println("Done!");
        log.done();
    }

    public static void tossException() {

        log.info("Entering tossExceptoin()");
        try {
            Scanner bigDummy = new Scanner(new File("notThere.txt"));
            bigDummy.close();
        } catch (Exception e) {
            log.exception(e);
        }
        log.info("Exiting tossExcepion");
    }
    
    public static void doSomethingSlow() {
        int n = 10000000;
         log.info("Before the arraylist");
         ArrayList<Double> numbers = new ArrayList<Double>();
            log.info("before arrayList");
            for (int i = 0; i < n; i++) {
                numbers.add(Math.random());
            }
            Collections.sort(numbers);
            String s = String.format("The middle number of the array is %f", numbers.get(n/2));
            log.info(s);
        }

}
