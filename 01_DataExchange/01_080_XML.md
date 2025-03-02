# 01.080 XML

## Overview

XML major uses

| Intended use                       | Comment                                                                                                                                 |
| :--------------------------------- | :-------------------------------------------------------------------------------------------------------------------------------------- |
| Transmitting data between systems. | It is, in effect, **_serializable_** data that may be transmitted between applications. It is better than JSON and Java Serialized data in some ways.  However, it is rather bulky and bloated. |
| Holding configuration data         | We have seen a lot of that in Maven                                                                                                     |
| Database                           | There were hopes that XML would replace databases, but people came to their senses.                                                     |

I think XML is better for interprogram communication because it can enforce standard format for the data.

## About XML

- XML is a markup language that is used for storing and transmitting arbitrary data
- Based on SGML
  - HTML was originally based on SGML, so there is a lot in common
  - HTML4 was called XHTML and was actually XML. HTML is no longer strict XML, or even strictly SGML
- Version 1 was developed in 1998
  - There is a version 1.1, but it is rarely used
- Character set
  - Fully unicode compatible
  - &amp; and &lt; may not appear in XML except as escape characters 
  - &gt; and quote marks are allowed except in some special cases.
  - Entities (see below) must be used for &amp; and &lt;. It is a good idea to also use entities for &quot; and &apos; when they are in strings. []
  - I find &amp;nbsp; is also handy for non-breaking spaces. Also, I needed it for the last line of the table below because you can't have blank columns.
  - The Null character (ASCII 0) or &

## Entities

The regular [HTML Entities](https://www.w3schools.com/html/html_entities.asp) work in XML. They also generally work in markdown (Markdown is translated directly to HTML)

| Symbol |   Entity   |
| :----: | :--------: |
| &amp;  | &amp;amp;  |
|  &lt;  |  &amp;lt;  |
|  &gt;  |  &amp;gt;  |
| &quot; | &amp;quot; |
| &apos; | &amp;apos; |
| &nbsp; | &amp;nbsp; |

## Structure of an XML document

- The first line must be the version number

```xml
<?xml version = "1.0"?>
```

- There must be a root node to the document
- Tags are paired like in HTML
  - Closing tags have a / as in HTML
- Tags may be unpaired. Unpaired tags must use the notation of putting a / before the closing > symbol. For example, `<hr />`
- Tags may have attributes

```xml
<?xml version = "1.0"?>
<person>
   <name>
    <first>Max</first>
    <last>Griffon</last>
   </name>
   <phone type="cell">816.555.5555</phone>
   <phone type="office"> 816.271.4308 </phone>
   <!-- A random comment -->
</person>
```

### Comments

Comments are the same as HTML. &lt;!-- This is a comment -->

-- is not allowed inside comments

### Attributes

### Limitations of Attributes:

I think of attributes as being "one dimensional" and not very flexible.

* Attributes cannot contain multiple values
* Attributes are not easily expandable
* Attributes cannot describe structures
* Attributes are sometimes harder to access in code 
* Attributes are not easy to test in a DTD

There are several different recommendations about whether to use attributes or to use child elements.  One guideline is to use attributes like adjectives where the element itself is a noun

I have personally run into situations where attributes were being ignored in code.

In most cases it is probably better to structure the attributes as child elements.

```xml
<?xml version = "1.0"?>
<!-- Example of structuring the phone as child elements instead of attributes -->
<person>
   <name>
    <first>Max</first>
    <last>Griffon</last>
   </name>
   <phone> 
       <cell>816.555.5555</cell>
       <office>816.271.4308</office> 
    </phone>
</person>
```

## Major XML Tools

### Displaying XML

Browsers "grew up" with XML being a new thing.  Most web browsers are useful XML viewers

### Validators

* Well-formed XML
* Valid XML

"Well-formed" and "Valid" are two different things.

Well-formed means that the XML file follows the syntax rules.  The "states" database is not well-formed because it contains & symbols that are not escaped.

Valid means the document meets the standards of a DTD or Schema

There are many XML validators.  A lot of editors will validate as they edit.  

THe W3.org validator is 

* [https://validator.w3.org/](https://validator.w3.org/) (Mainly validator)
* https://www.xmlvalidation.com/ (Checks for well-formed with option for validation)

#### Namespaces `xmlns`

With many industries using XML there is a potential for conflict between tag names.  Name spaces resolve this.

See [https://www.w3schools.com/xml/xml_namespaces.asp](https://www.w3schools.com/xml/xml_namespaces.asp)

Namespaces are defined at the top of the document.  Usually it is two or three letters.  It comes before each tag (See the Schema discussion below for an example)

#### DTD

See [https://www.tutorialspoint.com/xml/xml_dtds.htm](https://www.tutorialspoint.com/xml/xml_dtds.htm)

* DTDs are the old option for specifying what must be in a valid XML File
* DTDs have problems
  * They have their own syntax
  * They are not very complete
  * They can't really specify data types
  * They do not do attributes

Despite having a lot of problems, DTDs are still widely used.

```html
<?xml version = "1.0" encoding="utf-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html>
   <!-- Head and Body tags go here -->
</html>
```

#### Schemas

Schemas are technically better than DTDs on almost every point.  But DTDs became established before Schemas were released.  Therefore Schemas are not as widely used.

See [https://www.w3schools.com/xml/schema_intro.asp](https://www.w3schools.com/xml/schema_intro.asp)  This is also a nice example of namespace use


#### Styling and Display with XSLT

* [https://www.w3schools.com/xml/xml_xslt.asp](https://www.w3schools.com/xml/xml_xslt.asp)
* Visit [https://w1.weather.gov/xml/current_obs/KSTJ.xml](https://w1.weather.gov/xml/current_obs/KSTJ.xml) and then do Ctrl-U to view the source  
  * Unfortunately, this link no longer works.  It was a good example of the projected use of XML to display large amounts of information as web pages

#### Combining XML files

One feature of XML is th ability to combine files.  

One way to combine files is with XSLT.  See [https://stackoverflow.com/questions/19021205/merging-two-xml-files-using-xslt/19023823](https://stackoverflow.com/questions/19021205/merging-two-xml-files-using-xslt/19023823)

## Notes:

- [States Database](https://civilserviceusa.github.io/us-states/data/states.xml) Effectively an array with states as the root. It is only one-layer deep. No nested elements
- [St. Joseph Weather](https://w1.weather.gov/xml/current_obs/KSTJ.xml) Now view the source and the [source for the XSL translation page](view-source:https://w1.weather.gov/xml/current_obs/latest_ob.xsl)
- Survey of the XML parsers for Java [https://www.baeldung.com/java-xml](https://www.baeldung.com/java-xml)
