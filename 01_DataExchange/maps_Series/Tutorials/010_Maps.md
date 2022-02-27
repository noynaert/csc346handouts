# 01 Maps

[Links to the video folder](https://mwsu.hosted.panopto.com/Panopto/Pages/Sessions/List.aspx?folderID=d3ef0ce2-7959-429b-ad65-ae49006320c1)

Video|Notes
:---:|:---
[005 Wrappers and Boxing](https://mwsu.hosted.panopto.com/Panopto/Pages/Viewer.aspx?id=35d0ec89-64da-44c6-b8ab-ae490064ff87)|This is about wrapper classes and boxing.  It may be helpful in understanding how to handle integers in Homework 05.
[010 Basic](https://mwsu.hosted.panopto.com/Panopto/Pages/Viewer.aspx?id=ddc57ecf-fd09-415d-bd6f-ae490064ff7a)|This is mostly a repeat of what we did in class. Feel free to skip it if you understand what is going on with Maps.
[020 Going Generic](https://mwsu.hosted.panopto.com/Panopto/Pages/Viewer.aspx?id=cb53b389-89e4-431c-bf0c-ae490064ff74)|I did this in class, but it was rushed.  It covers an idea that will become more important from here on in the course.  We use a Superclass to declare a variable, even though the class is abstract and we cannot create an instance of the class
[030 Counting Lotto Picks](https://mwsu.hosted.panopto.com/Panopto/Pages/Viewer.aspx?id=01ad6692-098b-4c12-9f22-ae490064ff77)|This should be helpful in Homework 05.  It is counting how often lotto numbers have occurred.

This video is a quick introduction for Java Maps.  It is being produced for CSC 346, but I will try
to keep it general enough for reference.

## Overview

Maps are a common feature in modern computer languages.  They may be called "Associative Arrays" in some languages.

In most modern languages, a Map is data stored by using a string as an index instead of an integer.

In Java we may use Strings as index.  But we may use other objects as well.

## UML Diagram for the major Map Classes
From [Java Code Geeks](https://examples.javacodegeeks.com/wp-content/uploads/2019/07/javamap.jpg.webp)

![Java Code Geeks illustration](https://examples.javacodegeeks.com/wp-content/uploads/2019/07/javamap.jpg.webp)

### The major concrete subclasses

&nbsp;|**HashMap**|**HashTable**|**TreeMap**
:---:|:---|:---|:---
Ordered|No|No|Yes
Thread-safe|No, non-synchronized|Yes, Synchronized|No, non-synchronized
Ordered|No|No|Yes
Speed| Faster than a HashTable|Slower than a HashMap|Slower than either
Null keys|One null key allowed|No null key|No null key
Null values|Allowed|Not Allowed|Multiple keys may have null values
Requires<br>equals() and hashcode()|Yes|No|No (I think)

Reference: [https://examples.javacodegeeks.com/java-map-example/](https://examples.javacodegeeks.com/java-map-example/)