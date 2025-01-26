# Comparators

## Sorting with Collections.sort()

The simple form of `Collections.sort()` sorts a List or an ArrayList.  It requires that the `Comparable` interface be implemented by the class.

## Problems with the simple form

There are two situations where the "default" comareTo method does not work

* If the class did not implement the `Comparable` interface
* If you want to sort the list by some criteria different than the default compareTo method implements.

### The `Comparator` Interface

```java

```