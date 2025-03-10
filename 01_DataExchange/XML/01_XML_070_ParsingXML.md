# 01 XML 070 Parsing (Reading) XML Files

Reading XML files is referred to a "Parsing."  There are quite a few different packages available, and it can be intimidating.  There are basically two methods for parsing the files:

* The entire file is read into memory and held there as the DOM.  Your program may extract nodes from the tree.
* The file is processed as nodes, and it is never entirely represented in memory.

The first method is useful for small files.  On modern computers, Files of up to about a megabyte may be handled comfortably.

However, XML is often used to maintain large and complex files.  In these situations, large files are parsed as they are processed, and the calling program must extract data as it flows through the system.

