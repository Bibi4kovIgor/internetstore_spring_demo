package edu.lemon_school.internetstore.controller;

import edu.lemon_school.internetstore.entity.Customer;
import edu.lemon_school.internetstore.entity.Product;
import edu.lemon_school.internetstore.service.InternetStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GeneralController {

    @Autowired
    private InternetStoreService internetStoreService;


    @PostMapping(value = "/login")
    public String login(@RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName,
                        @RequestParam("email") String email,
                        @RequestParam("phoneNumber") String phone) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setPhoneNumber(phone);
        internetStoreService.addNewCustomer(customer);
        return "index";
    }

    @PostMapping(value = "/get_customer_by_name")
    public String getCustomerByName(
            @RequestParam("firstName") String firstName,
            @ModelAttribute("model") ModelMap model) {
        List<Customer> customers = internetStoreService.getCustomersByName(firstName);
        model.addAttribute("customersList", customers);
        return "customers";
    }


    @GetMapping(value = "/")
    public String getAllPersons() {
        return "index";
    }

    @GetMapping(value = "/add_payment")
    public String addPayment() {
        return "/pages/add_payment";
    }

    @GetMapping(value = "/add_customer")
    public String addCustomer(@ModelAttribute("model") ModelMap model) {
        enrichModelAttribute(model);
        return "/pages/add_customer";
    }

    @GetMapping(value = "/all_customers")
    public String allCustomers(@ModelAttribute("model") ModelMap model) {
        enrichModelAttribute(model);
        return "/pages/all_customers";
    }

    @GetMapping(value = "/all_products")
    public String getAllProducts(@ModelAttribute("model") ModelMap model) {
        List<Product> products = internetStoreService.productsList();
        model.addAttribute("productList", products);
        return "/pages/all_products";
    }

    private void enrichModelAttribute(@ModelAttribute("model") ModelMap model) {
        List<Customer> customers = internetStoreService.customerList();
        model.addAttribute("customerList", customers);
    }


}
