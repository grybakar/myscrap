package com.devbridge.sourcery.myscrap.controller;

import com.devbridge.sourcery.myscrap.dto.ItemDto;
import com.devbridge.sourcery.myscrap.dto.ItemsClassificatorsDto;
import com.devbridge.sourcery.myscrap.service.ItemService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/items")
@AllArgsConstructor
public class ItemController {

  private ItemService itemService;

  @GetMapping("/categories")
  public ResponseEntity<List<ItemDto>> getAllItemsByCategoryId(@RequestParam Long categoriesId) {
    List<ItemDto> itemsDto = itemService.findItemsByCategoriesId(categoriesId);
    return new ResponseEntity<>(itemsDto, HttpStatus.OK);
  }

  @GetMapping("/")
  public ResponseEntity<List<ItemsClassificatorsDto>> getAllItemsByName(@RequestParam String name) {
    List<ItemsClassificatorsDto> itemsByName = itemService.findItemsByName(name);
    return new ResponseEntity<>(itemsByName, HttpStatus.OK);

  }


}
