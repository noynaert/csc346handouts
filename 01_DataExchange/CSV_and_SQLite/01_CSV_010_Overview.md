# CSV

CSV is a file that is convenient for loading into spreadsheets and databases.  

It is a very compact and space-efficient format.  This is because the field names only appear once in the entire file.

Reference: [https://mkyong.com/java/how-to-read-and-parse-csv-file-in-java/](https://mkyong.com/java/how-to-read-and-parse-csv-file-in-java/)

## Forms of CSV

There are different forms of CSV files.  the Mkyong article discusses "classic" csv file format.  But most spreadsheets also treat various "delimited" files.

The delimited files tend to be even smaller because they do not have as many repetitive quote marks. They are also easier to parse in most modern languages because you can split on the delimiter, and there is no need to dispose of the quote marks around strings.

The Mkyong article uses the example of using a delimiter.  It uses the semicolon (;) as a delimiter.  The semicolon has an advantage because it is easily recognized in a text file.  The problem with delimiters like semicolons is that they can sometimes appear naturally in the data.

One solution to the delimiter problem is to use something like the pipe symbol ( | ) which is less common in text.

Perhaps the most useful delimiter is the tab ( '\t' ) character.  This is not embedded in text.  In addition, spreadsheets use the tab to move between columns, and thus tabs usually can't be embedded in text.  Tabs are also a standard ASCII character so they are supported in almost every programming language down to assembly language.