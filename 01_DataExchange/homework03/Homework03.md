# XML assignment

A significant component of this assignment is demonstrating that you can learn technical material on your own.  Most of your groups will have software assigned that the instructor does not know.  *You* will become the local expert on that software.  Some people will be experts on the xml software.  Others will polish their Github and Markdown skills.

## Roles

Teams are three or four people.  Generally I put four people on teams with software packages that I thought would be more challenging.  I envision three roles for team members

* coder  -- Writes the java programs
* writer -- Writes the tutorial
* librarian -- Keeps things organized and handles github

I think in most cases some groups will combine roles.  For example, two people may be coders and one person handles both librarian and writer duties.  Or you may have someone who is both a coder and assistant librarian.

## Reference articles: 
[Baeldung article that is the basis of the groups](https://www.baeldung.com/java-xml)
[Survey of DOM and SAX parsers](https://www.javatpoint.com/xml-parsers) 

## Groups of XML Parsers

* 2. DOM Parsers  -- Read the entire XML file into memory
* 3. SAX parsers -- Only reads the parts that are needed into memory
* 4. StAX Parser -- Median between a DOM and SAX parser
* 5. JAXB -- Converts objects to/from XML
* 6. XStream -- Converts XML to/from serializable object
* 7. Jackson XML 
* 8. Simple XML

Groups are based on the [https://www.baeldung.com/java-xml](https://www.baeldung.com/java-xml) article category.  Start by reading through your section and checking out the resources listed.

### Group 2

Illustrate input and output using a simple DOM parser

* Devon Amos
* Max Durbin
* Tristan Davis

### Group 3
	
Illustrate input and output using a SAX parser

* Jon Chapman
* Josh Stevenson
* Eliot Kimmel
* Mac Koontz

### Group 4
	
Illustrate input and output using a StAX parser

* Kaleb Morcha
* Riley McNeely
* Cole Atkinson
* Luke Townsend

### Group 5
	
Demonstrate converting XML to and from a POJO object

* Will Malita
* Aaron Grant
* Melissa Bayer
* Christin Wilson

### Group 6
	
Illustrate converting XML to/from serialized object using XStream

* Shane Slater-Pinnick
* Alex Perpitch-Harvey
* Jamil Whitehead
* Josh Mesmer

### Group 7

Illustrate input and output using Jackson 

* Nick Wright
* Kassidy Ashworth
* Michael Huyne Le
* Nicholas Wu


# Group 8

Illustrate Input and Output using Simple XML

* Nick Write
* Cooper Jones
* Marshall Stone
* Gabe Adams

## The assignment

The assignment is to write a tutorial on your assigned topic.  Assume the audience are student programmers at your level (CSC 346).  This is a pretty wide range that you can target.  We have some students in this class who consider themselved pros an others who are wondering how they passed 254.  Pick the level of your tutorial from that range.

Your tutorial should be a repository on github.  At a minimum, it should have the main tutorial in the README.md file.  

### Examples you should use

Each group should write a tutorial with working examples.

You should have examples that parse the three following items of code.  It is fine to load the first and third from a local file because the data is not dynamic.  However, the weather data should come from live data at the URL.  (NOAA will not run out of page views late in the month).

* [A simple xml file](woz.xml) Be sure to pull the password hint which is an attribute.
* [Nested XML file](https://w1.weather.gov/xml/current_obs/KSTJ.xml) Don't get distracted by the xsl(Ignore the main web page and view the source).  You don't need to extract all of the fields, but do some fields that are at the top level and some that are nested.  For example, do observation_time_rfc822 or the &lt;image>&lt;url>
* [An array expressed as XML](https://civilserviceusa.github.io/us-states/data/states.xml)

Exactly what your tutorial illustrates will depend on your group.  If your topic mainly loads the software, then just do input and output.  

Some groups will need to create POJOs of the objects.  The POJOs do not need to include all of the fields for weather or the individual states.

Some groups will need to serialize their data.  It may be easier to serialize the full object, or you might just create a limited serializable object.

## Github and Markdown

Each group will need a repository.  I have a fantasy that all members of your team will use the repository to upload and download the files that they are contributing.  But it is OK if your team librarian collects the information and posts it for the group.

There are many tutorials on using github.  You don't need to be very sophisticated if there is only one librarian.

I think the easiest way to make a repo is to create the public repo on github with a Readme and a Java-based .gitignore.  Make the license Creative Commons or other open source license.

After you create the repo, then clone it to your local machine.

You may want to use a desktop app like the Github desktop app or GitKraken.  You may also get along just fine with the impressive git tools in VS Code.

### Markdown

Your tutorial should be written in Markdown notation.

Markdown notation is easy, and you will be a guru if you use Reddit or some other platforms.

[Github-style Markdown](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax)

The one thing the tutorials do not emphasize is the use of blank lines between paragraphs.

Generally there should be a blank line before and after each heading, code block, or list as well as paragraphs.

#### Clone and modify your group page in this repo

The librarian should clone the repo [https://github.com/noynaert/csc346handouts](https://github.com/noynaert/csc346handouts).  Then you should modify the "z_group" page in homework 03.  Ideally you should 

* clone the repo
* branch the repo for your group
* edit your "z" page
* commit and push
* make a "pull request"

## The woz.xml file

I am including this repo here just to illustrate including code.  Java code would be indicated by three backticks and the word java.  It is also possible to use a single backtick `like this` for code in a paragraph

```xml
<?xml version="1.0"?>
<credentials>
    <host>woz.cs.missouriwestern.edu</host>
    <port>33006</port> <!--This isn't the right port, by the way -->
    <user>csc</user>
    <password xhint="room where woz is located It definitily is not '!😈湯🦊🚴'">********</password>
</credentials>
```
