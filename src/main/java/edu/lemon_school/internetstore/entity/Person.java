package edu.lemon_school.internetstore.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phoneNumber;

}
