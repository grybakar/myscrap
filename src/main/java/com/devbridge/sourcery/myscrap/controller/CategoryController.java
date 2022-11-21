package com.devbridge.sourcery.myscrap.controller;

import com.devbridge.sourcery.myscrap.dto.CategoryDto;
import com.devbridge.sourcery.myscrap.service.CategoryService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/categories")
public class CategoryController {

  public final CategoryService categoryService;

  @GetMapping("/search")
  public ResponseEntity<List<CategoryDto>> findAllByCategoryName(@RequestParam String categoryName) {
    List<CategoryDto> categoryDto = categoryService.findAllByCategoryName(categoryName);
    return new ResponseEntity<>(categoryDto, HttpStatus.OK);
  }
}