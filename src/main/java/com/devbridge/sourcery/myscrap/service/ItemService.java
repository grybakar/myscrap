package com.devbridge.sourcery.myscrap.service;

import com.devbridge.sourcery.myscrap.dto.ItemDto;
import com.devbridge.sourcery.myscrap.dto.mapper.ItemMapper;
import com.devbridge.sourcery.myscrap.model.Item;
import com.devbridge.sourcery.myscrap.repository.ItemRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ItemService {

  private final ItemRepository itemRepository;
  private final ItemMapper itemMapper;

  public List<ItemDto> findItemsByCategoriesId(Long categoriesId) {
    List<Item> itemsByCategoriesId = itemRepository.findItemsByCategoriesId(categoriesId);
    return itemsByCategoriesId
      .stream()
      .map(itemMapper::mapToDto)
      .collect(Collectors.toList());
  }

}
