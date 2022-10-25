package edu.lemon_school.internetstore.utils;

import edu.lemon_school.internetstore.dto.CustomerDto;
import edu.lemon_school.internetstore.dto.PaymentDto;
import edu.lemon_school.internetstore.dto.ProductDto;
import edu.lemon_school.internetstore.entity.Address;
import edu.lemon_school.internetstore.entity.Customer;
import edu.lemon_school.internetstore.entity.Payment;
import edu.lemon_school.internetstore.entity.Product;

import java.util.Set;

public class EntityToDto {

    public static ProductDto productEntityToDto(Product entity) {
        return ProductDto.builder()
                .id(String.valueOf(entity.getId()))
                .description(entity.getDescription())
                .name(entity.getName())
                .price(entity.getPrice())
                .build();
    }

    public static CustomerDto customerEntityToDto(Customer entity) {
        return CustomerDto.builder()
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .payment(entity.getPayment())
                .phoneNumber(entity.getPhoneNumber())
                .id(String.valueOf(entity.getId()))
                .build();
    }

    public static PaymentDto paymentEntityToDto(Payment entity) {
        return PaymentDto.builder()
                .id(String.valueOf(entity.getId()))
                .account(entity.getAccount())
                .build();
    }

}
