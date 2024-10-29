package org.example.mod4.mappers;

import org.example.mod4.DTO.CategoryDTO;
import org.example.mod4.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    CategoryDTO toDto(Category category);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    Category toEntity(CategoryDTO categoryDTO);
}
