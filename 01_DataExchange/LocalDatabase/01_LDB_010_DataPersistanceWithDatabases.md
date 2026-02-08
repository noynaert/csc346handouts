# 01.LBD.010 Data Persistence with Databases

## What you need to know about Databases for this course

I do not expect people to be experts in databases.  However, some basic knowledge is necessary.  You should understand the following:

- Terminology
  - Database 
  - Table
  - Row
  - Column 
  - Primary Key
  - Foreign Key
- Basic SELECT statements 
    -Basic WHERE clauses
    -Basic ORDER BY clauses
- Basic CREATE TABLE statements
- Basic INSERT statements

Depending on your project, you may need to do some simple joins.

## Types of Databases

Almost any serious application needs to store data persistently.  While there are many ways to do this, databases are the most common solution.  Databases provide a structured way to store, retrieve, and manipulate data.  They also provide features for data integrity, security, and concurrency control.

Flat files can be simple. However, many times we need to pull data selectively from a large data set.  Databases provide powerful query languages, such as SQL, that allow us to retrieve specific data quickly and efficiently.

Sometimes only small amounts of data is needed, but those may be stored in databases as well.

There can also be security issues.  In something like an mobile phone app, a program may be authorized to access only certain data.  Databases provide mechanisms for controlling access to data based on user roles and permissions.

## Local vs. Remote Databases

Databases can be classified into two main categories: local databases and remote databases.  Remote databases are hosted on a server and accessed over a network.  Local databases are stored on the same machine as the application that uses them.

Local databases are sometimes known as embedded databases or in-memory databases.  They are designed to be used by a single application and do not require a separate server process.  They are often used in mobile apps, desktop applications, and small web applications.

## SQL vs. NoSQL Databases

Databases can also be classified based on their data models.  The two main types are SQL (relational) databases and NoSQL (non-relational) databases.

SQL databases use a structured schema to define tables, columns, and relationships between data.  They use SQL as the query language.  Examples of SQL databases include MySQL, PostgreSQL, and Oracle Database.

NoSQL databases use a flexible schema to store data in various formats, such as key-value pairs, documents, graphs, or columns.  They do not use SQL as the query language.  Examples of NoSQL databases include MongoDB, Cassandra, and Redis.

At this point in the course we will focus on SQL databases. 