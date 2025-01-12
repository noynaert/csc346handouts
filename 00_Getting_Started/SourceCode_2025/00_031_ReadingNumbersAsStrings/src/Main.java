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