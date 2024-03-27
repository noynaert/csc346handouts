# Homework 10 -- Reddit Stock Recommendations

The website [https://tradestie.com/api/v1/apps/reddit](https://tradestie.com/api/v1/apps/reddit) has stock picks recommended on a particular sub on Reddit.

## The Stock POJO / JavaBean

Implement the Stock with a default constructor.  A full constructor is not needed unless you want it for testing purposes.

Create a POJO for one stock.  One stock has 4 fields

- Number of comments:integer
- Sentiment:string
- Sentiment Score:double
- Stock Symbol:string

Create a toString method.  Something like the following might work.

```java
    String.format("%-5s %7.3f (%3d comments, %s), symbol, score, comments, sentiment)
```

Implement the Serializable Interface with `toJson()` and `fromJson` methods

Implement the Comparable Interface.  The comparison should be done on the Sentiment Score (the Double field)

## The Main class

Fetch the json file with HttpClient.  Read the entire file into an ArrayList<Stock>.  Use the toJson and fromJson methods in the Java Bean.  ***Do not send the ArrayList into the Stock class.***  The main class should ***use*** the Serialized feature of the POJO.

Sort the ArrayList using the Collections.sort() method.

## Output

There should be two different outputs from the program after the data is read in and sorted:

- Print the contents of the array with a `for` statement using the toString() method of the POJO
- create a stocks.json file containing the entire ArrayList represented as JSON.

## Resources

- [The source Code](https://github.com/noynaert/csc346handouts/tree/main/02_AdvancedJava/sourceCode/SerialIzeJsonReprise)
- [Videos](https://mwsu.hosted.panopto.com/Panopto/Pages/Sessions/List.aspx?folderID=f86256e3-c55e-4aa0-9679-b140003e7aeb)
- [https://tradestie.com/api/v1/apps/reddit](https://tradestie.com/api/v1/apps/reddit)
