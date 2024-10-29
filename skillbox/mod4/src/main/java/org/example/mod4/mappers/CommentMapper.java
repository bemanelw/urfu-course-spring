package org.example.mod4.mappers;

import org.example.mod4.DTO.CommentDTO;
import org.example.mod4.entities.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(source = "author.id", target = "author.id")
    @Mapping(source = "author.username", target = "author.username")
    CommentDTO toDto(Comment comment);

    @Mapping(source = "author.id", target = "author.id")
    @Mapping(source = "author.username", target = "author.username")
    Comment toEntity(CommentDTO commentDTO);
}
