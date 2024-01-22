# 00.H02.040 For Each Loops

Some languages have "foreach" loops.  Java's equivalent just uses "for."  

Some classes also have .forEach() methods.  Those are a little different.  They are called "Iterators." If we cover them, we will do so later.

The ForEach construct works on most Collections.  That includes things like ArrayLists and Sets.  It also works on arrays that are full.

The big limitation on the loop is tha it does not give you an index.

```java
String[] parts = "Rubber bumpered baby buggies".split(" ");

//parts is now an array that is full.
for(String s : parts)
    System.out.println(s);
```

What happens if the array is not full?

```java
double[] numbers = new double[5];
numbers[0] = Math.PI;
numbers[1] = -3.2;
numbers[2] = Math.E;
// Only 3 of the five positions have been given values explicitly.
for(double x : numbers){
    System.out.println(x);
}
```
