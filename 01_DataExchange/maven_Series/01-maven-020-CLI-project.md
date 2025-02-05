# 01-maven-020 CLI Project Creation

Apache's Maven ["Getting Started" Guide](https://maven.apache.org/guides/getting-started/)

## Apache recommendation

The following is Apache's recommended command line for installing Maven.

```
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.5 -DinteractiveMode=false

```

In the above `-D` is a generic flag for each attribute.

## My version

```text
mvn archetype:generate -DgroupId=edu.missouriwester.noynaert -DartifactId=homework00 -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.5 -DinteractiveMode=false
```

## Make the .jar file executable

The Jar file produced by the Maven Package lifecycle is not naturally executable.

To make it executable, add the following plugin to the &lt;plugins> part of `pom.xml`.

You will need to fix the `<mainClass>` tag

```text
        <plugin>
          <!-- Build an executable JAR -->
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-jar-plugin</artifactId>
          <version>3.1.0</version>
          <configuration>
            <archive>
              <manifest>
                <addClasspath>true</addClasspath>
                <classpathPrefix>lib/</classpathPrefix>
                <mainClass>edu.missouriwestern.noynaert.main</mainClass>
              </manifest>
            </archive>
          </configuration>
        </plugin>

```