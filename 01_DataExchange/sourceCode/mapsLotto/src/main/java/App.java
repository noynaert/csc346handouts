import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
/**
 * Reads file name from command line and uses a TreeMap to
 * calculate the number of times each lotto number is picked.
 */

public class App {
    //In the example I am using the local file lotto.tsv
    public static void main(String[] args){
        String fileName = "No file name specified";
        TreeMap<Integer, Integer> frequency;
        if(args.length == 1){
            fileName = args[0];
            frequency = readFile(fileName);
            print(frequency);
        }else{
            System.err.println("No file name specified in args[0]");
            System.exit(1);
        }

        System.out.println("\nDone!");
    }
    public static void print(Map map){
        System.out.printf("\n========There are %d items in the map========\n",map.size());
        for(var key : map.keySet()){
            var value = map.get(key);
            System.out.printf("%s[%s]\t%s\n", key.getClass(), key, value);
        }
    }
    public static TreeMap readFile(String fileName){
        TreeMap<Integer, Integer> frequency = new TreeMap<>();
        Scanner input = null;
        try {
            input = new Scanner(new File(fileName));
            while(input.hasNextLine()){
                String line = input.nextLine();
                String[] fields = line.split("\t");
                if(fields.length > 0){
                    String[] numbers = fields[1].split(":");
                    if(numbers.length == 6){
                        for(int i=0;i<numbers.length;i++) {
                            Integer number = Integer.parseInt(numbers[i]);
                            if(frequency.containsKey(number)) {
                                //Integers are immutable, so I can't just change the value.
                                //It is necessary to get the old value and make a new value;
                                int oldValue = frequency.get(number).intValue();
                                frequency.replace(number,new Integer(oldValue + 1));
                            }else{
                               frequency.put(number, 1);
                            }
                        }
                    }
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return frequency;
    }
}
