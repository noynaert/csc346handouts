# 01 XML Builders and Factories

Constructors sometimes don't work well, especially for objects that may be dynamic, complex, or need to be built in parts.  This often applies to nested objects. 

There are two ***design patterns*** that are commonly used.  With XML, we will be using the Builder pattern, but people often get Builder and Factory patterns confused.

I think of the difference like this:

* Factories are used when there are several closely related classes and interfaces involved.  The client may not know exactly what subclass they are getting.  The object is created at one time.
  * Normally, the super class for the factory is an abstract class or an interface.
  * All of the parameters must be sent at the time of creation.  If some parameters are unknown, they must be sent as `null`.
  * [Link to Digital Ocean material on factories](https://www.digitalocean.com/community/tutorials/factory-design-pattern-in-java)
* Builders are for a known object that gets built in parts.  This is typically used in nested structures.
  * Builders typically have something that looks like a constructor that may take a fixed set of parameters.  
  * The constructor is normally chained with one or more method calls.  The chain ends with .build() that actually makes the object.
  * [Link to Digital Ocean information about Builder Classes](https://www.digitalocean.com/community/tutorials/builder-design-pattern-in-java)

## It gets worse...

One common use of factories is to create builder.  We end up getting monstrosities of builderfactories. 