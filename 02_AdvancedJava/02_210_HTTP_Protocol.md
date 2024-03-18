# 02.210 HTTP Requests

The HTTP operation has two general phases

- HTTP Request goes from the client to the server.  Putting a URL in the address bar and hitting the Enter key would trigger an HTTP request.
- HTTP Response is what the server sends back to the client (usually a browser)

### Side note: URL and URI

- ***URI*** identifies a resources.  A URI is an ID.  
- ***URL*** is an address.  It is the address of the server.

In most cases we can use a URL as a URI.  In effect, the URL contains the URI.  On the server, the address will be ignored or stripped off.

Some of the Java methods do make a distinction.  

## The Request part

An HTTP request is a string of characters.  It consists of the following:

- A Request line
- Zero or more header fields followed by Carriage Return and Line Feed characters (CRLF)
- An empty line (nothing in it, but a CRLF)
- An optional message body

### Request Methods

- **GET** -- The GET method retrieves information from the server.  GET methods should only retrieve information; GET methods should not change data on the server.
- **POST** -- Sends data to the server, usually to be saved.  Think of posting a record.
- **PUT** -- Replaces all the current representations of the target resource with uploaded content.  
- **DELETE** -- Removes all the current representations of the target resource given by the URI.
- Some others we won't be too worried about
  - Head -- Similar to a GET, but it only transfers the status line and header
  - Connect -- Establishes a "tunnel" to the server
  - Options -- Describes the communication options for the target resource
  - Trace -- Performs a message loopback test

## HTTP Response Codes

When the server responds, it sends back a "Response Code."

[Full list of responses and their meanings](https://loadium.com/blog/the-list-of-http-response-status-codes?gad_source=1&gclid=Cj0KCQjwqdqvBhCPARIsANrmZhPlGk49gIIkMITGAMqwHLcg4SJAOkU4QpkcZNsIdJdTlyKDlI7F-psaAqytEALw_wcB)

The codes are in groups of 100

Series|Meaning|Comments
:---:|:---|:---
100|Informational Responses|&nbsp;
200|Success| 200 is often "OK"
300|Redirection Message|&nbsp;
400|Client Error Response|Generally a client problem.  Security is part of the 400 series
500|Server Error|Generally a server problem.  Security is part of the 500 series
