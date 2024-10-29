package org.example.mod4.mappers;

import org.example.mod4.DTO.UserDTO;
import org.example.mod4.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDto(User user);
    User toEntity(UserDTO userDTO);
}