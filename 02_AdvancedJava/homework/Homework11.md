# Homework 11 JavaFX Events

## Resources

- [Link to Videos](https://mwsu.hosted.panopto.com/Panopto/Pages/Sessions/List.aspx?folderID=1b3960d0-0f24-42d9-ab8c-b14500dc7ff6)
- [Link to Source Code](https://github.com/noynaert/csc346handouts/tree/main/02_AdvancedJava/sourceCode/javaFXEventHandlers)
- [Trivia API](https://opentdb.com/api_config.php)

## The problem

Write a JavaFX program that asks the user to select categories and difficulties of trivia questions.  After a question is fetched, the user may click a button to show the correct answer.

The videos show how to use eventHandlers for buttons and text fields.  This problem wants you to use RadioButtons and ChoiceBox.  You will need to use some creativity, research, and figuring it out on your own.

## Layout

Add the following controls to your page

- ChoiceBox  -- This will list categories.  You will need to specify categories.  I suggest the following, but you may use any categories that are in the API.  Use at least 5 categories.
  - General Knowledge(9)
  - Science: Computers (18)
  - Geography (22)
  - Politics (24)
  - Animals (27)
- Radio Button (default to Medium)
  - Easy
  - Medium
  - Hard
- TextArea to show the question
- Label to show the answer (initially empty or invisible)
- Button to display the answer (only available when the Answer is not null)

## What to do

The program should fetch a trivia question whenever the item selected in the ChoiceBox changes.

If the response from the API is 200 through 299, then put the question in the TextArea and activate or show the Answer button.

If the user clicks the answer button, show the answer.

## For overachievers

Ideally, the fetching of the question would happen in a thread, and the display would update after the thread completes.

You could switch to a ComboBox instead of the ChoiceBox.  This would let the user type in their own category.  But you would need to check the response from the API and handle the situation if the user makes a category choice that is not available.

