package edu.missouriwestern.noynaert.flagz;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/flags")
    public String flags(Model model) {
        Iterable<Flag> flags = db.findAll();
        model.addAttribute("flags", flags);
        model.addAttribute("size", db.getSize());
        return "flags.html";
    }

    //add a flag record
    @GetMapping("/add")  //Displays the form
    public String showAddFlagForm(Model model) {
        model.addAttribute("f", new Flag());
        return "add.html";
    }

    @PostMapping("/add")  //processes the form on return
    public String processAddFlagForm(@ModelAttribute("f") Flag flag) {
        db.insert(flag);
        //return "addSuccess.html";
        return "redirect:/flags#" + flag.getId();
    }


}
