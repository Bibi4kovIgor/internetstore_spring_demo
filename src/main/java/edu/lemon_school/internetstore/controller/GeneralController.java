package edu.lemon_school.internetstore.controller;

import edu.lemon_school.internetstore.dto.CustomerDto;
import edu.lemon_school.internetstore.dto.PaymentDto;
import edu.lemon_school.internetstore.dto.ProductDto;
import edu.lemon_school.internetstore.dto.UserDto;
import edu.lemon_school.internetstore.rolesenum.Role;
import edu.lemon_school.internetstore.service.CustomUserDetailsService;
import edu.lemon_school.internetstore.service.GeneralService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static edu.lemon_school.internetstore.utils.EnrichControllerMethods.enrichCustomerModelAttribute;


@Controller
public class GeneralController {

    private final GeneralService generalService;
    private final CustomUserDetailsService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public GeneralController(GeneralService generalService, CustomUserDetailsService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.generalService = generalService;
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

        UserDto userDto = UserDto.builder()
                .userName(userName)
                .userPass(bCryptPasswordEncoder.encode(password))
                .userRole(Role.USER.getRoleName())
                .build();
        userService.addNewUser(userDto);
        return "index";
    }

    @GetMapping(value = "/get_customer_by_name")
    public ModelAndView getCustomerByName(
            @RequestParam("firstName") String firstName,
            @ModelAttribute("model") ModelMap model) {
        List<CustomerDto> customers = generalService.getCustomersByName(firstName);
        model.addAttribute("customersList", customers);
        return new ModelAndView("/pages/all_customers", model);
    }


    @GetMapping(value = "/")
    public String getAllPersons() {
        return "index";
    }



    @GetMapping(value = "/all_customers")
    public String allCustomers(@ModelAttribute("model") ModelMap model) {
        enrichCustomerModelAttribute(model);
        return "/pages/all_customers";
    }

    @GetMapping(value = "/all_products")
    public String getAllProducts(@ModelAttribute("model") ModelMap model) {
        List<ProductDto> products = generalService.productsList();
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






}
