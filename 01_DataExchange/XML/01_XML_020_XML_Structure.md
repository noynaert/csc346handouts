# 01 XML 020 XML Structure and Syntax

## XML Prolog

```xml
<?xml version="1.0" encoding="UTF-8"?>
```

There is technically a version 1.1, but almost everything uses 1.0.  

## DTD or schema (optional)

We will cover it later because it is optional.

## The XML Itself

* There is always a root element.  There may only be one root in a document.
* The text in the tags are called "Elements."
* The elements form a tree.
* Most nodes are paired.
  * `<thing>` would be the opening node, and `</thing>` would be a pair.
  * There may be unpaired tags.  Unpaired tags end with a slash.  For example `<thing/>`
  * There are no set tags, unless they are specified in a DTD or Schema
  * The tags must be properly nested
  
  The data is either in attributes or between the tags.  Some characters, such as &lt; have special meanings in XML, so you must use "HTML Entities" in their place.

### Entities

The regular [HTML Entities](https://www.w3schools.com/html/html_entities.asp) work in XML. They also generally work in markdown (Markdown is translated directly to HTML)

| Symbol |   Entity   |
| :----: | :--------: |
| &amp;  | &amp;amp;  |
|  &lt;  |  &amp;lt;  |
|  &gt;  |  &amp;gt;  |
| &quot; | &amp;quot; |
| &apos; | &amp;apos; |
| &nbsp; | &amp;nbsp; |

## Reprise of DTD


DTD is older and more common.  Schema is more powerful and flexible

The DTD or schema is optional.  

The DTD does not follow XML syntax.

Ways to handle DTD's:

* It is rare to directly specify the DTD like I have done here.  
* It is more common for it to be a reference to a URI.  
* They may be brought in by `<&import ...>` statements
* Or, a third-party lint tool may apply an external DTD.

```xml
<!DOCTYPE person [
    <!ELEMENT person (name,email,phone)>
    <!ELEMENT name (#PCDATA)>
    <!ELEMENT email (#PCDATA)>
    <!ELEMENT phone (#PCDATA)>
    <!ATTLIST phone type CDATA "cell|work|fax|home">
]>
```
An example with nesting

```xml
<!DOCTYPE people [
    <!ELEMENT people (person*)>
    <!ELEMENT person (name,email,phone+)>
    <!ELEMENT name (firstname,middlename?, lastname)>
    <!ELEMENT firstname (#PCDATA)>
    <!ELEMENT lastname (#PCDATA)>
    <!ELEMENT middlename (#PCDATA)>
    <!ELEMENT email (#PCDATA)>
    <!ELEMENT phone (#PCDATA)>
    <!ATTLIST phone type CDATA "cell|work|fax|home">
]>
```
