package edu.lemon_school.internetstore.service;

import edu.lemon_school.internetstore.entity.Address;
import edu.lemon_school.internetstore.entity.Customer;
import edu.lemon_school.internetstore.entity.Payment;
import edu.lemon_school.internetstore.entity.Product;
import edu.lemon_school.internetstore.repository.AddressRepository;
import edu.lemon_school.internetstore.repository.CustomerRepository;
import edu.lemon_school.internetstore.repository.PaymentRepository;
import edu.lemon_school.internetstore.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternetStoreServiceImplementation implements InternetStoreService {
    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;
    private final PaymentRepository paymentRepository;
    private final ProductRepository productRepository;

    public InternetStoreServiceImplementation(AddressRepository addressRepository,
                                              CustomerRepository customerRepository,
                                              PaymentRepository paymentRepository,
                                              ProductRepository productRepository) {
        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
        this.paymentRepository = paymentRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Address> addressList() {
        return addressRepository.findAll();
    }

    @Override
    public List<Customer> customerList() {
        return customerRepository.findAll();
    }

    @Override
    public List<Payment> paymentList() {
        return paymentRepository.findAll();
    }

    @Override
    public List<Product> productsList() {
        return productRepository.findAll();
    }
}
