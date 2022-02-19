# SQL & Java Tutorials
## SQL 010 The Database Utility in Intellij

[Video](https://mwsu.hosted.panopto.com/Panopto/Pages/Viewer.aspx?id=aff17ae2-57a7-49eb-b144-ae3f002a12de)

Idea/IntelliJ has a database utility built-in.  On a multi-monitor setup I still prefer a freestanding gui client or even the MySQL client at the command line.

However, if you are on a single-monitor system the internal utility might be most useful.

## SQL 020 Reading Credentials

### SQL_020A Reading Passwords

It isn't a good idea to save password and other credentials in your code.  

There is a security risk if your code is distributed.  

A very practical issue is that if the password or server changes you need to track down
all the places in code where the credentials are used and then recompile the code.

This unit will demonstrate three different methods. Each has its own video.  Just use the one you wish.

* The first method will just reads the password from a text file.
* The second method reads all of the credentials from a file.  It needs an internal method.
* The thrid method is overly complex application that pulls the resources from an .xml file using a custom-written jar.

#### Method 1 (Just the password)

The file contains three lines, but only the password will be read.  This simplifies the
calling function because we are only returning a string with the password.

##### Code for reading the password

```java
public class App {
    public static void main(String[] args){

        String password = getPassword("password.txt");
        System.out.println(password);
        System.out.println("\nDone!");
    }

    public static String getPassword(String fileName){
        String password = "";
        try {
            Scanner input = new Scanner(new File(fileName));
            password = input.nextLine().trim();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return password;
    }
}
```

#### Method 2

This method read all of the credentials from a file.  The problem is that 3 values
must be returned instead of a single string.  An internal static class was created
so that all three values may be passed back via an instance of the class.
##### code for reading the credentials

```java
/**
 * Reads all credentials from a file
 */

public class App {
    public static void main(String[] args){
        String user;
        String password;
        String host;

        Credentials creds = new Credentials("password.txt");
        user = creds.getUser();
        password = creds.getPassword();
        host = creds.host;
    }
    static class Credentials{
        String user;
        String password;
        String host;

        public Credentials(String fileName){
            try {
                Scanner input = new Scanner(new File(fileName));
                password = input.nextLine().trim();
                user  = input.nextLine().trim();
                host = input.nextLine().trim();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.exit(1);
            }

        }
        
        public String getUser() {return user;}
        public String getPassword() {return password;}
        public String getHost() {return host;}
    }
}

```
#### Method 3 Credentials Overkill with XML

You should feel free to ignore this section.  It is  a fairly extreme example and will only appeal to hard-core geeks.

I wrote a class to read the credentials from an XML file.  I put it in a jar file and and installed it in my local repository.  Now I can stick the XML dependency for the local jar file.  It is very easy.  If you really want to install 
the jar file, the .jar is in the assignment, and the instructions are [here](https://github.com/noynaert/csc346handouts/blob/main/01_DataExchange/sourceCode/sqlCredentialsInXML/installCredentials.md).

```xml
<dependency>
            <groupId>com.noynaert</groupId>
            <artifactId>credentials</artifactId>
            <version>0.1</version>
</dependency>
```
