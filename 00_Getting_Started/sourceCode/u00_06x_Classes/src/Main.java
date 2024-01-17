import edu.missouriwestern.noynaert.people.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileName = "names.txt";
        readPeople(fileName);
        System.out.println("Done!");
    }

    public static void readPeople(String fileName){
        Scanner input = null;

        try {
            input = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(46);
        }

        while(input.hasNextLine()){
            String line = input.nextLine();
            String[] fields = line.split(":");
            Person person = null;
            if(fields.length == 2){
                String name = fields[0];
                int age = makeAge(fields[1]);
                person = new Person(name, age);
            }
            if(person != null) {
                System.out.println(person);
            }
        }

        input.close();
    }
    private static int makeAge(String s){
        int age = -99;
        try {
            age = Integer.parseInt(s);
        }catch(Exception ignored){}
        return age;
    }
}
