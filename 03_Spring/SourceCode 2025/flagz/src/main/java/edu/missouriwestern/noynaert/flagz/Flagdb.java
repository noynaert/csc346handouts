package edu.missouriwestern.noynaert.flagz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Creates a fake database using a map.
 */
public class Flagdb {
    private Map<Integer,Flag> db = new HashMap<>();

    public Iterable<Flag> findAll(){
        return db.values();
    }
    public void insert(Flag f){
        db.put(f.getId(), f);
    }
}
