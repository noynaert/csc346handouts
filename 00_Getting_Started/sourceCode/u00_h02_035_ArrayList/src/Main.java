import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileName = "jabber.txt";
        ArrayList<String> list;

        list = readWords(fileName);
        Collections.sort(list);
        printList(list,fileName);

        System.out.println("Done!");
    }

    private static void printList(ArrayList<String> list, String fileName) {
        System.out.printf("\n---List of Words from file %s---\n", fileName);
        for(String s : list){
            System.out.println(s);
        }
        System.out.printf("\n---Printed %d words---\n",list.size());
    }

    public static ArrayList<String> readWords(String fileName){
        ArrayList<String> list = new ArrayList<>();
        Scanner input = null;

        try {
            input = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
           System.err.println(e.getMessage());
           System.exit(46);
        }
        while(input.hasNextLine()){
            String line = input.nextLine().trim().toLowerCase();
            String[] parts = line.split("[^a-z\']");
            for(int i=0;i<parts.length;i++){
                String word = parts[i];
                if(word.length() > 0){
                    if(list.contains(word)){
                       System.out.println(word + " is already on the list");
                    }else{
                        list.add(word);
                    }
                }
            }
        }
        input.close();
        return list;
    }

}
