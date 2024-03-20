# 02.240 Threads

Threads are blocks of code that may execute at the same time as other blocks of code.

Java has two primary methods for implementing threads.

* A class may extend the Thread class
* A class may implement the Runnable method

In most cases, the Runnable method is the better choice

- Implementing Thread makes it impossible to use inheritance for the class.  It effectively makes the class a final class that cannot be extended.
- Design principles would say that a Class should have a purpose.  Extending Thread suggests that the class's primary purpose is to be a thread.
- There are technical limits on the extent of the multithreading


## Implementing the Runnable Interface

The class must implement a run() method.

The thread is started by creating and starting a Thread object.

