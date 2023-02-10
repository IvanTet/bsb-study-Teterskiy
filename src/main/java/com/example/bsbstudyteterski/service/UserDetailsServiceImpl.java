package com.example.bsbstudyteterski.service;
import com.example.bsbstudyteterski.model.User;
import com.example.bsbstudyteterski.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) {
        Optional<User> optionalUser = userRepository.find;
        if (!optionalUser.isPresent()) {
            throw new UsernameNotFoundException("User with such username do not exists");
        }
        User user = optionalUser.get();
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        return new org.springframework.security.core.userdetails.User(user.getLastName(), user.getPassword(), grantedAuthorities);
    }
}