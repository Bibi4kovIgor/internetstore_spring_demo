package edu.lemon_school.internetstore.controller;

import edu.lemon_school.internetstore.entity.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    public static final String GREETINGS = "Greetings!";

    @GetMapping(value = {"", "/greetings",  "/"})
    public String greet() {
        return GREETINGS;
    }

    @GetMapping("/greet/{name}")
    public Greeting greetingPersonal(@RequestParam(value = "greetingPhrase", defaultValue = GREETINGS)
                                     @PathVariable String greetingPhrase) {
        return new Greeting();
    }

}
