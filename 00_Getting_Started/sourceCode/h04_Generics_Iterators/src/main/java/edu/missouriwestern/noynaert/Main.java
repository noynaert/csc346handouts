package edu.missouriwestern.noynaert;

import java.time.LocalDate;
import java.util.*;

public class Main {
    private static ArrayList<LocalDate> dateList = new ArrayList<LocalDate>(Arrays.asList(
            LocalDate.now(),
            LocalDate.EPOCH,
            LocalDate.of(2024, 12, 25),
            LocalDate.of(2024,2,14),
            LocalDate.of(2000, 1, 1)));
    private static ArrayList<String> wordList;

    public static void main(String[] args) {
        wordList = new ArrayList<>(Arrays.asList(args));

        printList(wordList,"List of Words");
        printList(dateList,"Random Dates");

        wordList.forEach(w -> System.out.println(w));

        Map<String,LocalDate> holidays = new TreeMap<>();
        holidays.put("Today",LocalDate.now());
        holidays.put("Time Began",LocalDate.EPOCH);
        holidays.put("New Year's Day", LocalDate.of(2025, 1, 1));
        holidays.put("Valentine's Day",LocalDate.of(2024,02,14));
        holidays.put("Independence Day", LocalDate.of(2024, 7, 4));
        holidays.put("Christmas Day", LocalDate.of(2024, 12, 25));
        printMap(holidays);

        var values = new ArrayList<>(holidays.values());
        Collections.sort(values);
        printList(values,"Sorted Dates");


        System.out.println("Done!");
    }

    public static <K,V> void printMap(Map<K,V> map){
        map.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    public static<E> void printList(List<E> list, String message){
        System.out.printf("\n--- %s ---\n",message);
        for (E element : list) {
            System.out.println(element);
        }
        System.out.printf("--- Printed %d items ---\n",list.size());
    }
}
