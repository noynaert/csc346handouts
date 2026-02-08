# 01 LDB 020 Local Databases

## Popular Local Databases
Some popular local databases include:
- SQLite: A lightweight, file-based database that is easy to set up and use.  It is widely used in mobile apps and small desktop applications.
- H2 Database: A Java-based database that can run in embedded mode or server mode.  Included by default in Spring Boot.
- Apache Derby: A Java-based database that can run in embedded mode or server mode.  It is included with the Java Development Kit (JDK) as Java DB.
- Many others, including HSQLDB, Firebird Embedded, and more.
 
## SQLite

SQLite is a favorite of computer science students.  It stores the entire database in a single file on the local machine.  

It may be accessed directly from Java.  However, it has some major limitations.  It does not support stored procedures or user-defined functions. It lacks features for testing. It also has limited support for concurrency, which can be a problem for multi-threaded applications.

Android applications often use SQLite as their local database.  It is also used in web browsers like Firefox and Chrome for storing user data.


## H2 Database

The H2 Database is another popular Java-based local database.  It is known for its speed and small footprint.  It can run in embedded mode or server mode.  It supports stored procedures, user-defined functions, and transactions.  It also has good support for concurrency.


H2 is often used in development and testing environments due to its speed and ease of use.  It also has a web-based console for managing the database.

H2 is part of the Spring Boot framework, which is widely used for building Java web applications.  It is often used as an initial database during development before switching to a more robust database for production.

H2 is known as being very lightweight and fast.  It is a good long-term choice as long as there is not extremely heavy concurrency.

## Apache Derby

Derby is the traditional workhorse local database for Java applications.  In fact, some people refer to it as Java DB.

Apache Derby is a Java-based local database that can run in embedded mode or server mode.  It is more feature-rich than SQLite and supports stored procedures, user-defined functions, and transactions.  It also has better support for concurrency.  In fact, it has full ACID compliance in multi-user environments.  It also has strict, full SQL compliance.
