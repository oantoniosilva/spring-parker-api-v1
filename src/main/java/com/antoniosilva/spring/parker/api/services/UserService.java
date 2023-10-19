package com.antoniosilva.spring.parker.api.services;

import com.antoniosilva.spring.parker.api.entities.User;
import com.antoniosilva.spring.parker.api.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository)  {
        this.userRepository = userRepository;
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }
}
