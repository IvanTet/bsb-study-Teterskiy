package com.example.bsbstudyteterski.mapper;

import com.example.bsbstudyteterski.dto.AddressDTO;
import com.example.bsbstudyteterski.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = UserMapper.class)
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(target = "user", ignore = true)
    AddressDTO toDTO(Address address);

}
