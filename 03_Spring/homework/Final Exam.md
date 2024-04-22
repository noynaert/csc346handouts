# Final Exam

## CSC 346, Spring 2024

The final exam is Wednesday, May 1 at 10:30 a.m. – 12:30 p.m.

During the exam we will review projects.  Everyone should be prepared to show what they have done.  If circumstances permit, I will allow a follow-up meeting to cover the final project.

## The Assignment

* Possible high score of 110 out of 100.  
* Spring Boot project with H2 and Thymeleaf
* Uses the H2 database from Homework 12 (which uses the data from Homework 9)
* Your program does not need to load the database from live data; it may treat the data as if it is static.

### Scoring 
* Maximum 60 points: (Get Spring to compile and show the root) 
  * The Spring Boot loads and displays the / route with some text displayed.
* Maximum 70 points: (Show that the controller is working)
  * The H2 database does not need to load
  * The program returns the / route with some text displayed
  * The program returns at least one other route that lists some information.
  * The program returns a route that such as /stock/{number}.  The page should print the the number from the route
* Maximum 80 points: (get the H2 database working with some routes)
  * The program should compile and have a / (root) path that lists the implemented other options.  I recommend displaying it in the form of an unordered list.  At the 70 point level this would be brute force returning the list of paths.  The root page should also include the size of the ArrayList should be printed on this page.
  * The program should have a /allStockJson route that returns the entire list of stocks as Json.
* Maximum 90 points:
  * The project should have a /oneJson/{number} that accepts a number that returns the json for the one stock that corresponds to the requested number in the array.  Don't worry about asking the value outside the side of the array.
* Maximum 100 points:
  * The project should should replace the / path with a templated page.  Send the array size as a part of the model in the same way I passed the name of the weekday in the video.
  * The project should have a path to /allStock that returns a formatted table that shows the entire list of stocks as an HTML table
  * The project should have a path to /one/{number}, but it does not have to query the page.  It is OK if the number is just sent to the console.
  * Maximum 110 points:
    * Do 100 points, but get a custom query on /one/{number} to print just that one stock.  Output the results on a templated html page

Upload your code to the final exam.  We will do a code review in class on the assigned final exam date.  If you can catch me, I will do the code review early.  

On the final exam date, I will give you a grade based on your exam status at that point.  If possible, I will review your progress after exam date, I will do a second review and give you the extra points.

I am planning on having an optional study session on Monday of Final Exam week.  If you are there with a working project in any form I will give you a preliminary final exam grade at that time.