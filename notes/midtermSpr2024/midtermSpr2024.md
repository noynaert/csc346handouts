# Midterm Exam
## Spring 2024

### Rules

- Each person is expected to work independently.
- You may use the Internet, but I expect problems to be done in the same general way I have demonstrated in class.
- Complete each part separately. 
	- For each section, zip your code and submit it in Canvas
	- For each section, make a video where you show that you go through each of the tasks listed for that part.
- There are three parts to the exam

| Part | Points | Description      |
| :--: | :----: | ---------------- |
|  1   |   45   | Database and CSV |
|  2   |   45   | JSON             |
|  3   |   10   | Challenge        |

## Part 1, Database and CSV

### Tasks

- Use proper style in your project (5 points)
	- You may either use Maven, or include the libraries for sql and openCSV as .lib files  Be consistent and do both libraries in the same way.
	- The Person and Postal Code classes should be in a package that is different than the package with your main() method
	- Write a JavaDoc comment for main (the following steps require JavaDoc for the classes as well)
	- Use proper naming and capitalization conventions for Java program style
	- Generate a JavaDoc for the package containing the Person and Postal Codes.
- Create a Java Bean for a person (10 points)
	- The Java Bean should be in its own file
	-  The bean should contain the following fields
		- First name: String
		- Last name: String
		- City: String
		- State: String
		- Postal Code: String
		- Latitude: double
		- Longitude: double
	- Implement the Comparable<T> interface based on the last name.  The first name should be used to break the tie.
	- Include a toString() method that uses String.format.
	- Generate the equals() and hashCode() methods based on the last name and first name matching.  Ignore the other fields.
	- Include JavaDoc comments for the class and at least one method
- Connect tot he misc database on woz.csmp.missouriwestern.edu (10 points)
	- Use the fakePeople table.  Select all of the records that have the last_name like 'Kays%'
	- Store the names returned by the selection in an ArrayList of the bean you created in the previous task.  You will not be able to get the latitude and longitude from the fake people database.
	- Sort the ArrayList into order using the built-in Collections.sort() method.  Print this list to the console.  (The latitude and longitude will be 0 at this point.)
- Use the Apache Commons CSV package to process the postal_code.csv file distributed with the exam.  (10 points)
	- Create a class that includes the postal code, latitude, and longitude.  Document the class with an appropriate JavaDoc.
	- Create an ArrayList of the records.  Generate the equals() and hashCode() methods.  They should be based only on the postal code.
- Step through the ArrayList of people who have names like 'Kays%.'  Use the Zip code data to fill in the latitude and longitude for each person if the data is available.  (10 points)
	- If there is no matching zip code, then leave the latitude and longitude zero or undefined.
	- In the main class (not in the Person or Postal Code class), make create a Comparator that compares the longitude. for items in the Person class.  Effectively this means that eastern longitudes are less than western longitudes
	- Use the comparator to sort the array of people who have names like 'Kays%' so they are ordered by longitude from east to west.
	- Create a .csv file of People.  The records should be ordered from east to west based on the person's longitude.

## Part 2 JSON

### Tasks

- Use the website https://api.gameofthronesquotes.xyz/v1/random
- Create a package named gameOfThrones.  The package should have two classes.
	- Entry: has fields for
		- name:String
		- slug:String
	- Quote has fields for
		- sentence:String
		- character:Entry
		- House:Entry
- Two Sentences are equal() and have the same hashCode() if the sentence is the same.
- Quotes should implement Comparable&lt;Quote&gt; based on the slug of the character.
- The Quotes class should implement the Serializable interface
	- The class should implement the Serializable interface by providing toJson and fromJson methods.
	- The Quote class should use pretty printing for its output.
- The program should read 5 quotes and store the 5 quotes in an Array or an ArrayList (your choice)
	- After fetching each quote, make sure it is not a duplicate of another quote with the same sentence.  If you get a duplicate, fetch an extra quote in its place.
	- Sort the list into order by character name.
	- Use the for each type of for loop to print the list to the console.
	- Write the list of 5 quotes to a JSON file named quotes.json

## Part 3

As an upper level course, an A in CSC 346 should indicate an ability to go beyond what is taught in class.  You should be able to apply principles we have learned to new situations.

We have only been using Jackson to process JSON data.  However, it can also process XML and YAML formats.  Pick one of the sites below and process it in its XML or YAML form.  You may do these as maps or you may create objects.

- [https://api.worldbank.org/v2/region?format=xml](https://api.worldbank.org/v2/region?format=xml)
	- There is a list of countries.  Each country has a standard 3-letter abbreviation, a standard 2-letter abbreviation, and the name of the country.   Your program should put the list into an array list.  Sort the list by the 2-letter abbreviation.  
	- Print the list to the console, showing it sorted by 2-letter code