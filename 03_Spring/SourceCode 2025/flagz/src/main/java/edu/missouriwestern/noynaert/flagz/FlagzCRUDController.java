package edu.missouriwestern.noynaert.flagz;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import static edu.missouriwestern.noynaert.flagz.FlagzApplication.db;

@Controller
public class FlagzCRUDController {
    @GetMapping("/")
    public String index() {
        return "index.html";
    }
    @GetMapping("/about")
    public String about(Model model) {
        //Model model;

        int count = FlagzApplication.db.getSize();
       model.addAttribute("count", count);

        return "about.html";
    }

    @GetMapping("/flag/{id}")
    public String flag(@PathVariable int id, Model model) {
        Flag flag = db.findById(id);
        model.addAttribute("f", flag);
        return "flag.html";
    }
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }


}
