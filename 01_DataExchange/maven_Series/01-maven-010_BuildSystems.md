# 01.maven.010 Build Systems

## Make

Make is a system that goes back to the 1970s and C.  C programs could have dozens of files, and the make system kept track of what needed to be compiled and linked.

Make can handle external compiled packages, but it lacks features we need such as maintaining local repositories.

Configuration could be very tricky because the configuration was handled by options in make syntax.  There could be some very subtle side effects that would mess things up.

## Java

### IDE dependent managers

Most IDEs have some built-in system that simulates make and adds some modern features.  That is what we use in most Java courses up until now.

### Maven

* Maven is the most popular project manager for Java projects.
* Maven is essentially a command-line tool that is integrated into the IDE.
* Maven projects can be loaded into different IDEs and it still works.
* Configuration is managed in XML
  * XML is related to HTML.  
    * Both work based on pairs of tags and attributes.
    * HTML specifies the tags in advance, but XML allows projects to define their own tags.
    * XML has mechanisms for validating the file.
  * The file name is `pom.xml`  
  * In some ways, the pom.xml file is the project
* Maven builds a local repository on the local machine.
  * The repository is in a folder named `.m2` in the user's home directory.  The first time you run a Maven program can be slow.
  * There are multiple ways to create a Maven project
    * Archetype
    * Command Line
    * Open an existing project

### Gradle

* Gradle is newer than Maven
* Gradle's main use is in Android development
* Gradle configuration is JSON based, not XML based.