package edu.lemon_school.internetstore.service;

import edu.lemon_school.internetstore.entity.Address;
import edu.lemon_school.internetstore.entity.Customer;
import edu.lemon_school.internetstore.entity.Payment;
import edu.lemon_school.internetstore.entity.Product;

import java.util.List;

public interface InternetStoreService {
    List<Address> addressList();
    List<Customer> customerList();
    List<Payment> paymentList();
    List<Product> productsList();
}
