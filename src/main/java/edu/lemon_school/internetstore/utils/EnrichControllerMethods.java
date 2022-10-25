package edu.lemon_school.internetstore.utils;

import edu.lemon_school.internetstore.dto.CustomerDto;
import edu.lemon_school.internetstore.dto.PaymentDto;
import edu.lemon_school.internetstore.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Component
public class EnrichControllerMethods {

    public static GeneralService GENERAL_SERVICE;

    private void setGeneralServiceStatic(GeneralService generalService) {
        GENERAL_SERVICE = generalService;
    }

    public EnrichControllerMethods(GeneralService generalService) {
        GENERAL_SERVICE = generalService;
    }

    public static void enrichPaymentModelAttribute (@ModelAttribute("model") ModelMap model){
        List<PaymentDto> payments = GENERAL_SERVICE.paymentList();
        model.addAttribute("paymentList", payments);
    }

    public static void enrichCustomerModelAttribute(@ModelAttribute("model") ModelMap model) {
        List<CustomerDto> customers = GENERAL_SERVICE.customerList();
        model.addAttribute("customersList", customers);
    }

}
