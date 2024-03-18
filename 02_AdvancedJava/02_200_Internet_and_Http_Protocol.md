# 02.200 Internet and the HTTP Protocol

## The Internet

The modern internet operates on a Five Layer Model.  The classic version is the TCP/IP stack in the following image.

![Network Models](images/Internetprotocolsecurity.jpeg)

### Packets

Information flows across the Internet in packets.  Packets are blocks of information.  Images and large documents are broken into blocks.  Block sizes can vary, but a typical block size is 1500 bytes.

Packets usually  have two parts.

- Packets contain a header area that contains meta-data about the packet, such as its destination.
- A data area

Think of a packet as an envelope you would send through the mail.  The address, postage, and other processing information is on the outside.  The data area is what goes inside.

If you were sending book through a postal system that only handled letters, you would have to break the book into parts and put the parts in several different envelopes.  

### Protocols

- Protocols are rules about the format and content of packets
- Protocols work within one layer of the model.  

## What is an HTTP Request

- HttpRequests are an Application in the Internet and IPSec models.
- HTTP requests are older than the WWW
- The WWW uses HTTP protocol.
- APIs use the same protocol.

## Moving toward Frameworks

Large data systems work by having a system of related programs serving and consuming APIs.  

Frameworks establish a way to write these systems of programs.  Frameworks may be configured to provide some combination of the following:

- Data as APIs
  - For public use
  - For internal use
- Web interfaces
- Mobile Apps

*Spring* is the most popular framework for Java.  

*Spring Boot* is a package that helps configure a Spring system.

