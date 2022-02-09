# 01.070 MySQL and Databases

We will be looking at databases in two different ways.  

1. Direct access with JDBC
2. In Spring Boot


## JDBC

*Java Database Connectivity* is an API for connecting databases to Java.  The JDBC itself is part of the standard Java platform.  But it is still necessary to download connectors and be aware of the idiosyncrasies of the SQL of the database. (Oracle, mysql, dBase, DB2, etc).

JDBC assumes a relational database using SQL.

You still have to download ***connectors*** for your specific database.  

Two major data structures:

* **_Statements_** : Statements are not the query string.  Statements are the data structure the supports the query string or update. 
* ***Result Set*** : The Result Set is the data structure you get back.  It is row and column oriented.  
  * Each row is a record.  
  * Each column is a field.  Columns are numbered starting at 1
* Processing the RS is somewhat like scanner syntax.  It is usually done with a `while(rs.next())` loop.

### JDBC Dependencies

```xml
    <dependencies>
        <!-- https://mvnrepository.com/artifact/org.mariadb.jdbc/mariadb-java-client -->
        <dependency>
            <groupId>org.mariadb.jdbc</groupId>
            <artifactId>mariadb-java-client</artifactId>
            <version>2.7.5</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.22</version>
        </dependency>
    </dependencies>
```

Watch for one-time messages in Intellij saying that something needs to be downloaded.

## Direct query

In the example in [the sources](https://github.com/noynaert/csc346handouts/blob/main/01_DataExchange/sourceCode/mysql01/src/main/java/App.java) I used the main() function to establish the credentials and construct the JDBC connetion string.

```java
    public static void main(String[] args) {
        String user = "csc";
        String password = "sandra4288";
        String host = "localhost";

        String connectString = String.format("jdbc:mysql://%s:3306/misc", host);
        System.out.printf("The connection string is \"%s\"\n", connectString);

        directQuery(user, password, connectString);
        preparedStatement(user, password, connectString);
        System.out.println("\nDone!");
    }
```

Here is the code for direct query statement:

```java
public static void directQuery(String user, String password, String connectString) {
        String query = "select state, nickname from states order by nickname";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(connectString, user, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String stateName = rs.getString(1);
                String nickname = rs.getString(2);
                System.out.printf("%-20s %s\n", stateName, nickname);
            }
            con.close();
        } catch (Exception e) {
            System.err.println("ERROR:\n" + e.getMessage());
        }
    }
```

## Prepared statements

[Reference: jenkov.com](http://tutorials.jenkov.com/jdbc/preparedstatement.html#:~:text=A%20Java%20JDBC%20PreparedStatement%20is,the%20features%20of%20the%20PreparedStatement%20.)

Prepared statements are pre-packaged sql statements that allow the user to plug in specific fields.

Advantages:

* Programmer does not need to be an SQL expert.  The SQL guru can prepare a complex SQL statement and let the programmer "plug in" the required fields.  
* The prepared statement may be maintained separately, not in each piece of code where the query is used
* Potentially faster execution
* Potentially greater security
  * Reduces footprint for SQL Injection attacks
  * Some databases allow restricting remote queries and updates to prepared statements

## Security

### SQL Injection

![Mandatory XKCD Cartoon](https://imgs.xkcd.com/comics/exploits_of_a_mom.png)
