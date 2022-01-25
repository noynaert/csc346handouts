import CSC346Utility.Logger;
import CSC346Utility.Person;

//https://code-with-me.jetbrains.com/lmuFUkVMztdKqUEGtRcGJQ#p=IU&fp=F5A77DCC119689E30830B41DE6D4F5FE4E60CBD14865E78E97DAFA7CC7CDCB1E
public class Main {
    static Logger log = new Logger("Main");
    public static void main(String[] args) {
        Logger.info("Starting");
        Person pn = new Person("Fred", "Flintstone");
        System.out.println(pn);

        //test exception
        try{
            int number = Integer.parseInt("-9876");
            Logger.info("The integer was parsed as " + number);
            System.out.printf("The number is %d\n", number);
        }catch(NumberFormatException e){
            Logger.exception(e);
        }

        /*
            %d integers
            %s String
            %f floating point
         */

        System.out.printf("An integer: %1d, A String: %-20s, and a double %1.3f\n", -99, "Howdy", Math.PI);

        System.out.println("\nDone!");
        Logger.done();
    }
}
