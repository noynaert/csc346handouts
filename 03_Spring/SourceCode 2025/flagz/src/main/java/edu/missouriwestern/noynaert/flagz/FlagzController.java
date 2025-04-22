package edu.missouriwestern.noynaert.flagz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return "Flags are fun!";
    }
}
