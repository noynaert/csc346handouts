package com.noynaert;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public class FetchJson implements Runnable {

    String url;
    public FetchJson(String name,int target){

            }

    protected String fetchURL(String url){
        String json = {};

        return json;
            }

    @Override
    public void run() {
        System.out.println("Hi, I am " + Thread.currentThread().getName());
        double sum;
        sum = doSomethingSlow();
        Stopwatch stopwatch = Stopwatch.createUnstarted();
        stopwatch.start();
        fetchURL(address);
        stopwatch.stop();
        System.out.println(name + " Elapsed time: " + stopwatch.elapsed(TimeUnit.NANOSECONDS) + "ns");
        System.out.println("The sum is "+sum+" in "+ Thread.currentThread().getName());
        System.out.println("Bye from " + Thread.currentThread().getName());
    }

    private double doSomethingSlow(){
        double sum = 0.0;
        for(int i = 0;i<target;i++){
            sum += Math.random();
        }

        return sum;
    }
}
