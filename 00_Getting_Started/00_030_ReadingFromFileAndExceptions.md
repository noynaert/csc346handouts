# 00.030 Reading from a file and Exceptions

## Exceptions

Reference for exceptions: [https://rollbar.com/blog/java-exceptions-hierarchy-explained/](https://rollbar.com/blog/java-exceptions-hierarchy-explained/)

### Throwables

Java has a "Throwable" class.  There are two sub-classes: `Errors` and `Exceptions`.

#### Errors

Errors are serious problem that probably cannot be recovered from.  These include things like running out of memory or an error in configuration.

#### Exceptions

Exceptions are problems that are serious but the program may be able to continue.

There is a mechanism to "catch" exceptions.  For example, if a file name is missing, it might be possible to ask the user for a different file name.


There are some exceptions that the programmer should not ignore.  Operations involving I/O should not be ignored.  Any method (function) that potentially generates an exception has two choices:

1. Handle the exception itself
2. Throw the exception.  This means the calling method must either handle the exception or throw the exception.

The main() method is the top method.  VS Code adds "throws exception" to the main() method.  This is called "Throwing it out the top" and is not good practice.

***Always remove the "throws exception" clause.***  

## Reading from a file

First, there is the question of where to put the file to be read.  It needs to be placed in the "root" of the project folder.  

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting");

        Scanner input = null;

        String fileName = "data.txt";
        try {
            input = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.err.printf("***ERROR***, Could not find file %s\n", fileName);
            System.exit(1);
            //e.printStackTrace();
        }

        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.printf("The line is \"%s\"\n", line);
        }

        input.close();

        System.out.println("Done");
    }
}
```
