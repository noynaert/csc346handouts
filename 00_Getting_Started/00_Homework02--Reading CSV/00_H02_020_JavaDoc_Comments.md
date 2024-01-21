# 00.H02.020 JavaDoc Comments

The best way to learn to write JavaDoc-style comments is to spend time reading the official Java API.

## Syntax

JavaDoc comments start with `\**` and end with `*/`

JavaDoc comments may include standard HTML tags.

JavaDoc comments may include "decorations."  Here are a few that we will use:

- @author  -- The professional name of the author
- @since   -- The month and year when the project was started
- @param   -- A parameter to a method
- @returns -- Return value of a method

JavaDoc comments should be placed at two points:

- Before a class
- Before a method

The comments should provide an brief description of the class or method.  They should explain any special conditions.

## Standards for this course

I want people to get used to writing JavaDocs.  But I don't want it to become busywork.

- All classes should have a leading JavaDoc statement.  It should contain
  - A brief description of what the class does
  - @author with the name of the author
  - @since with the start month and year
- Methods that are at all custom should have JavaDoc statements.  @param and @return lines should have a reasonable explanation if it is would be necessary for a programmer to pick up the program and just start reading it.  Meaningful variable names may be sufficient explanation.
  - The main(String[] args) method usually does not need a JavaDoc comment as long as the class description gives an adequate description.
  - Most of the methods in the driver class (the class that contains main(String[] args)) probably needs a JavaDoc comment.
  - Most standard getters and setters do not need JavaDoc comments.  They would only need them if they do something unusual.  This might include:
    - A getter that calculates a value rather than reporting the value of a field
    - Setters that allow alternate formats or do some type of data manipulation.  For example a setter for a string might alter the capitalization into some standardized form.
    - ToString method don't need a JavaDoc unless they do something unexpected.
    - CompareTo, Equals, HashCode, and Comparators do may need an explanation of what they are using for the comparison.  You can probably skip the comment if the compareTo is trivial.

## Generating API documents

We will generate JavaDoc documents once or twice during the semester.  It isn't necessary to do them for every homework.  Just make sure the JavaDoc comments themselves are easy to read.
