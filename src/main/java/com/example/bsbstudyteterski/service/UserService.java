package com.example.bsbstudyteterski.service;

import com.example.bsbstudyteterski.dto.UsrDto;
import com.example.bsbstudyteterski.model.User;
import com.example.bsbstudyteterski.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findById(Long id) {
        return this.userRepository.findById(id);
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User saveUser(UsrDto usrDto) {
        User user = new User();
        user.setFirstName(usrDto.getFirstName());
        user.setLastName(usrDto.getLastName());
        user.setEmail(usrDto.getEmail());
        user.setPhoneNumber(usrDto.getPhoneNumber());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        Optional<User> user = this.userRepository.findById(id);
        return user.get();
    }

    public User updateUser(UsrDto usrDto, Long id) {
        User user = getUserById(id);
        user.setFirstName(usrDto.getFirstName());
        user.setLastName(usrDto.getLastName());
        user.setEmail(usrDto.getEmail());
        user.setPhoneNumber(usrDto.getPhoneNumber());
        user.setUpdatedAt(LocalDateTime.now());
        user.setId(id);
        return this.userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
