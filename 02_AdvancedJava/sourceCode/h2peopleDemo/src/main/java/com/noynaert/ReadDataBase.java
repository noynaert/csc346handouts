package com.noynaert;

import java.util.ArrayList;

public class ReadDataBase {
    public static void main(String[] args){

        ArrayList list;
        H2personDB personDB = new H2personDB();
        String sqlString = "SELECT name, height FROM people WHERE name LIKE 'Mu%'";
        list = personDB.getList(sqlString);
        printList(list);

        System.out.println("Done with reading the arrayList");
    }

    public static void printList(ArrayList list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
