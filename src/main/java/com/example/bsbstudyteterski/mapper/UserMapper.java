package com.example.bsbstudyteterski.mapper;

import com.example.bsbstudyteterski.dto.UsrDto;
import com.example.bsbstudyteterski.model.Address;
import com.example.bsbstudyteterski.model.Document;
import com.example.bsbstudyteterski.model.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {Address.class, Document.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {
    UsrDto toUserDto(User user);

    User toUser(UsrDto user);
}
