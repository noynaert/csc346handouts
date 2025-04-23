package edu.missouriwestern.noynaert.flagz;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

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

    public Flag findById(int id) {
        Flag flag = db.get(id);
        if (flag == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Flag %d not found",id));
        }
        return flag;
    }

}
