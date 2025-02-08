package edu.missouriwestern.noynaert;

import java.util.ArrayList;

import static edu.missouriwestern.noynaert.utility.Toolkit.printList;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("She sells sea shells down by the sea shore");
        list.add("Peter Piper picked a peck of pickled peppers");
        list.add("Rubber bumpered baby buggies");


        printList(list, "Tongue Twisters");


        System.out.println("Done");
    }
}
