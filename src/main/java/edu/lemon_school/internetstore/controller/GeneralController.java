package edu.lemon_school.internetstore.controller;

import edu.lemon_school.internetstore.dto.CustomerDto;
import edu.lemon_school.internetstore.dto.PaymentDto;
import edu.lemon_school.internetstore.dto.ProductDto;
import edu.lemon_school.internetstore.entity.Customer;
import edu.lemon_school.internetstore.entity.User;
import edu.lemon_school.internetstore.rolesenum.Role;
import edu.lemon_school.internetstore.service.CustomUserDetailsService;
import edu.lemon_school.internetstore.service.InternetStoreService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GeneralController {

    private final InternetStoreService internetStoreService;
    private final CustomUserDetailsService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public GeneralController(InternetStoreService internetStoreService, CustomUserDetailsService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.internetStoreService = internetStoreService;
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping(value = "/registration")
    public String registration(){
        return "/pages/add_user";
    }

    @PostMapping(value = "/registration")
    public String createNewUser(
                        @RequestParam("userName") String userName,
                        @RequestParam("password") String password) {

        User user = User.builder()
                .userName(userName)
                .userPass(bCryptPasswordEncoder.encode(password))
                .userRole(Role.USER.getRoleName())
                .build();
        userService.addNewUser(user);
        return "/";
    }

    @GetMapping(value = "/get_customer_by_name")
    public ModelAndView getCustomerByName(
            @RequestParam("firstName") String firstName,
            @ModelAttribute("model") ModelMap model) {
        List<CustomerDto> customers = internetStoreService.getCustomersByName(firstName);
        model.addAttribute("customersList", customers);
        return new ModelAndView("/pages/all_customers", model);
    }


    @GetMapping(value = "/")
    public String getAllPersons() {
        return "index";
    }

    @GetMapping(value = "/add_payment")
    public String addPayment(@ModelAttribute("model") ModelMap model) {
        List<PaymentDto> paymentList = internetStoreService.paymentList();
        model.addAttribute("paymentList", paymentList);
        return "/pages/add_payment";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/add_customer")
    public String addCustomer(@ModelAttribute("model") ModelMap model) {
        enrichModelAttribute(model);
        return "/pages/add_customer";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/add-new-customer")
    public ModelAndView addNewCustomer(
            @ModelAttribute("model") ModelMap model,
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "lastName") String lastName,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "phoneNumber") String phoneNumber
    ) {
         Customer customer = Customer.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();
        internetStoreService.addNewCustomer(customer);
        enrichModelAttribute(model);
        return new ModelAndView("/pages/add_customer", model);
    }

    @GetMapping(value = "/all_customers")
    public String allCustomers(@ModelAttribute("model") ModelMap model) {
        enrichModelAttribute(model);
        return "/pages/all_customers";
    }

    @GetMapping(value = "/all_products")
    public String getAllProducts(@ModelAttribute("model") ModelMap model) {
        List<ProductDto> products = internetStoreService.productsList();
        model.addAttribute("productList", products);
        return "/pages/all_products";
    }

    @RequestMapping(value = "/endpoints", method = RequestMethod.OPTIONS)
    @ResponseBody
    public String getEndpoints(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/hello/Ihor")
                .append("/all_customers")
                .append("/add_payment")
                .append("/all_products");
        return String.join(", ", stringBuilder);

    }

    @GetMapping(value = {"/hello/{first_name}/{last_name}", "/hello/{first_name}"})
    public ModelAndView greet(
            @PathVariable(value = "first_name") String firstName,
            @PathVariable(value = "last_name", required = false) String lastName,
            @ModelAttribute("model") ModelMap model) {
        model.addAttribute("first_name", firstName);
        model.addAttribute("last_name", lastName);
        return new ModelAndView("/pages/greet", model);
    }

    @PostMapping(value = {"/hello"})
    public ModelAndView greetPost(
            @RequestParam(value = "first_name", required = false) String firstName,
            @RequestParam(value = "last_name", required = false) String lastName,
            @ModelAttribute("model") ModelMap model) {
        model.addAttribute("first_name", firstName);
        model.addAttribute("last_name", lastName);
        return new ModelAndView("/pages/greet", model);
    }

    @GetMapping(value = "/hello")
    public ModelAndView greetRequest(
            @RequestParam(value = "first_name", defaultValue = "") String firstName,
            @RequestParam(value = "last_name", defaultValue = "") String lastName,
            @ModelAttribute("model") ModelMap model) {
        model.addAttribute("first_name", firstName);
        model.addAttribute("last_name", lastName);
        return new ModelAndView("/pages/greet", model);
    }

    private void enrichModelAttribute(@ModelAttribute("model") ModelMap model) {
        List<CustomerDto> customers = internetStoreService.customerList();
        model.addAttribute("customersList", customers);
    }



}
