package com.example.bsbstudyteterski.service;

import com.example.bsbstudyteterski.dto.UsrDto;
import com.example.bsbstudyteterski.mapper.UserMapper;
import com.example.bsbstudyteterski.model.Role;
import com.example.bsbstudyteterski.model.User;
import com.example.bsbstudyteterski.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    public UserService(UserRepository userRepository, UserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public Optional<User> findById(Long id) {
        return this.userRepository.findById(id);
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User saveUser(UsrDto userDto) {
        User user = mapper.toUser(userDto);
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        Optional<User> user = this.userRepository.findById(id);
        return user.get();
    }

    public Optional<User> getByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public User updateUser(UsrDto usrDto, Long id) {
        User user = getUserById(id);
        user.setFirstName(usrDto.getFirstName());
        user.setLastName(usrDto.getLastName());
        user.setEmail(usrDto.getEmail());
        user.setPhoneNumber(usrDto.getPhoneNumber());
        user.setUpdatedAt(LocalDateTime.now());
        user.setLogin(usrDto.getLogin());
        user.setPassword(user.getPassword());
        user.setUser_id(id);
        return this.userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = getByLogin(login).get();
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException(String.format("User %s is not found", login));
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), true, true, true, true, new HashSet<>());
    }

}
