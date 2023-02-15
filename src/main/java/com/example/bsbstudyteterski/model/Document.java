package com.example.bsbstudyteterski.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "document")
public class Document {

    @Column(name = "year")
    int year;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long document_id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;
}
