package com.noynaert;
import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Stopwatch wholeProgram = Stopwatch.createUnstarted();
        wholeProgram.start();
        System.out.println("Starting.  My name is " + Thread.currentThread().getName());

        //Start of threading stuff
        FetchJson d0 = new FetchJson("thousand", 100000);
        FetchJson d1 = new FetchJson("million ",100000000);
        FetchJson d2 = new FetchJson("one", 1);
        Thread t0 = new Thread(d0);
        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);

        t0.start();
        t1.start();
        t2.start();
        //End of threading stuff

        System.out.println("Done with main!");
        wholeProgram.stop();
        System.out.println("Elapsed time: " + wholeProgram.elapsed(TimeUnit.NANOSECONDS) + " nanoseconds");
        System.out.printf("In milliseconds that would be %1.3f seconds\n",wholeProgram.elapsed(TimeUnit.MILLISECONDS)/1000.);
    }
}
