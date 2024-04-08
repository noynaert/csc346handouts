package com.noynaert;

import com.noynaert.people.PeopleList;
import com.noynaert.people.Person;

import java.util.ArrayList;

/**
 * <p>This method builds an H2 database of Person records
 * from a CSV file.</p>
 *
 * <p>
 *  There are three main parts
 * </p>
 * <ul>
 *     <li>Create the H2 database called and a table called people (run as a thread)</li>
 *     <li>Read the CSV file into an ArrayList (run as a thread)</li>
 *     <li>After the file has been created and the ArrayList are ready, insert each of the records into a database.</li>
 * </ul>
 *
 * @author J. Evan Noynaert
 * @since April 2024
 */


public class Main {
    public static void main(String[] args) {
        //Create the objects that will be the threads
        H2personDB theDatabase = new H2personDB();
        PeopleList theList = new PeopleList("people.csv");

        //Create the Threads
        Thread createTableThread = new Thread(theDatabase);
        Thread readListThread = new Thread(theList);

        //Start the Threads
        createTableThread.start();
        readListThread.start();

        //Hang out, waiting for the threads to finish up.
        System.out.println("Waiting for the threads");

        //Join the threads
        try {
            createTableThread.join();
            readListThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Back together");

        ArrayList<Person> people = theList.getList();
        theDatabase.insertRecords(people);

        theDatabase.close();

        System.out.println("Done!");
    }
}
