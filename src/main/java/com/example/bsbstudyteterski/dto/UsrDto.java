package com.example.bsbstudyteterski.dto;

import lombok.Data;

@Data
/*@Configuration*/
public class UsrDto {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    private String password;

    private String login;

    public UsrDto(String firstName, String lastName, String email, String phoneNumber, String password, String login) {
        this.password = password;
        this.login = login;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

}
