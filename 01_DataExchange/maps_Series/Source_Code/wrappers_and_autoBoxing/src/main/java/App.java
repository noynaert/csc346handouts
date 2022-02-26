import java.util.ArrayList;

/**
 * Illustrates wrapper classes and autoboxing
 */

public class App {
    public static void main(String[] args){

        String s = "123";
        int i = Integer.parseInt(s);
        System.out.println(Integer.MAX_VALUE);

        i = new Integer(7);
        //wrapper class

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(new Integer(8));

        Integer iii = new Integer(8);
        iii++;
        //autoboxing



        System.out.println("\nDone!");
    }
}
