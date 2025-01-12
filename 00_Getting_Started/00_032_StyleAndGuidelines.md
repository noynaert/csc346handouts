# 00.032 Style and Guidelines

## The culture of Java is unique 

Before Java, languages like C and C++ would have local styles used at a company or on a project.

Java was unique because there was a common coding style that is used almost universally by all Java programmers.  It makes bringing in new packages much easier.  It is often possible to guess variable names and methods because they follow the accepted style.

## Self-documenting code

Code should be "self documenting" as much as possible.  This reduces the need for comments.  Excessive comments can be distracting and make maintenance more difficult.

## Variable Names

Most variable names should be meaningful.

* Do not abbreviate.
  * If you abbreviate sometimes, you have to remember whether you abbreviated.  Then you have to remember how you abbreviated.  Avoid the problem.  Don't abbreviate.
  * Use conventional single-letter variable names.  Don't use them for other purposes
    * i, j, and k should be used for indexes in loops
    * n should represent the number of items on a list or the number of active items in an array.
    * e for exception in catch() clause
    * s may be used for a String in a very short scope.
    * x, y, a, b, and c may be used for temporary, short-term variables in demos.

## Javadoc comments

* Javadoc comments should be at the top of all classes.  They should give a description of the class.
  * Should include @author
  * Should include @since
* Javadoc comments should be in front of all non-standard methods.  They are not required in front of getters, setters, constructor, or toString methods unless those methods do something in a non-standard way.