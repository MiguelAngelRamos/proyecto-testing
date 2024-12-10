package com.kibernumacademy.testing.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kibernumacademy.testing.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
  
}
