import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        readStringFromKeyboard();

        System.out.println("Done!");
    }

    /**
     * <h2>Demonstrates chaining methods </h2>
     *
     * This method reads from the keyboard.  It then modifies the string as follows:
     *    <ul>
     *        <li>The String is trimmed</li>
     *        <li>The String is converted to lower case</li>
     *        <li>All exclamation points are changed to periods</li>
     *    </ul>
     *
     * Because this is a demonstration, it prints lines to show progress.
     *
     * @return  Returns the String the user typed after it is trimmed and converted to lower case.
     *
     */
    public static String readStringFromKeyboard(){
        String s = "";
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Type a string:  ");
        s = keyboard.nextLine();
        System.out.printf("\"%s\"\n", s);

        return s;
    }
}
