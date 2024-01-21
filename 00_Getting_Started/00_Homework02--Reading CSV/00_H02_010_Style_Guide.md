# 00.H02.010 Style Guide

[Oracle Style Guide](https://www.oracle.com/technetwork/java/codeconventions-150003.pdf)

## Predictable Id Names

One rarely mentioned characteristics of well-written Java is that Ids are often predictable.  This is especially true in JavaFX and Stream packages.

## Self-Documenting Code

Code should be as self-documenting as possible. Use meaningful variable names is a big part of making code self-documenting.

There should not be comments for things that should be obvious to a professional programmer.

This is bad:

```java
    payment = count * cost; // calculate payment by multiplying count times cost
```

Other than JavaDoc comments, comments should be limited to situations where clarification or reminders are specifically needed.

### Singular vs Plural

Pay attention to singular and plural identifiers.  Use singular if one thing is being referenced.  For example, a POJO that corresponds to a record in a database should normally be singluar.   Plural identifiers would refer to things like lists and arrays.

### Nouns vs Verbs

As a general rule of thumb, variables and class names should be nouns.  Most functions do something, so verbs and verb phrases are often appropriate.

Be careful about whether IDs are singular or plural

## Class Names

Class names are capitalized.  The letters following the first name should be mixed case

Interfaces are really a form of a class.  Therefore, interface names should be capitalized.

Enum are also considered a class.  The values in the enum type are considered `final` so they are in ALLCAPS.

## Final values should be ALLCAPS

## Variable names

- Variable names should be meaningful.  Don't use cute names that are unrelated.
- Use camelCase

### Do not abbreviate

The Java convention is to spell out variable names.

* If you abbreviate, you have to remember whether you abbreviated or not.
* If you abbreviate, you have to remember how you abbreviated.
* Avoids having different abbreviations for the same thing in different parts of the program.

### Single letter variable names

Single letter variable names are discouraged.  There are some exceptions.  They should generally be used only in very small, generic methods where there is no reasonable variable names.

## Conventional Single Letter (and short) variable names

* n
* i
* s
* x
*(x, y)
* a, b, c for numbers
* ch, c
* tmp is preferred to temp because it might be confused with things like "temperature."

## Avoid Negatives and Negative Logic

Whenever possible, boolean variables should be positive statements. 

If you need to use negative logic, keep the boolean expression as simple as possible.
