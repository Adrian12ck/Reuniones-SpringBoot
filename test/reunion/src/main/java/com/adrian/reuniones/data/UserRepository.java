package com.adrian.reuniones.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrian.reuniones.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

