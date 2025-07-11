package edu.missouriwestern.noynaert.flagz;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static edu.missouriwestern.noynaert.flagz.FlagzApplication.db;

@RestController
public class FlagzRESTController {


    //@GetMapping({"/flags/json","/flags"})
    @GetMapping("/flags/json")
    public Iterable<Flag> flags() {
        return db.findAll();
    }
    @GetMapping("/flag/{id}/json")
    public Flag flag(@PathVariable int id) {
        Flag flag = db.findById(id);
        return flag;
    }
    @GetMapping("/del{id}/json")
    public void delete(@PathVariable int id) {
        db.deleteById(id);
    }
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
