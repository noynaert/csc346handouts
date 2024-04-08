# Homework 12, H2 Database

## Resources:

- [Videos](https://mwsu.hosted.panopto.com/Panopto/Pages/Sessions/List.aspx?folderID=3dcd7719-77c9-410c-bf9f-b14c00cb7c37)
- [Code](https://github.com/noynaert/csc346handouts/tree/main/02_AdvancedJava/sourceCode/h2peopleDemo)
- [Notes, 300 series](https://github.com/noynaert/csc346handouts/tree/main/02_AdvancedJava/sourceCode/h2peopleDemo)
  - [SQL Code samples](https://github.com/noynaert/csc346handouts/blob/main/02_AdvancedJava/02_320_H2_Gui_Interface.md)

## Build an H2 database of stock recommendations

Reuse your Stock class from Homework 10.  You will also be reusing your code to read that file into an ArrayList.

Build an H2 database with the four fields from your Stock class.  Also have an ID field that automatically increments.

Thread your program as illustrated in the videos.  You should have two threads

- One thread will create the table in the database
- A second, simultaneous thread will build the ArrayList from the reddit list of stocks.

After both of the threads have completed (joined), insert each of the records from the arraylist into the database.

Verify the database with the web-based interface.

## Second program

Write a second class with a main() method.

This class will just process a SELECT statement from the main method.  It will read the database and return an arraylist of the selected methods.

Use this method to produce a listing of the stocks where the rating is LIKE "Bull%"

