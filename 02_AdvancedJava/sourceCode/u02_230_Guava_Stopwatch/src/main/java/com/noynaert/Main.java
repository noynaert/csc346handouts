package com.noynaert;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Stopwatch stopwatch = Stopwatch.createUnstarted();

        stopwatch.start();
        double sum = doSomethingSlow(10000000);
        stopwatch.stop();
        System.out.println("The sum is "+ sum);
        double seconds = stopwatch.elapsed(TimeUnit.MILLISECONDS)/1000.;
        System.out.printf("It took %1.3f seconds\n",seconds);
        System.out.println("Done!");
    }

    private static double doSomethingSlow(int max) {
        double sum = 0.0;
        for(int i=0;i<max;i++)
            sum += Math.random();
        return sum;
    }
}
