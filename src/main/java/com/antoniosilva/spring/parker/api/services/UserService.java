package com.antoniosilva.spring.parker.api.services;

import com.antoniosilva.spring.parker.api.entities.User;
import com.antoniosilva.spring.parker.api.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found!")
        );
    }

    @Transactional
    public User changePassword(Long id, String password) {
        var user = findById(id);
        user.setPassword(password);
        return user;
    }

    @Transactional(readOnly = true)
    public List<User> listAll() {
        return userRepository.findAll();
    }
}
