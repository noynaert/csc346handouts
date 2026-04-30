package com.noynaert.thymeleaf;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class ThymeleafController {
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("spice", "Rosemary");
        String anotherSpice = "Cilantro";
        model.addAttribute("anotherSpice", anotherSpice);
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("source","https://seedsworld.online/cdn/shop/files/red-creeping-thyme-seeds-vibrant-groundcover-or-non-gmo-11081.png?v=1774262278&width=720");
        model.addAttribute("comment","This is some red creaping thyme");
        model.addAttribute("time", LocalDateTime.now());
        model.addAttribute("mascot","duke.png");
        return "about";
    }
}
