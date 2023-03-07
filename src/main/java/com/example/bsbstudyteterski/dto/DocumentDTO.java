package com.example.bsbstudyteterski.dto;

import com.example.bsbstudyteterski.model.User;
import lombok.Data;
import lombok.NonNull;

@Data
public class DocumentDTO {

    int year;
    @NonNull
    private long document_id;

    private String title;

    private String content;

    private User user;
}
