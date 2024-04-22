package edu.missouriwestern.noynaert.u03_150_h2.Controllers;

import edu.missouriwestern.noynaert.u03_150_h2.Models.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class HtmlController {
    private final PersonRepository repo;

    @Autowired
    public HtmlController(PersonRepository repo){
        this.repo = repo;
    }
    @GetMapping(path="/")
    public String home(Model model) {
        model.addAttribute("today", LocalDate.now().getDayOfWeek());
        model.addAttribute("month", LocalDate.now().getMonth());
        return "index";
    }
    @GetMapping(path="/people")
    public String getPeople(Model model){
        model.addAttribute("peeps",repo.findAll());
        return "people";
    }

}
