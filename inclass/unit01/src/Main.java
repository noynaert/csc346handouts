import CSC346Utility.Logger;
import CSC346Utility.Person;

public class Main {
    static Logger log = new Logger("Main");
    public static void main(String[] args) {
        log.info("Starting");
        Person pn = new Person("Fred", "Flintstone");
        System.out.println(pn);

        try{
            int number = Integer.parseInt("-9876");
            Logger.info("Parsed the integer");
            System.out.println("The number is " + number);
        }catch(NumberFormatException e){
            Logger.exception(e);
        }

        System.out.println("\nDone!");
        log.done();
    }
}
