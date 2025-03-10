# 01 XML 060 Creating XML Files.

&nbsp;|&nbsp;
:---|:---:
The root for our tree has a Document as its super-root<br/><br/>The Document is called the `DOM` that stands for the Document Object Model.  It is a tree that represents an HTML or an XML document|![DOM Figure](HTML-DOM-Diagram-PNG.png)

## The all-important Document

The Document is a generic tree for any web page.  Note that it is W3C.

We are first going to create and populate the tree.

At this point, the tree is generic.  We need to ***transform*** it to XML.  We have some fine-tuning we can do to say what types of things should be in the XML file.

If we want to output to a file, we need to create a "StreamResult" that says where to put the result.