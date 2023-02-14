package com.example.bsbstudyteterski.dto;

import com.example.bsbstudyteterski.model.User;
import lombok.Data;

@Data
public class DocumentDTO {

    int year;

    private long document_id;

    private String title;

    private String content;

    private User user;
}
