package edu.lemon_school.internetstore.service;

import edu.lemon_school.internetstore.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

public interface CustomUserDetailsService extends UserDetailsService {
    void addNewUser(User user);
}
