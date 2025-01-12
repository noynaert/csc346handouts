import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)  {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Start!");

        Scanner input = null;
        String fileName = "data.txt";

        //open the file
        try {
            input = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
           System.err.println("File not found");
           System.err.println(e.getMessage());
           System.exit(1);
        }

        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.printf("The new line is: %s%n", line);
        }

        input.close();
        System.out.println("Done");
    }
}