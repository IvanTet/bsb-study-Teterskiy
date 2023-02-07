package com.example.bsbstudyteterski.controller;


import com.example.bsbstudyteterski.dto.UsrDto;
import com.example.bsbstudyteterski.model.User;
import com.example.bsbstudyteterski.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody UsrDto usrDto) {
           User user = userService.saveUser(usrDto);
           return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
     public ResponseEntity<User> updateUser(@RequestBody UsrDto usrDto, @PathVariable("id") Long id) {
        User user = userService.updateUser(usrDto, id);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getById(@PathVariable("id") Long id) {
        User user =userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUserById (@PathVariable("id") Long id) {
        userService.deleteById(id);
    }
}
