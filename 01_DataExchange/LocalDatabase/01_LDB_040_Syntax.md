# 01.LDB.040 SQLite3 Syntax

## Data Types
SQLite has a dynamic type system.  This means that you can store any type of data in any column, regardless of the declared type of the column.  However, SQLite does have a set of data types that it recognizes.  These are:
- NULL: The value is a NULL value.
- INTEGER: The value is a signed integer.
- REAL: The value is a floating-point number.
- TEXT: The value is a text string.
- BLOB: The value is a binary large object.

### Comparison with other database types

|SQLite | Common SQL Database Types|
|--- | ---|
|Integer| INT, BIGINT,INTEGER, SMALLINT, TINYINT, BIGINT, BOOLEAN|
|Real| FLOAT, DOUBLE, REAL|
|Text| VARCHAR, CHAR, TEXT|
|Blob| BLOB, BYTEA|

Dates are stored as TEXT, REAL, or INTEGER.  The recommended format for storing dates as TEXT is ISO8601 strings ("YYYY-MM-DD HH:MM:SS.SSS").  The recommended format for storing dates as REAL is the Julian day number.  The recommended format for storing dates as INTEGER is Unix Time (the number of seconds since 1970-01-01 00:00:00 UTC).  

## Create a table

```sql
CREATE TABLE employees (
    employee_id TEXT PRIMARY KEY,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    level INTEGER NOT NULL,
    payrate REAL NOT NULL,
    hire_date TEXT NOT NULL
);
```
## Insert data

```sql
INSERT INTO employees (employee_id, first_name, last_name, level, payrate, hire_date)
VALUES ('0001', 'John', 'Doe', 5, 25.50, '2022-01-15');

INSERT INTO employees (employee_id, first_name, last_name, level, payrate, hire_date)
VALUES ('0002', 'Jane', 'Smith', 6, 27.70, '2020-01-15');

INSERT INTO employees (employee_id, first_name, last_name, level, payrate, hire_date)
VALUES ('0003', 'Bob', 'Johnson', 4, 22.00, '2021-01-15');
```
