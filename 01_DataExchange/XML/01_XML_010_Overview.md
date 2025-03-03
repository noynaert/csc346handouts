# 01 XML 010 Overview of XML

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

## Namespaces `xmlns`

With many industries using XML there is a potential for conflict between tag names.  Name spaces resolve this.

See [https://www.w3schools.com/xml/xml_namespaces.asp](https://www.w3schools.com/xml/xml_namespaces.asp)

Namespaces are defined at the top of the document.  Usually it is two or three letters.  It comes before each tag (See the Schema discussion below for an example)

## XML Tools

XML has a lot of tools for manipulating XML Data.

### Styling and Display with XSLT

* [https://www.w3schools.com/xml/xml_xslt.asp](https://www.w3schools.com/xml/xml_xslt.asp)
* Visit [https://w1.weather.gov/xml/current_obs/KSTJ.xml](https://w1.weather.gov/xml/current_obs/KSTJ.xml) and then do Ctrl-U to view the source  
  * Unfortunately, this link no longer works.  It was a good example of the projected use of XML to display large amounts of information as web pages

### Combining XML files

One feature of XML is th ability to combine files.  

One way to combine files is with XSLT.  See [https://stackoverflow.com/questions/19021205/merging-two-xml-files-using-xslt/19023823](https://stackoverflow.com/questions/19021205/merging-two-xml-files-using-xslt/19023823)

## Notes:

- [States Database](https://civilserviceusa.github.io/us-states/data/states.xml) Effectively an array with states as the root. It is only one-layer deep. No nested elements
- [St. Joseph Weather](https://w1.weather.gov/xml/current_obs/KSTJ.xml) Now view the source and the [source for the XSL translation page](view-source:https://w1.weather.gov/xml/current_obs/latest_ob.xsl)
- Survey of the XML parsers for Java [https://www.baeldung.com/java-xml](https://www.baeldung.com/java-xml)
