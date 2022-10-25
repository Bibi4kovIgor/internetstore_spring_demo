package edu.lemon_school.internetstore.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class UserDto {
    private String userName;
    private String userPass;
    private String userRole;
}
