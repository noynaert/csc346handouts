# 00.H02.030 Chaining method calls

Consider this code:

```java
Scanner keyboard = new Scanner(System.in);
        String line;
        System.out.print("Type a string: ");
        line = keyboard.nextLine();
        line = line.trim();
        line = line.toLowerCase();
        line = line.replace("!",".");

        System.out.printf("\"%s\"\n",line);
```
Each of the functions called must be called from a string.  And each returns a string.  Therefore they may be "chained."

```java
      line = Keyboard.nextLine().trim().toLowerCase().replace("!",".");
```