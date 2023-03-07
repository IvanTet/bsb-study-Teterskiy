package com.example.bsbstudyteterski.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Data
@Entity
@Table(name = "users")
public class User {
//todo добавить сущность (логин пароль), для импл userDetails
    @OneToMany(mappedBy = "document_id",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    List<Document> documents = new ArrayList<>();

    @OneToMany(mappedBy = "address_id",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    List<Address> addresses = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "password")
    private String password;
    @Column(name = "login")
    private String login;
    @Column(name = "email")
    private String email;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "changedAt")
    private LocalDateTime updatedAt;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    public void addDocument(Document document) {
        this.documents.add(document);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return user_id == user.user_id && Objects.equals(firstName, user.firstName)
                && Objects.equals(lastName, user.lastName)
                && Objects.equals(phoneNumber, user.phoneNumber)
                && Objects.equals(email, user.email)
                && Objects.equals(login, user.login)
                && Objects.equals(password, user.password);
    }

    public Set<Role> getRoles() {
        Set<Role> roles = new HashSet<>();
        roles.add(this.getRole());
        return roles;
    }

    private Role getRole() {
        return this.role;
    }
}
