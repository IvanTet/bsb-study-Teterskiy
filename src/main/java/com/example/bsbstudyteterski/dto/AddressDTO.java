package com.example.bsbstudyteterski.dto;

import com.example.bsbstudyteterski.model.User;
import lombok.Data;

@Data
public class AddressDTO {

    private long address_id;

    private long post_index;

    private String city;

    private String country;

    private String location;

    private User user;
}
