package edu.lemon_school.internetstore.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Payment")
public class Payment implements EntityModel {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "account")
    private String account;

}
