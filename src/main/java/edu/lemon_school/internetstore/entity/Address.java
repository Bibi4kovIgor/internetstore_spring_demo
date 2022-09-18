package edu.lemon_school.internetstore.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @NonNull
    @Column(name = "country")
    private String country;

    @NonNull
    @Column(name = "city")
    private String city;

    @NonNull
    @Column(name = "street")
    private String street;

    @NonNull
    @Column(name = "house_number")
    private Integer houseNumber;

    @Column(name = "flat_number")
    private Integer flatNumber;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
