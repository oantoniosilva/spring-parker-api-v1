package com.antoniosilva.spring.parker.api.services;

import com.antoniosilva.spring.parker.api.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository)  {
        this.userRepository = userRepository;
    }
}
