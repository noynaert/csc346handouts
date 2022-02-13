# Installing the credentials jar

One option is to load the credentials jar file into your local repository.

Here is the command I used on my system.  This uses the default pom file by default.  I am not sure what will happen if you don't have the pom file.

```bash
mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file -Dfile=./credentials-0.1.jar
```

See [https://maven.apache.org/guides/mini/guide-3rd-party-jars-local.html](https://maven.apache.org/guides/mini/guide-3rd-party-jars-local.html) for detailed instructions.

See also [https://roufid.com/3-ways-to-add-local-jar-to-maven-project/](https://roufid.com/3-ways-to-add-local-jar-to-maven-project/)

```xml
   <dependency>
            <groupId>com.noynaert</groupId>
            <artifactId>credentials</artifactId>
            <version>0.1</version>
    </dependency>
```

