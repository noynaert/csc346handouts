package com.noynaert;

public class DemoRunner implements Runnable {
    String name;
    int target;

    public DemoRunner(int target,String name){
        this.name = name;
        this.target=target;
    }
    @Override
    public void run() {
        System.out.println("Starting demoRunner  "+Thread.currentThread().getName());
        double sum = doSomeThingSlow();
        System.out.printf("%s %f,(%s)\n", name, sum, target);
        System.out.println("Finishing demoRunner  "+Thread.currentThread().getName());

    }
    private double doSomeThingSlow(){
        double sum = 0;
        for(int i=0;i<target;i++)
            sum+=Math.random();
        return sum;
    }

}
