package edu.lemon_school.internetstore.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
public class PaymentDto {

    private String id;

    private String account;
}
