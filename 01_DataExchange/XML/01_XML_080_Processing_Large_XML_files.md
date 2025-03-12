# 01 XML 080 Processing Large XML Documents

A lot of large XML files are large.  They are too large to load into memory all at once.  

There are methods of processing documents in pieces.  They do not load the entire document at once, so the document can't be traversed or searched.  The Java program extracts needed information, or puts it in a new XML document.

* SAX -- This is the older model, but it is still useful
* StAX -- This is a newer model

&nbsp;|SAX|StAX
:---|:---|:---
Can read xml files|Yes|Yes
Can write xml files|No|Yes
Validation|Yes|No
Parsing<br/>model|push (event-driven)|pull (iterator-based)
Error<br/>Handling|Tricky|Easier

The important thing to recognize with both SAX and StAX is that they don't "know" anything about the structure of the document. ***The document tree is not saved.*** It is up to the programmer to impose the structure. ***The program is just reacting to tags.

Both SAX and StAX work in terms of `startElement` and `endElement`.  What they are talking about is what we would call "opening tag" and "closing tag."  An HTML example of a startElement would be &lt;p> and the closing element would be &lt;/p>.