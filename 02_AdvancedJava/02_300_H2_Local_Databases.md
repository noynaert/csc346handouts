# 02.300 H2 Local Databases

Databases are useful.  They are better than flat files for a lot of purposes.  

- They have built-in mechanisms for adding, deleting, and updating records
- They have selection and filtering mechanisms built in.
- They have built-in mechanisms that assure data integrity.  Some also insure transactional integrity (if one part of an update fails, the entire update is retracted)

The problem is they are usually bulky.  They either require a remote server or a local install of some bulky software.

One solution is some type of "light" database object that may be embedded or packaged with the program.

There are several available.

- **SQLite** [https://www.sqlite.org/](https://www.sqlite.org/)
  - It creates a single database as a single file.  The file itself is executable.  So you end up with the executable program that includes the database itself.
  - The interface is like the mysql client.  Therefore it is easy to integrate into most programming languages.  It works with Java, Python, JavaScript/NodeJS, PHP, and other languages.
- *H2* [https://www.h2database.com/](https://www.h2database.com/html/download.html) is written in Java.  
  - H2 comes as an executable .jar file.  You only need the Java JRE installed to run it (not the JDK).
  - All platforms (Windows, Mac, Linux, Android, iPhones) use the same executable
  - Very fast and lightweight
  - Handled natively by things like Maven, Spring, and Java installers

## Use Cases

### Memory-only

Sometimes we only need to keep data during a specific run of a program.  For example, we might want to keep track of the path a player took during a game, or the amount of time they are taking to do a task.

The key thing is that the database is reset to empty for each run.

### Data Persistance

Sometimes the database is needed to maintain data between runs.  For example, what treasure has the player got in their inventory at the end of a session

### Hybrid

Sometimes it is necessary to load some standardized set of baseline data, then accumulate temporary data.


## Limitations

A local database cannot share data with other users. 

Sometimes we need to collect data to a central server.

## Prototyping and Proof-of-Concept

Sometimes it is useful to just use an internal database when you are starting up a new project.  