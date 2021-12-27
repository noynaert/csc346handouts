# 00.040 Reading from a URL and More Exceptions

Reading from a URL takes us out of the semi-safe nursery of the Scanner class.  Most actual file IO in Java is done with various IO routines.  Java has a very complex IO class system we will explore during the course.  For now we are going to get input from the Internet using the Buffered Reader class and a couple of other classes along the way.

## Dealing with multiple Exceptions

We will have to deal with two different Exceptions.

* Creating an instance of the URL class creates a potential "Malformed URL Exception"
* Reading opening the stream and reading from it cases potential "IO Exceptions"

There are several ways of dealing with this.  I will cover just two of them here.

### Dual catch clauses

A `try` block may have more than one `catch()` clause.  This has the advantage of handling each type of exception independently.  In the following example, a malformed URL aborts the program with an error code.  But if there is an error connecting to the URL then The IO connection prints a message saying to check your internet connection.  In the second catch the execution of the program is allowed to continue.

Also, note that the second catch uses the `getMessage()` method of the Exception class to print a more meaningful message.
```java
        try {
            URL url = new URL(address);
            InputStreamReader inStream = new InputStreamReader(url.openStream());
        } catch (MalformedURLException e) {
            System.err.println("BAD URL: " + address + "*** ABORTING ***");
            System.exit(1);
            // e.printStackTrace();
        } catch (IOException e) {
            System.err.print  ("IO EXCEPTION: " + e.getMessage());
            System.err.println("  Check your network connection and try again.");
            // e.printStackTrace();
        }
```

### Single generic catch claus

It is also possible to handle more than one type of exception with a single `catch()`.

This works because Exception is the parent class of both the Malformed URL exception and the IO Exception (as well as being the parent class of all other exceptions).  

```java
        try {
            URL url = new URL(address);
            InputStreamReader inStream = new InputStreamReader(url.openStream());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
            // e.printStackTrace();
        }
```

The single catch means we can no longer easily differentiate between reasons for the exception (there are ways to still do that, but it does take some additional coding).  The example code uses the `getMessage()` method to print a generic method and then aborts.

The advantage of the generic catch is that it will catch all exceptions, including ones that we are not required to handle.  For example, the programmer does not explicitly need to check for array bounds violations, but a bounds violation does generate an exception.  Therefor our generic exception handling could deal with it.

### A mixed approach

Another solution is to have a mixed approach.  We could check for some exceptions and then have a generic catch of general exceptions.  In this case we would put the most specific exception first, and the general exceptions last.

## Code for reading from a URL
### With an ArrayList

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * Reads from a url and discusses exceptions in more depth
 * 
 * @author J. Evan Noynaert
 * @since December 2021
 */

public class App {
    public static void main(String[] args) {
        
        final String ADDRESS = "https://raw.githubusercontent.com/noynaert/csc346handouts/main/README.md";

        ArrayList<String> lines = new ArrayList<String>();
        readRemoteAddress(ADDRESS, lines);

        printLines(lines);

        System.out.println("\nDone!\n");
    }

    public static void printLines(ArrayList<String> lines) {
        int n = lines.size();
        System.out.printf("\nPrinting %d lines:\n", n);
        for(int i = 0; i<n; i++)
            System.out.printf("[%2d] %s\n", i, lines.get(i));

        System.out.printf("\nPrinting %d lines:\n", n);
        for (String line : lines) {
            System.out.printf(">>>%s<<<\n", line);
        }
    }

    private static void readRemoteAddress(String address, ArrayList<String> lines) {
        try {
            URL url = new URL(address);

            InputStreamReader inStream = new InputStreamReader(url.openStream());
            BufferedReader input = new BufferedReader(inStream);

            String line;
            while ( (line = input.readLine()) != null ){
                line = line.trim();
                if (line.startsWith("#")) {
                    lines.add(line);
                }
            }
            input.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
            // e.printStackTrace();
        }
    }
}
```