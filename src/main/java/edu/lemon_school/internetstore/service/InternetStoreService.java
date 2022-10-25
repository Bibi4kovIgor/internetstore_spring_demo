package edu.lemon_school.internetstore.service;

import edu.lemon_school.internetstore.dto.CustomerDto;
import edu.lemon_school.internetstore.dto.PaymentDto;
import edu.lemon_school.internetstore.dto.ProductDto;
import edu.lemon_school.internetstore.entity.Address;
import edu.lemon_school.internetstore.entity.Customer;

import java.util.List;
public interface InternetStoreService {
    List<Address> addressList();
    List<CustomerDto> customerList();
    void addNewCustomer(Customer customer);
    List<CustomerDto> getCustomersByName(String name);
    List<PaymentDto> paymentList();
    List<ProductDto> productsList();


}
