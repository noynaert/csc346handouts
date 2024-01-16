# 00.061 Packages and the Namespace Problem

> There are only two hard things in Computer Science: cache invalidation and naming things.  -- Phil Karlton

It doesn't seem like "naming things" should be hard.  But it is.  The problem is creating names that are unique.  Package creators should not have to worry about "stepping on" or reusing a name used by another developer.

### Variations on "Two Hard Things."

- There are 2 hard problems in computer science: cache invalidation, naming things, and off-by-1 errors.
- There are only two hard problems in distributed systems: 
  - 2. Exactly-once delivery 
  - 1. Guaranteed order of messages 
  - 2. Exactly-once delivery

## The Domain Name System

Java resolved the namespace problem by using the Internet's Domain Name System (DNS).  Domain names must be unique.  There is a worldwide system that is committed to making sure that domain names are unique.

Sample domain names include:

- google.com
- missouriwestern.edu
- noynaert.com

The Java standard says that package names must start with the domain name "backwards."  So google.com would become a package starting with com.google.  It is up to the owner of the domain name to set up subdomains.  They may or may not correspond to real urls.  

## In this course

In this course you have two options for naming packages.  You may use either missouriwestern.edu, or you may use a domain name you own.

- If you use missouri western, the third field should be your login id.  That insures it is unique to you.  After your name, you may use any system you like.
  - edu.missouriwestern.noynaert.csc346
  - edu.missouriwestern.jfuller6
- If you own your own domain, you may set up your own system.
  - com.noynaert.csc346