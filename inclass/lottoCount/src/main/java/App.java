import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * todo: PROGRAM DESCRIPTION
 *
 * @author: YOUR NAME
 * @since: MONTH YEAR program is started
 */

public class App {
    public static void main(String[] args){
        String fileName = "No file name picked";
        TreeMap<Integer, Integer> frequency = new TreeMap<>();
        if(args.length > 0) {
            fileName = args[0];
            System.out.println("The file name is " + fileName);
            readFile(fileName, frequency);
        }else{
            System.err.println("You must specify the file name on the command line.");
            System.exit(1);
        }


        System.out.println("\nDone!");
    }

    private static void readFile(String fileName, TreeMap<Integer, Integer> frequency) {
        try {
            Scanner input = new Scanner(new File(fileName));
            String junk = input.nextLine();
            while (input.hasNextLine()){
                String[] fields = input.nextLine().split("\t");
                if(fields.length >=2){
                    String numbers = fields[1];
                    System.out.println(numbers);
                    String[] picks = numbers.split(":");
                    for(int i=0;i< picks.length;i++){
                        System.out.println(picks[i]);

                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
