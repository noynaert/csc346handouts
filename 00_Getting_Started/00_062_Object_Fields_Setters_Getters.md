# POJO Fields, Setters, Getters

## Give thought to the access restrictions on the fields

- `private` -- Only methods in this object have access
- `public`  -- All objects have access
- `protected`
  - subclasses have access
  - other methods in the same package have access
- default -- This is also called "package protected."  Only objects in the same package have access.  I suggest that if you declare a field as the default, then not //package protected as a comment.

## Setters vs Getters
- Setters -- At a minimum, there should be one setter with the default type of the argument
  - Setters have `void` return types
  - Setters take an argument
- Getters -- There may only be one no-arg getter
  - Getters always return the data type of the field
  - Getters do not have an argument
  - Getters are often done on a single line

## Use the "this" convention for setters

### bad style
   
```java
public void setName(String x_name){
    name = x_name;
}
```

### Good Style

```java
public void setName(String name){
    this.name = name;
}
```

## Getters

Both formats are OK

```java
public String getName(){
    return name;
}

public int getAge(){ return age; }
```
