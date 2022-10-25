package edu.lemon_school.internetstore.service;

import edu.lemon_school.internetstore.dto.CustomerDto;
import edu.lemon_school.internetstore.dto.PaymentDto;
import edu.lemon_school.internetstore.dto.ProductDto;
import edu.lemon_school.internetstore.entity.Address;

import java.util.List;
public interface GeneralService {
    List<Address> addressList();
    List<CustomerDto> customerList();

    List<CustomerDto> getCustomersByName(String name);
    List<PaymentDto> paymentList();
    List<ProductDto> productsList();


}
