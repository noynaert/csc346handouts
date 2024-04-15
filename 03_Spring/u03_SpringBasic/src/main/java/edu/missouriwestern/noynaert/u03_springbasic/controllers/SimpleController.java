package edu.missouriwestern.noynaert.u03_springbasic.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class SimpleController {
    @RequestMapping(path="/")
    public String root() {
        return """
                <h1>Greetings, Earthling</h1>
                
                <p>Have a nice day.</p>
                
                <p><em><strong>Order pizza.</strong><em></p>
                """;
    }

    @RequestMapping(path = "/today")
    public String today(){
        LocalDate now = LocalDate.now();
        String message = String.format( "<h1>Today is %s</h1>",now.getDayOfWeek());
        return message;
    }

    @RequestMapping(path="/catfact")
    public String catFact() {
        return """
                {
                fact: "When a cat chases its prey, it keeps its head level. Dogs and humans bob their heads up and down.",
                length: 97
                }
                """;
    }
}
