package com.noynaert;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Main " + Thread.currentThread().getName());

        DemoRunner d1 = new DemoRunner(1000,"Thousand");
        DemoRunner d2 = new DemoRunner(1000000,"Million");
        DemoRunner d3 = new DemoRunner(10000000,"Ten Million");

        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);
        Thread t3 = new Thread(d3);
        Thread t1Prime = new Thread(d1);

        t3.start();
        t2.start();
        t1.start();
      //  t1Prime.start();

        System.out.println("Done in Main! "+ Thread.currentThread().getName());
    }
}
