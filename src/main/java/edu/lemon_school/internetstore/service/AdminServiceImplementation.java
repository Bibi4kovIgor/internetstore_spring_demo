package edu.lemon_school.internetstore.service;

import edu.lemon_school.internetstore.dto.CustomerDto;
import edu.lemon_school.internetstore.dto.PaymentDto;
import edu.lemon_school.internetstore.entity.Customer;
import edu.lemon_school.internetstore.entity.Payment;
import edu.lemon_school.internetstore.repository.CustomerRepository;
import edu.lemon_school.internetstore.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AdminServiceImplementation implements AdminService {

    private final CustomerRepository customerRepository;
    private final PaymentRepository paymentRepository;

    public AdminServiceImplementation(CustomerRepository customerRepository, PaymentRepository paymentRepository) {
        this.customerRepository = customerRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void addNewCustomer(CustomerDto customerDto) {
        Customer customer = Customer.builder()
                .id(UUID.fromString(customerDto.getId()))
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .phoneNumber(customerDto.getPhoneNumber())
                .email(customerDto.getEmail())
                .build();
        customerRepository.save(customer);
    }

    @Override
    public void addNewPayment(PaymentDto paymentDto) {
        Payment payment = Payment.builder()
                .account(paymentDto.getAccount())
                .build();

        paymentRepository.save(payment);
    }
}
