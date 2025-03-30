# 01 CSV and SQLite -- Reading a CSV File without Java Beans

This page describes two ways to read a CSV file without using POJOs or Java Beans.

# Method 1 -- Read each record into a Map.

The firsts method converts each record in the file into a map.  The map uses the column headers.  If there are no column headers, the same type of thing may be done with positions.

This method is handy because it is easy to make a List of the Maps that each line generates.

```java
    public static void readLines(String fileName,ArrayList<Map<String, String>> people) {
        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader(fileName));
            CSVParser parser = new CSVParserBuilder().withSeparator(',')
                    .withSeparator(':')
                    .withQuoteChar('"')
                    //.withIgnoreQuotations(true)
                    .build();
            CSVReaderHeaderAware csvReader = new CSVReaderHeaderAware(reader);
            Map<String, String> record;
            while ((record = csvReader.readMap()) != null) {
                //System.out.println(record);
                String name = record.get(" Full Name");
                String birthday = record.get("Birthday (Gregorian Calendar)");
                int id = Integer.parseInt(record.get("id"));
                people.add(record);
                System.out.printf("%s was born on %s and has an id of %d\n", name, birthday, id);
            }
            reader.close();
            System.out.println("Almost Done!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
```

## Method 2 Picking the field by position

This method converts each record into an array of String[] types.  It is simple and useful if the columns do not have headers.  However, it is harder to make this into a List.  It is possible to have a List<String[]> datatype, but it is often not as handy for later processing in a different method.  But it is very quick.

```java
public static void readAsArrayOfStrings(String fileName) {
        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader(fileName));
            CSVParser parser = new CSVParserBuilder().withSeparator(',')
                    .withSeparator(':')
                    .withQuoteChar('"')
                    //.withIgnoreQuotations(true)
                    .build();
            CSVReaderHeaderAware csvReader = new CSVReaderHeaderAware(reader);
            List<String[]> list = csvReader.readAll();

            for (String[] record : list) {
                String person = record[0];
                String birthday = record[1];
                int id = Integer.parseInt(record[2]);
                System.out.printf("%s was born on %s and has an id of %d\n", person, birthday, id);
            }

            reader.close();
            System.out.println("Almost Done!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
```


