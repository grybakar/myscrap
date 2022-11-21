package com.devbridge.sourcery.myscrap.service;

import com.devbridge.sourcery.myscrap.dto.CategoryDto;
import com.devbridge.sourcery.myscrap.dto.mapper.CategoryMapper;
import com.devbridge.sourcery.myscrap.model.Category;
import com.devbridge.sourcery.myscrap.repository.CategoryRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {

  public final CategoryRepository categoryRepository;
  public final CategoryMapper categoryMapper;

  public List<CategoryDto> findAllByCategoryName(String categoryName) {
    List<Category> categoryByCategoryName = categoryRepository.findAllByCategoryName(categoryName);
    return categoryByCategoryName
      .stream()
      .map(categoryMapper::mapToDto)
      .collect(Collectors.toList());
  }
}