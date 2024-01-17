import edu.missouriwestern.noynaert.people.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> list = null;
        String fileName = "names.txt";
        list = readPeople(fileName);
        Collections.sort(list);
        print(list);
        System.out.println("Done!");
    }

    public static ArrayList<Person> readPeople(String fileName){
        ArrayList<Person> list = new ArrayList<>();
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
            if(person != null && !list.contains(person)) {
               list.add(person);
            }

        }

        input.close();
        return list;
    }
    private static int makeAge(String s){
        int age = -99;
        try {
            age = Integer.parseInt(s);
        }catch(Exception ignored){}
        return age;
    }
    public static void print(ArrayList<Person> list){
        for(Person p: list){
            System.out.println(p);
        }
    }

}
