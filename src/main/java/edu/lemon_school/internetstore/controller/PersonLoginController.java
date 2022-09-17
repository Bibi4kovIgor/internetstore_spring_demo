package edu.lemon_school.internetstore.controller;

import edu.lemon_school.internetstore.entity.Person;
import edu.lemon_school.internetstore.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonLoginController {

    @Autowired
    private PersonService personService;

    @PostMapping(value = "/login")
    public String login(@ModelAttribute("model") ModelMap model) {
        List<Person> persons = new ArrayList<>();
        model.addAttribute("persons", persons);
        return "index";
    }

    @GetMapping(value = "/all_persons")
    public String getAllPersons(@ModelAttribute("model") ModelMap model) {

        List<Person> persons = personService.personList();
        model.addAttribute("personList", persons);
        return "index";
    }


}
