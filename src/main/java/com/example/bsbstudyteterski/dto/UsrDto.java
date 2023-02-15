package com.example.bsbstudyteterski.dto;

import com.example.bsbstudyteterski.model.Address;
import com.example.bsbstudyteterski.model.Document;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
/*@Configuration*/
public class UsrDto {

    @Pattern(regexp = "[a-zA-Z]")
    private String firstName;
    @Pattern(regexp = "[a-zA-Z]")
    private String lastName;
    private String email;
    private String phoneNumber;

    private String password;

    @NotBlank
    private String login;

    List<Document> documents = new ArrayList<>();

    List<Address> addresses = new ArrayList<>();

    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    public void addDocument(Document document) {
        this.documents.add(document);
    }

    public UsrDto(String firstName, String lastName, String email, String phoneNumber, String password, String login, List<Document> documents, List<Address> addresses) {
        this.password = password;
        this.login = login;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.documents = documents;
        this.addresses = addresses;
    }

}
