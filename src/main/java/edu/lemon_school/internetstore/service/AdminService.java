package edu.lemon_school.internetstore.service;

import edu.lemon_school.internetstore.dto.CustomerDto;
import edu.lemon_school.internetstore.dto.PaymentDto;

public interface AdminService {
    void addNewCustomer(CustomerDto customerDto);
    void addNewPayment(PaymentDto paymentDto);
}
