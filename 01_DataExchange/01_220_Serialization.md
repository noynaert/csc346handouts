# 01.220 Serialization

## History

- Java originally envisioned "serializing" objects by converting them into character streams that could be exchanged between Java programs.
- Java creators assumed that other languages would all disappear because of Java's awesomeness
  - They were wrong
- The `Serializable` interface used to mean specific methods were implemented to read and write streams
- Most serialization is now done with JSON, XML, or YAML.

## Serialize

To "serialize" means to take a POJO or Java Bean and make it into a stream, which may be JSON.

## Deserialize

To "deserialize" means to convert a JSON or other serial sequence into a POJO or Java Bean

This is also called "parsing."
