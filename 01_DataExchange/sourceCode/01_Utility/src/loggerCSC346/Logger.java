package loggerCSC346;

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

                logFile.println(makeMessage("Creating log File at " + System.nanoTime()));
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
        String s = String.format("%015d -->%s<--",getSeconds(), message);
        return s;
    }

    public static long getSeconds() {
        long currentTime = System.nanoTime();
        long seconds = (currentTime - startTime);
        return seconds;
    }

    public static void info(String message) {
        logFile.println(makeMessage(message));
        logFile.flush();
    }

    public static void exception(Exception e){
        String message = "EXCEPTION: "+e.getMessage();
        logFile.println(makeMessage(message));
        logFile.flush();
    }

    public static void done() {
        
        String message = String.format("Finished.  Time is %d seconds", System.nanoTime());
        logFile.println(makeMessage(message));
        logFile.flush();

    }
    
}
