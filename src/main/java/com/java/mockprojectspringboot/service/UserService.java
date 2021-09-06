package com.java.mockprojectspringboot.service;

import com.java.mockprojectspringboot.dto.UserRegistrationDto;
import com.java.mockprojectspringboot.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
