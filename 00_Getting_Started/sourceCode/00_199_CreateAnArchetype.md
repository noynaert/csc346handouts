# 00.199 Creating a Maven Archetype

First, make sure you have the file `~/.m2/settings.xml` that contains the following, at a minimum.

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                          https://maven.apache.org/xsd/settings-1.0.0.xsd">
</settings>
```

## quickstart

I started with the apache.maven.quickstart archetype.

## Changes:

- Change the org
- Update the JUnit dependency to the current version
- Add the dependency for Google's guava package.  We may or may not use it this semester.
- Modify the hello world program
- Modify the javadoc comment

I also set up a runtime configuration, but I am not sure that will make it into the archetype.

## Generate the Archetype

Execute the following command from within the project's root folder.

`mvn archetype:create-from-project`

## sources

I used two sources loosely.

- [https://maven.apache.org/guides/mini/guide-creating-archetypes.html](https://maven.apache.org/guides/mini/guide-creating-archetypes.html)
- [https://www.baeldung.com/maven-archetype](https://www.baeldung.com/maven-archetype)

