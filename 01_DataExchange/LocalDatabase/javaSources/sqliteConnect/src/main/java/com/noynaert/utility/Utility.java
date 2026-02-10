package com.noynaert.utility;

import java.util.ArrayList;

public class Utility {
    public static<T> void printList(String title, ArrayList<T> list){
        for(T t: list){
            System.out.println(t);
        }
        System.out.printf("There are %d items in the list.\n",list.size( ));

    }
}
