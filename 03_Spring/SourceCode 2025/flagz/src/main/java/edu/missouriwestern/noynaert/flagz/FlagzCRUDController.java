package edu.missouriwestern.noynaert.flagz;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
