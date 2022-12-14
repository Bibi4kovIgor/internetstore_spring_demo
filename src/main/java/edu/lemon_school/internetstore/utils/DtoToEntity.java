package edu.lemon_school.internetstore.utils;

import edu.lemon_school.internetstore.dto.CustomerDto;
import edu.lemon_school.internetstore.dto.UserDto;
import edu.lemon_school.internetstore.entity.Customer;
import edu.lemon_school.internetstore.entity.User;

import java.util.UUID;

public class DtoToEntity {
    public static Customer customerDtoToEntity(CustomerDto customerData) {
        return Customer.builder()
                .phoneNumber(customerData.getPhoneNumber())
                .addresses(customerData.getAddresses())
                .email(customerData.getEmail())
                .id(UUID.fromString(customerData.getId()))
                .payment(customerData.getPayment())
                .firstName(customerData.getFirstName())
                .lastName(customerData.getLastName())
                .build();
    }

    public static User userDtoToEntity(UserDto userDto) {
        return User.builder()
                .userName(userDto.getUserName())
                .userRole(userDto.getUserRole())
                .userPass(userDto.getUserPass())
                .build();
    }

}
