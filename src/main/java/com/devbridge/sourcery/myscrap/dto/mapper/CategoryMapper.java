package com.devbridge.sourcery.myscrap.dto.mapper;

import com.devbridge.sourcery.myscrap.dto.CategoryDto;
import com.devbridge.sourcery.myscrap.model.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryMapper {

  private final MapperConfig mapperConfig;

  public CategoryDto mapToDto(Category categories) {
    return mapperConfig.modelMapper().map(categories, CategoryDto.class);
  }

  public Category mapToEntity(CategoryDto categoriesDto) {
    return mapperConfig.modelMapper().map(categoriesDto, Category.class);
  }
}
