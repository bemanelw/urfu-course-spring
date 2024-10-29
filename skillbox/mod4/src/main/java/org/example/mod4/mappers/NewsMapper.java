package org.example.mod4.mappers;

import org.example.mod4.DTO.NewsDTO;
import org.example.mod4.entities.Comment;
import org.example.mod4.entities.News;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NewsMapper {
    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    @Mapping(source = "author.id", target = "author.id")
    @Mapping(source = "author.username", target = "author.username")
    @Mapping(source = "category.id", target = "category.id")
    @Mapping(source = "category.name", target = "category.name")
    @Mapping(source = "comments", target = "commentCount", qualifiedByName = "commentCount")
    NewsDTO toDto(News news);

    @Mapping(source = "author.id", target = "author.id")
    @Mapping(source = "author.username", target = "author.username")
    @Mapping(source = "category.id", target = "category.id")
    @Mapping(source = "category.name", target = "category.name")
    News toEntity(NewsDTO newsDTO);

    @Named("commentCount")
    default int commentCount(List<Comment> comments) {
        return comments != null ? comments.size() : 0;
    }
}