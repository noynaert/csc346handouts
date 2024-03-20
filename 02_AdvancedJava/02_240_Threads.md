# 02.240 Threads

Threads are blocks of code that may execute at the same time as other blocks of code.

Java has two primary methods for implementing threads.

* A class may extend the Thread class
* A class may implement the Runnable method

In most cases, the Runnable method is the better choice

- Extending Thread makes it impossible to use inheritance for the class.  It effectively makes the class a final class that cannot be extended.
- Design principles would say that a Class should have a purpose.  Extending Thread suggests that the class's primary purpose is to be a thread.
- There are technical limits on the extent of the multithreading


## Implementing the Runnable Interface

The class must implement a run() method.

The thread is started by creating and starting a Thread object.

## Demonstration

### The Main Class

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting main");

        DemoRunner d1 = new DemoRunner(10000000,"Ten Million");
        DemoRunner d2 = new DemoRunner(1000,"Thousand");
        DemoRunner d3 = new DemoRunner(1,"One");
        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);
        Thread t3 = new Thread(d3);;
        t1.start();
        t2.start();
        t3.start();

        System.out.println("DoneWithMain");
    }
}
```

## The Runnable class

```java
public class DemoRunner implements Runnable{
    int size;
    String name;

    public DemoRunner(int size,String name){
        this.name=name;
        this.size = (size>1?size:1);
    }
    public DemoRunner(){
        this(0,"???");
    }

    @Override
    public void run() {
        System.out.printf("Starting %s with count %d\n",name,size);
        //System.out.println("Thread is "+Thread.currentThread().getName());
        double sum = 0;
        for(int i=0;i<size;i++){
            sum += Math.random();
        }
        System.out.printf("Sum is %f in %s (%d)\n",sum,name,size);
    }
}
```
