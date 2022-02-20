# SQL & Java Tutorials


  - [Links to the videos.](#links-to-the-videos)
  - [SQL 010 The Database Utility in Intellij](#sql-010-the-database-utility-in-intellij)
  - [SQL 020 Reading Credentials](#sql-020-reading-credentials)
    - [SQL_020A Reading Passwords](#sql_020a-reading-passwords)
      - [Method 1 (Just the password)](#method-1-just-the-password)
        - [Code for reading the password](#code-for-reading-the-password)
      - [Method 2](#method-2)
        - [code for reading the credentials](#code-for-reading-the-credentials)
      - [Method 3 Credentials Overkill with XML](#method-3-credentials-overkill-with-xml)
  - [Direct SQL (with an arraylist and a different type of query)](#direct-sql-with-an-arraylist-and-a-different-type-of-query)
    - [The mysql dependencies](#the-mysql-dependencies)
    - [Prepared queries](#prepared-queries)

## Links to the videos.

[Link to the entire folder of videos](https://mwsu.hosted.panopto.com/Panopto/Pages/Sessions/List.aspx?folderID=2cb68570-2d11-47bd-8a08-ae3f00293648)

* [sql_010](https://mwsu.hosted.panopto.com/Panopto/Pages/Viewer.aspx?id=3be0755a-b167-4f60-b2ba-ae41016b05b0) This video explores the use of the database utility built into Intellij.  It may or may not be of interest.
* Reading Credentials -- You should probably pick one of the first two methods
  * [sql_020A](https://mwsu.hosted.panopto.com/Panopto/Pages/Viewer.aspx?id=b78db3da-3975-40fc-9803-ae41016b05ac) This illustrates reading the password from a file
  * [sql_020B](https://mwsu.hosted.panopto.com/Panopto/Pages/Viewer.aspx?id=5cd81b98-8cce-4430-97bf-ae41016b05ae)  This video is the method I really recommend for reading the password, user, and host from a simple text file
  * [sql_020C](https://mwsu.hosted.panopto.com/Panopto/Pages/Viewer.aspx?id=3b3db50e-3f2d-4e53-8282-ae41016b05af)  This is how I read the credentials from an XML file.  It is probably overkill.  It might or might not be of interest to the hard-core geeks in the class
* Full sql Example (with hints for Hmwk 4)
  *  [sql_030a](https://mwsu.hosted.panopto.com/Panopto/Pages/Viewer.aspx?id=e39000a4-137d-4b19-a71d-ae41016bf41a)  This mainly shows how to copy and paste the dependencies and start the project.  I don't think most people need it, but some might.
  *  [sql_030b](https://mwsu.hosted.panopto.com/Panopto/Pages/Viewer.aspx?id=b07aebc6-e5b2-4797-bc0d-ae41016c0de8) This illustrates the use of a simple query.  It is different than what we did in class.  It gets a distinct list of cities and states and saves them in an array list.  The list is then used to feed the prepared query
  *  [sql_030c](https://mwsu.hosted.panopto.com/Panopto/Pages/Viewer.aspx?id=9e0b65c- [SQL & Java Tutorials](#sql--java-tutorials)
  - [Links to the videos.](#links-to-the-videos)
  - [SQL 010 The Database Utility in Intellij](#sql-010-the-database-utility-in-intellij)
  - [SQL 020 Reading Credentials](#sql-020-reading-credentials)
    - [SQL_020A Reading Passwords](#sql_020a-reading-passwords)
      - [Method 1 (Just the password)](#method-1-just-the-password)
        - [Code for reading the password](#code-for-reading-the-password)
      - [Method 2](#method-2)
        - [code for reading the credentials](#code-for-reading-the-credentials)
      - [Method 3 Credentials Overkill with XML](#method-3-credentials-overkill-with-xml)
  - [Direct SQL (with an arraylist and a different type of query)](#direct-sql-with-an-arraylist-and-a-different-type-of-query)
    - [The mysql dependencies](#the-mysql-dependencies)
    - [Prepared queries](#prepared-queries)2-9b45-4579-b6ee-ae41016c1ee4) This uses the prepared statement technique to gather data about each individual city.  It is slow, but it works.
## SQL 010 The Database Utility in Intellij

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

## Direct SQL (with an arraylist and a different type of query)

### The mysql dependencies 

```xml
 <dependencies>
      <dependency>
      <groupId>org.mariadb.jdbc</groupId>
      <artifactId>mariadb-java-client</artifactId>
      <version>3.0.3</version>
    </dependency>
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.28</version>
    </dependency>
</dependencies>
```

[Here is a link to the code](01_DataExchange/mysql_Series/Source_Code/030_Full_SQL_Program.pdf).  This applies to the rest of this document.  I made it a .pdf because I didn't want pure copy/paste for homework 04.

The direct code creates an ArrayList containing Strings.  The strings are a city name and state.  It is a tab-delimited string in this example

### Prepared queries

The example [in the code](01_DataExchange/mysql_Series/Source_Code/030_Full_SQL_Program.pdf) illustrates how prepared statements may be used to fetch the data for each city. 
