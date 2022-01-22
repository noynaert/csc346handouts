import CSC346Utility.*;
/**
 * This is the driver routine to demonstrate te use of jar files.
 */

public class App {
    static Logger log = new Logger("App");

    public static void main(String[] args) {
        Person pn = new Person("Fred", "Flintstone");
        log.info("Starting");

        try{
            int x = Integer.parseInt("-1234");
            log.info("created x");
            System.out.println(x);
        } catch (NumberFormatException e) {
            log.exception(e);
        }

        System.out.println("\nDone!");
        log.done();
    }
}
