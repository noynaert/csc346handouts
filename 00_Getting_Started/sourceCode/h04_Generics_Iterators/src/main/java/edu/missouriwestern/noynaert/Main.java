package edu.missouriwestern.noynaert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

/** Illustrates generics and Lambda and Iterators expressions
 *
 */


public class Main {
    private static LocalDate[] tempList = {LocalDate.now(),
            LocalDate.EPOCH,
            LocalDate.of(2024,2,14),
            LocalDate.of(2024,12,25),
            LocalDate.of(2025,1,1),
            LocalDate.of(2024,7,4)
    };


    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>((Arrays.asList(args)));
        ArrayList<LocalDate> holidays = new ArrayList<>(Arrays.asList(tempList));

        printList(words, "List of Words");
        printList(holidays,"Some Dates");
System.out.println("=================");
        holidays.forEach( (holiday) -> {System.out.print("Holiday: ");System.out.println(holiday);});
        words.forEach(word -> System.out.println(word));

        System.out.println("Done");
    }

//    public static void printList(ArrayList<String> words,String message){
//        System.out.printf("\n--- %s ---\n",message);
//        for(String word : words){
//            System.out.println(word);
//        }
//    }
    public static<E> void quickiePrint(ArrayList<E> list){
        System.out.print("Item: ");
        list.forEach(e ->System.out.println(e));
    }
    public static<E>  void printList(ArrayList<E> list, String message){
                System.out.printf("\n--- %s ---\n",message);
                for(E e : list){
                    System.out.println(e);
                }
    }
}
