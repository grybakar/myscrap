package com.devbridge.sourcery.myscrap.service;

import com.devbridge.sourcery.myscrap.dto.ItemDto;
import com.devbridge.sourcery.myscrap.dto.ItemsClassificatorsDto;
import com.devbridge.sourcery.myscrap.dto.mapper.ItemMapper;
import com.devbridge.sourcery.myscrap.dto.mapper.ItemsClassificatorsMapper;
import com.devbridge.sourcery.myscrap.exception.MyScrapException;
import com.devbridge.sourcery.myscrap.model.Item;
import com.devbridge.sourcery.myscrap.repository.ItemRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ItemService {

  private final ItemRepository itemRepository;
  private final ItemMapper itemMapper;
  private final ItemsClassificatorsMapper itemsClassificatorsMapper;

  public List<ItemDto> findItemsByCategoriesId(Long categoriesId) {
    List<Item> itemsByCategoriesId = itemRepository.findItemsByCategoriesId(categoriesId);
    return itemsByCategoriesId
      .stream()
      .map(itemMapper::mapToDto)
      .toList();
  }

  public List<ItemsClassificatorsDto> findItemsByName(String name) {
    log.info("Finding items by name: {}", name);
    List<Item> itemsByName = itemRepository.findItemsByName(name);
    boolean isEmpty = itemsByName.isEmpty();
    if (isEmpty) {
      throw new MyScrapException("No item present by this name");
    }
    return itemsByName
      .stream()
      .map(itemsClassificatorsMapper::mapToDto)
      .toList();
  }


}
