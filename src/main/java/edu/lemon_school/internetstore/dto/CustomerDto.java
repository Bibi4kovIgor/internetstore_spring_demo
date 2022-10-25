package edu.lemon_school.internetstore.dto;

import edu.lemon_school.internetstore.entity.Address;
import edu.lemon_school.internetstore.entity.Payment;
import edu.lemon_school.internetstore.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@Builder
@ToString
public class CustomerDto {

    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private Payment payment;

    private Set<Address> addresses;

    private Set<Product> products;

}
