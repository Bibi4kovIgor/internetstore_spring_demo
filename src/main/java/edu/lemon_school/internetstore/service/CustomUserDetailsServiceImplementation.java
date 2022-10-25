package edu.lemon_school.internetstore.service;

import edu.lemon_school.internetstore.dto.UserDto;
import edu.lemon_school.internetstore.entity.User;
import edu.lemon_school.internetstore.repository.UserRepository;
import edu.lemon_school.internetstore.utils.DtoToEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsServiceImplementation implements CustomUserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUserName(username))
                .orElseThrow(() -> new UsernameNotFoundException("Username was not found!"));
    }

    @Override
    public void addNewUser(UserDto userDto) {
        User user = DtoToEntity.userDtoToEntity(userDto);
        userRepository.save(user);
    }
}
