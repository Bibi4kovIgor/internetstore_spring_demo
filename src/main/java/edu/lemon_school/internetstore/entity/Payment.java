package edu.lemon_school.internetstore.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "account")
    private String account;

}
