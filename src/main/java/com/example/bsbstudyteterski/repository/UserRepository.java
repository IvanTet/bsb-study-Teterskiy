package com.example.bsbstudyteterski.repository;

import com.example.bsbstudyteterski.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    /*    @Query(value = "Select user from users where users.login = :login", nativeQuery = true)*/
    Optional<User> findByLogin(/*@Param("login")*/ String login);
}
