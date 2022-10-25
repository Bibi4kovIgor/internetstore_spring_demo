package edu.lemon_school.internetstore.service;

import edu.lemon_school.internetstore.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CustomUserDetailsService extends UserDetailsService {
    void addNewUser(UserDto user);
}
