package com.example.myawesomejobportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.myawesomejobportal.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
