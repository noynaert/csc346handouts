package CSC346Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Logger class provides very basic and simple logging
 * 
 * @author J. Evan Noynaert
 * @since January 2022
 * 
 */
public class Logger {
    private static String name;
    private static PrintStream logFile = null;
    private static long startTime = java.lang.System.nanoTime();

    /**
     * The contructor takes the root name of the log file.  The extension .log will be appended to the root.
     * 
     * @param name: String.  This will be the root of the file name.
     */

    public Logger(String name) {
        Logger.name = name;
        if (logFile == null) {
            try {
                logFile = new PrintStream(new File(name + ".log"));

                logFile.println(makeMessage("Creating log File at " + getSeconds()));
                logFile.flush();
            } catch (FileNotFoundException e) {
                System.err.println(e.getMessage());

            }
        } else {
            logFile.println(makeMessage(name + " Log file being re-declared"));
            logFile.flush();
        }
    }

    /**
     * MakeMessage appends the time to the beginning of the message
     * 
     * @param message: String with content of the message
     * @return A formatted string containing the timestamp and message
     */
    
    private static String makeMessage(String message) {
        String s = String.format("%1.4f -->%s<--", getSeconds(), message);
        return s;
    }

    
    /** 
     * Converts nanoseconds to seconds
     * 
     * @return double
     */
    public static double getSeconds() {
        long currentTime = System.nanoTime();
        double seconds = (double) (currentTime - startTime)/1000000000.0;
        double sec = (double) seconds / 1000000.;        return seconds;
    }

    /**
     * This is the workhorse of the logger.  It may be used at any time
     * @param message: String Contains the message to be logged.
     */
    public static void info(String message) {
        logFile.println(makeMessage(message));
        logFile.flush();
    }


    /**
     * This method is intended for use in a catch{} block.
     * 
     * @param e:Exception The parameter should be an Exception or a subclass of
     *                    Exception.
     */
    public static void exception(Exception e) {
        String message = "EXCEPTION: " + e.getMessage();
        logFile.println(makeMessage(message));
        logFile.flush();
    }

    /** 
     * The done() method should be the last method called in the program.  It does not take any arguments.
     */
    public static void done() {

        String message = String.format("Finished.  Time is %s seconds", getSeconds());
        logFile.println(makeMessage(message));
        logFile.flush();

    }

}
