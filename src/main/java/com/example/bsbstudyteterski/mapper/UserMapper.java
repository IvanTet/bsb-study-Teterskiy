package com.example.bsbstudyteterski.mapper;

import com.example.bsbstudyteterski.dto.UsrDto;
import com.example.bsbstudyteterski.model.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring", uses = {AddressMapper.class, DocumentMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    @Mapping(target = "documents", ignore = true)
    @Mapping(target = "addresses", ignore = true)
    UsrDto toUserDto(User user);

    User toUser(UsrDto user);

/*    @AfterMapping
    default void setUserAddressAndDocument(@MappingTarget UsrDto userDTO, User user) {
        List<Address> addresses = AddressMapper.INSTANCE.toDTO(user.getAddresses());
        List<Document> documents = DocumentMapper.INSTANCE.toDTO(user.getDocuments());

        userDTO.setAddresses(addresses);
        userDTO.setDocuments(documents);
    }*/
}
