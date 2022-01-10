
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import loggerCSC346.Logger;

@SuppressWarnings("unchecked")
public class App {
    static Logger log = new Logger(App.class.getName());

    public static void main(String[] args) {
        log.info("Starting App");
        doSomething();
        System.out.println("Done!");
        log.done();
    }

    public static void doSomething() {
        
        log.info("Entering doSomething");
        try {
            Scanner bigDummy = new Scanner(new File("notThere.txt"));
            bigDummy.close();

            // ArrayList<Double> numbers = new ArrayList<Double>();
            // log.info("before arrayList");
            // for (int i = 0; i < 10000000; i++) {
            //     numbers.add(Math.random());
            // }
            // Collections.sort(numbers);
        } catch (Exception e) {
            log.exception(e);
        }
        log.info("Exiting doSomething");
    }
}
