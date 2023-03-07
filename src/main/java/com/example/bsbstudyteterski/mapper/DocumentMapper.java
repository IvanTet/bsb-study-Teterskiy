package com.example.bsbstudyteterski.mapper;

import com.example.bsbstudyteterski.dto.DocumentDTO;
import com.example.bsbstudyteterski.model.Document;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(uses = UserMapper.class)
public interface DocumentMapper {

   @Mapping(target = "user", ignore = true)
   DocumentDTO toDTO(Document document);
}
