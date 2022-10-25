package edu.lemon_school.internetstore.controller;

import edu.lemon_school.internetstore.dto.CustomerDto;
import edu.lemon_school.internetstore.dto.PaymentDto;
import edu.lemon_school.internetstore.service.AdminService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static edu.lemon_school.internetstore.utils.EnrichControllerMethods.enrichCustomerModelAttribute;
import static edu.lemon_school.internetstore.utils.EnrichControllerMethods.enrichPaymentModelAttribute;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@Controller
public class AdminController {

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    private final AdminService adminService;

    @GetMapping(value = "/add_payment")
    public ModelAndView addPayment(@ModelAttribute("model") ModelMap model) {
        enrichPaymentModelAttribute(model);
        return new ModelAndView("/pages/add_payment", model);
    }

    @PostMapping(value = "/add_payment")
    public ModelAndView addPayment(
            @ModelAttribute("model") ModelMap model,
            @RequestParam(name = "account") String account) {

        PaymentDto paymentDto = PaymentDto.builder()
                .account(account)
                .build();
        adminService.addNewPayment(paymentDto);
        enrichPaymentModelAttribute(model);
        return new ModelAndView("/pages/add_payment", model);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/add_customer")
    public String addCustomer(@ModelAttribute("model") ModelMap model) {
        enrichCustomerModelAttribute(model);
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
        CustomerDto customerDto = CustomerDto.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();
        adminService.addNewCustomer(customerDto);
        enrichCustomerModelAttribute(model);
        return new ModelAndView("/pages/add_customer", model);

        }


}
