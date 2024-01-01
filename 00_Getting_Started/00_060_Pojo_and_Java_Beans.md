# 00.080 POJOs and JavaBeans

## POJO -- "Plain Old Java Object"

What we have been setting up are sometimes called "Plain Old Java Objects" or POJO.  

Different people define POJO a little differently.  But generally a POJO refers to a typical Java Object that includes getters, setters, and constructors.

Some people say any Java Class is a POJO.  But others (including the instructor) distinguish between POJOs and other Java Object.  Some Java objects are basically housekeeping operations.  

For this course I will use the term POJO to refer to objects that conform to the following:

* A POJO could usually be a record in a database.  Very often the POJO represents some real-world object or an abstraction of a real-world object.
* Most data fields are either:
  * private
  * static and final
* There are getters for all fields that a user could reasonably need to read the value
* There is a setter for all fields.
  * Some setters may be private
* It has a toString() method that gives some useful output, at least for debugging purposes
* Usually implements the Comparable interface.
* It is usually created with the a Constructor rather than a Factory or Builder type of operation.

## Java Beans

Some operations require an object to be a Java Bean.  

* A Java Bean is a POJO, but not all POJOs are Beans.
* All data fields are either
  * private
  * static and final
* There are getters and setters for all fields.  (In some cases a setter may do nothing, but there still needs to be a setter)
* There is a default or no-Arg constructor
* Serializable.  Originally a Bean had to to implement the serializable interface.  But in recent versions of Java the serializable interface has no functionality.  Therefore many Java Beans do not implement a serializable interface.  

## Serializable Interface.

Serialization was considered a big deal in the original Java.  A serializable object could convert itself into a sequence of bytes, and convert a sequence of bytes into an object.

The idea was to make communication easy between Java programs.  One program could convert an object to a stream of bytes.  The string of bytes could be written to a file or passed over a network.  Then another Java program could then read the file or network data and create a new object from the stream of bytes.

Serialization was a good idea.  But it had one giant flaw.  It really only worked between Java programs.  Something like JavaScript, C, or Python probably could not read and write objects in the same format that Java uses.

One of the original conceits of the Java creators was that Java would replace all other languages.  It would even replace HTML.  Therefore Java programs would be calling other Java programs and passing data.

What really happened was that XML and JSON became the standard methods of passing data between programs.  Recently YAML has also become popular.

Now most programs in all languages serialize data by passing JSON.  The serialization interface in Java became only a "Marker" class and has no requirements of a normal interface.