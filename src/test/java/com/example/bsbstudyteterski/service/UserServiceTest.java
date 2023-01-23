package com.example.bsbstudyteterski.service;


import com.example.bsbstudyteterski.dto.UsrDto;
import com.example.bsbstudyteterski.model.User;
import com.example.bsbstudyteterski.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;


@SpringBootTest
@AutoConfigureMockMvc
class UserServiceTest {

    @Autowired
    @Mock
    public UserService userService;
    public User user;
    @MockBean
    public UserRepository userRepository;
    public UsrDto userDto = new UsrDto(
            "a",
            "b",
            "c",
            "d"
    );
    private MockMvc mockMvc;

    @Test
    public void saveUserTest() throws Exception {

        User user = new User(userDto);
        user.setId(1);
        user.setUpdatedAt(LocalDateTime.now());
        user.setCreatedAt(LocalDateTime.now());
        Mockito.doReturn(user).when(userRepository).save(ArgumentMatchers.any());
        Assertions.assertNotNull(userService.saveUser(userDto));

    }

    @Test
    void findById() {
        User userId1 = new User(userDto);
        userDto.setFirstName("gf");
        userDto.setLastName("sas");
        User userId2 = new User(userDto);
        userId1.setId(1);
        userId2.setId(2);

        Mockito.doReturn(Optional.of(userId1)).when(userRepository).findById((long) 1);
        Mockito.doReturn(Optional.of(userId2)).when(userRepository).findById((long) 2);

        Assertions.assertNotNull(userService.findById((long) 1));
        Assertions.assertEquals(userId1, userService.findById((long) 1).get());

        Assertions.assertNotNull(userService.findById((long) 2));
        Assertions.assertEquals(userId2, userService.findById((long) 2).get());
    }

    @Test
    void findAll() {
        User userId1 = new User(userDto);
        userDto.setFirstName("gf");
        userDto.setLastName("sas");
        User userId2 = new User(userDto);
        userId1.setId(1);
        userId2.setId(2);

        Mockito.doReturn(List.of(userId1, userId2)).when(userRepository).findAll();

        Assertions.assertNotNull(userService.findAll());
        Assertions.assertIterableEquals(List.of(userId1, userId2), userService.findAll());

    }

    @Test
    void updateUser() {
        User user1 = new User(userDto);
        userDto.setFirstName("gf");
        userDto.setLastName("sas");
        User user2 = new User(userDto);

        user1.setId(1);
        user2.setId(2);


        Mockito.doReturn(Optional.of(user1)).when(userRepository).findById((long) 1);
        Mockito.doReturn(user2).when(userRepository).save(any());

        Assertions.assertNotEquals(user1, userService.updateUser(userDto, (long)1));
        user2.setId(1);
        Mockito.verify(userRepository).save(user2);
    }

    @Test
    void deleteById() {

        userService.deleteById((long)1);
        Mockito.verify(userRepository , atLeastOnce()).deleteById((long)1);

    }
}