package com.example.bsbstudyteterski.repository;

import com.example.bsbstudyteterski.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {

}
