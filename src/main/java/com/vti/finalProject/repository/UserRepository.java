package com.vti.finalProject.repository;

import com.vti.finalProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findById(long id);
}
