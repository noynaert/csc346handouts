# 00.070 Generics

Generics mean subtituting a type.  

Generics are used in things like ArrayLists where a class will work with a specific data type.  

In early versions of Java, we had to do a lot of type casting. Things like ArrayLists worked on the Object class.  We had to do specific typecasts when we needed something specific from the class.  Examples would be 

```java
public int compareTo(Object o){
    return (Person)name.compareTo((Person)o.name);
}

Now we use generic.  It basically eliminates the need to constantly cast types.

```java
public int compareTo(Person o){
    return name.compareTo(o.name);
}
```

## Standard Letter Types

When Generics first came out, there was a lot of debate about what letters to use.  Now we mostly use things that make sense.  Here is a general guideline, but don't stress out too much on which letter to pick.

Letter|Meaning|Notes
:---:|:---|:---
E|Element in a collection or an array|Most commonly used.  It is 
K|Used in Maps
V|Used in Maps
N,X|A numeric type|X isn't standard, but I have seen it used that way.
S|String| If the item is almost certainly a String, then use it.  But if it is always a String, then why use a generic?
T|Type|This is a catch-all.  All of the generics are types.  But if the others don't really apply, use T
U,V,W...|For 2nd, 3rd, 4th data Types
