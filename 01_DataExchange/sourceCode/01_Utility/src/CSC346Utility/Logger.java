package CSC346Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Logger {
    private static String name;
    private static PrintStream logFile = null;
    private static long startTime = java.lang.System.nanoTime();

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

    private static String makeMessage(String message) {
        String s = String.format("%1.4f -->%s<--", getSeconds(), message);
        return s;
    }

    public static double getSeconds() {
        long currentTime = System.nanoTime();
        double seconds = (double) (currentTime - startTime)/1000000000.0;
        double sec = (double) seconds / 1000000.;        return seconds;
    }

    public static void info(String message) {
        logFile.println(makeMessage(message));
        logFile.flush();
    }

    public static void exception(Exception e) {
        String message = "EXCEPTION: " + e.getMessage();
        logFile.println(makeMessage(message));
        logFile.flush();
    }

    public static void done() {

        String message = String.format("Finished.  Time is %s seconds", getSeconds());
        logFile.println(makeMessage(message));
        logFile.flush();

    }

}
