package edu.missouriwestern.noynaert.u03_150_h2.Controllers;

import edu.missouriwestern.noynaert.u03_150_h2.Models.PersonModel;
import edu.missouriwestern.noynaert.u03_150_h2.Models.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JsonController {
    private final PersonRepository repo;

    @Autowired
    public JsonController(PersonRepository repo){
        this.repo = repo;
    }

//    @GetMapping("/")
//    public String getJson() {
//        return "I am Root";
//    }

    @GetMapping(path="/peopleJSON")
    public List<PersonModel> getAllPeople(){
        return repo.findAll();
    }


}
