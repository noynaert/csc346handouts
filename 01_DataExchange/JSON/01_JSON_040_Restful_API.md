# 01 JSON 040 Restful APIs

## Multiple meanings for API

* API can mean documentation for a language, such as the Java API
* API can mean the system for accessing data from a website using programming to control HTTP connections

## Restful APIs

Most APIs in current use are "Restful APIs."

Restful APIs use the same HTTP protocol as web pages.

They use the GET method to retrieve data.  They use POST method to submit data that will result in a change on the server.  There are several other methods, such as PUT, DELETE, and PATCH.  We will just use GET for now.

## Constructing a GET request

The parameters are usually key=value pairs.  Note that = is used instead of :.

In some cases, only the key needs to be provided.  

The order of parameters does not usually matter unless there is a conflict.

* The base URL is called an "endpoint."
* The first parameter starts with ?
* Parameters after the first begin with &amp; (ampersand).  
* After the ampersand is a key=value pair.  There is an = sign instead of a colon.

See 

## HTTP Connection

We could just read them like files, but the proper way to fetch the data is with an HTTP Connection.

### Response Codes

[https://en.wikipedia.org/wiki/List_of_HTTP_status_codes](https://en.wikipedia.org/wiki/List_of_HTTP_status_codes)

#### At 100 levels

* 1xx informational response – the request was received, continuing process
* 2xx successful – the request was successfully received, understood, and accepted
  * 200 is almost always the response
* 3xx redirection – further action needs to be taken in order to complete the request
* 4xx client error – the request contains bad syntax or cannot be fulfilled
  * 403 Forbidden 
  * 404 "Not Found" is the most common 400 level code
* 5xx server error – the server failed to fulfil an apparently valid request
  * Most of these are labeled Security Errors


