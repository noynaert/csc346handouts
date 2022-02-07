import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Demonstrates log4j basic operation
 *
 * @author: Evan Noynaert
 * @since: February 2022
 */

public class App {
    private final static Logger LOG = LogManager.getLogger(App.class);

    public static void main(String[] args) {


        LOG.fatal("FATAL:  Goodbye, cruel world!");
        LOG.error("ERROR: Something broke, I think.");
        LOG.warn("WARN: Danger, Will Robinson!");
        LOG.info("INFO: Billy Mummy is 67 years old.");
        LOG.debug("DEBUG: I am debugging.  Argc is " + args.length);
        LOG.trace("TRACE: Kilroy was here");
        printMessage("Hello.");
        System.out.println("\nDone!");
        LOG.info("Successful shutdown of program");
    }
    public static void printMessage(String message){
        LOG.trace("In printMessage with a message of " + message);
        System.out.println("---------------");
        System.out.println(message);
        System.out.println("---------------");
    }
}
