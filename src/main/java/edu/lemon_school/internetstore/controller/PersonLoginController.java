package edu.lemon_school.internetstore.controller;

import edu.lemon_school.internetstore.entity.Customer;
import edu.lemon_school.internetstore.entity.Product;
import edu.lemon_school.internetstore.service.InternetStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonLoginController {

    private final InternetStoreService internetStoreService;

    public PersonLoginController(InternetStoreService internetStoreService) {
        this.internetStoreService = internetStoreService;
    }


    @PostMapping(value = "/login")
    public String login(@ModelAttribute("model") ModelMap model) {
        List<Customer> customers = new ArrayList<>();
        model.addAttribute("persons", customers);
        return "index";
    }

    @GetMapping(value = "/all_persons")
    public String getAllPersons(@ModelAttribute("model") ModelMap model) {

        List<Customer> customers = internetStoreService.customerList();
        model.addAttribute("customerList", customers);
        return "index";
    }

    @GetMapping(value = "/all_products")
    public String getAllProducts(@ModelAttribute("model") ModelMap model) {

        List<Product> products = internetStoreService.productsList();
        model.addAttribute("productList", products);
        return "products";
    }


}
