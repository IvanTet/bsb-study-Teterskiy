package com.example.bsbstudyteterski.repository;

import com.example.bsbstudyteterski.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Long> {
    @Query("Select user from users where user.login = :login")
    User findByLogin(@Param("login") String login);
}
