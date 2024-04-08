# 02.230 H2 Gui Interface

Code used in demos:

## Delete a table (to start over)

```sql
DROP TABLE IF EXISTS people;
```

## Create a table

```sql
CREATE TABLE people (
    id INT PRIMARY KEY auto_increment, 
    name VARCHAR(255), 
    height float
);
```

##  Insert Records

```sql
INSERT INTO people(name,height) VALUES ('Wilma',180.);
INSERT INTO people(name,height) VALUES ('Barney',140.);
INSERT INTO people(name,height) VALUES ('Fred',150.);
```

## Display Records

```sql
SELECT * FROM People ORDER BY name;
```


