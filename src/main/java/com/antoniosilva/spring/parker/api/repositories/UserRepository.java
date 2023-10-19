package com.antoniosilva.spring.parker.api.repositories;

import com.antoniosilva.spring.parker.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
