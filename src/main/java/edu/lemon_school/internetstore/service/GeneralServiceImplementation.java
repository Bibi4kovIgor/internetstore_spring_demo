package edu.lemon_school.internetstore.service;

import edu.lemon_school.internetstore.dto.CustomerDto;
import edu.lemon_school.internetstore.dto.PaymentDto;
import edu.lemon_school.internetstore.dto.ProductDto;
import edu.lemon_school.internetstore.entity.Address;
import edu.lemon_school.internetstore.repository.AddressRepository;
import edu.lemon_school.internetstore.repository.CustomerRepository;
import edu.lemon_school.internetstore.repository.PaymentRepository;
import edu.lemon_school.internetstore.repository.ProductRepository;
import edu.lemon_school.internetstore.utils.EntityToDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralServiceImplementation implements GeneralService {
    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;
    private final PaymentRepository paymentRepository;
    private final ProductRepository productRepository;

    public GeneralServiceImplementation(AddressRepository addressRepository,
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
    public List<CustomerDto> customerList() {
        return customerRepository.findAll().stream()
                .map(EntityToDto::customerEntityToDto)
                .toList();
    }



    @Override
    public List<CustomerDto> getCustomersByName(String name) {
        return customerRepository.getCustomersByNane(name).stream()
                .map(EntityToDto::customerEntityToDto)
                .toList();
    }

    @Override
    public List<PaymentDto> paymentList() {
        return paymentRepository.findAll().stream()
                .map(EntityToDto::paymentEntityToDto)
                .toList();
    }

    @Override
    public List<ProductDto> productsList() {

        return productRepository.findAll().stream()
                .map(EntityToDto::productEntityToDto)
                .toList();
    }


}
