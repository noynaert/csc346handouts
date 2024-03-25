# Homework 09 APIs with HttpClient, Threads, Stopwatch

## Resources

- [The videos](https://mwsu.hosted.panopto.com/Panopto/Pages/Sessions/List.aspx?folderID=42795fb2-e9fa-42d9-863a-b13e007d4c2e)
- [Sample source code and notes](https://github.com/noynaert/csc346handouts/tree/main/02_AdvancedJava)
  - The notes relevant to this unit are in the 02_2xx series.

## The Assignment

In this assignment, you will pick APIs that return JSON responses.  For each of the sites, begin by asking the user for any fields that require user input.  Store the key: value pairs in a separate map.

Then, after you have all the input, do the following for each of the APIs you use.

Make each of the calls in its own thread.  All of the searches should be going on simultaneously.
Each of the HttpClient calls should print out the elapsed time the call took.
Each of the HttpClient calls should print the status code
Send the Json that is returned to a file.  Because you already have JSON code, you should just be able to write the files with PrintWriter.

Pick at least 5 apis from this list.  At least one must use an API key.

Title|URLs|Notes
:---:|:---|:---

- Art
  - Documentation [https://api.artic.edu/docs/#introduction](https://api.artic.edu/docs/#introduction)
  - Sample [https://api.artic.edu/api/v1/artworks/search?q=cats](https://api.artic.edu/api/v1/artworks/search?q=cats)
  - Ask the user to type a topic to search
    - Be sure to test with subjects that contain blanks and special characters such as an apostrophe.
- Cat Facts
  - The API information is [https://catfact.ninja/](https://catfact.ninja/)
    - Click on "Facts' and "Get a list of facts"
  - Ask the user to type the number of cat facts they want.  Use the user's input to specify the LIMIT field.
- Shibes (but we are going to do cats, because that seemst to be the emerging theme)
  - The API documentation is at [https://shibe.online/](https://shibe.online/).  If you read the documentation, you may change "shibe" to "cat" or "bird."  Change it to cat.
  - Ask the user how many pictures they want.
- Trivia
  - The documentation is at [https://opentdb.com/api_config.php](https://opentdb.com/api_config.php)
  - Ask the user for the following information.
    - count
    - category (suggest some like "Geography" and "Entertainment Film"). Include "Science & Nature" as one of the topics.  Be sure to encode it!
    - Ask them to specify Easy, Medium, or Hard difficulty.
  - I have not tried this one.  I substituted it for another one I intended to use.  Figure it out as best you can.  Incomplete documentation is a fact of life.
- NASA
  - The documentation is at [https://api.nasa.gov/](https://api.nasa.gov/)
  - You will need to apply for an api key.  It should show up in your email.
  - Browse the APIs and find APOD.
  - Ask the user for the start date, end date and the API key.  (paste in the key)
- Optional -- You may substitute this for any of the top 4 above.  I am requiring the APOD for everyone.
  - Use any of the other NASA APIs that you find interesting.  You may also use any of the APIs at [https://data.gov/](https://data.gov/)  The same API key should work for both sites if the one you pick requires an API.