package edu.missouriwestern.noynaert.flagz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static edu.missouriwestern.noynaert.flagz.FlagzApplication.db;

@RestController
public class FlagzController {

    @GetMapping("/")
    public String index() {
        return """
                <h1>Fun with Flags</h1>
                <p>
                <img src="sheldon.jpg" alt="sheldon" width=200>
                </p>
                """;
    }
    @GetMapping("/about")
    public String about() {
        String s = "Flags are fun!";
        return s;
    }
    @GetMapping("/flags")
    public Iterable<Flag> flags() {
        return db.findAll();
    }
}
