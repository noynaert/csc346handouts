# 01.CSV.020 POJOs and Java Beans

POJOs and Java Beans usually hold data about one record.

Java Beans are POJOs with a little bit extra

## POJO

### Plain Old Java Objects

* Objects are created with Constructors
* Instance data fields are private
* There are getters and setters for all fields that require external access
  
## Java Beans

Java Beans are formalized POJOs with some additional requirements.  Most well-formed POJOs will be easy to make into Java Beans

* There must be a public default constructor
* The class must implement the Serializable interface

## Motivation for Java Beans

The idea with Java Beans is that objects can be written and read as a whole. 

### The Serializable Interface

The Serializable Interface is now a marker.  There are no methods that must be implemented.  The spirit of something being serializable is that there should be methods that allow reading and writing the entire object as a single unit.

