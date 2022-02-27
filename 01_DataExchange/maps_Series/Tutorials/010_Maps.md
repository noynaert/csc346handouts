# 01 Maps

[Links to the video folder](https://mwsu.hosted.panopto.com/Panopto/Pages/Sessions/List.aspx?folderID=d3ef0ce2-7959-429b-ad65-ae49006320c1)


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