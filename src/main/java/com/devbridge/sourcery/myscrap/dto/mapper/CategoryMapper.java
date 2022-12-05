package com.devbridge.sourcery.myscrap.dto.mapper;

import com.devbridge.sourcery.myscrap.dto.CategoryDto;
import com.devbridge.sourcery.myscrap.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

  CategoryDto toCategoryDto(Category categories);

  @Mapping(target = "items", ignore = true)
  Category toCategoryEntity(CategoryDto categoriesDto);
}
