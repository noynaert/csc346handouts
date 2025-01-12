# 00.031 Checked vs Unchecked Exceptions

## Checked Exceptions

Checked exceptions must be caught or thrown.

## Unchecked Exceptions

Unchecked exceptions do not have to be caught or thrown.

### Unchecked Example -- converting strings to numeric types

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String textString;
        int number;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Type an integer: ");
        textString = keyboard.next();
        System.out.printf("You typed \"%s\"\n", textString);

        try {
            number = Integer.parseInt(textString);
            System.out.printf("The number is %d\n", number);
        }catch(NumberFormatException e){
            System.out.println("Oops, that isn't an integer");
        }

        System.out.println("\nDone!");

    }
}
```