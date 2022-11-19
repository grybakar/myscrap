package com.devbridge.sourcery.myscrap.dto.mapper;

import com.devbridge.sourcery.myscrap.dto.ItemDto;
import com.devbridge.sourcery.myscrap.model.Item;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemMapper {

  private final MapperConfig mapperConfig;

  public ItemDto mapToDto(Item item) {
    return mapperConfig.modelMapper().map(item, ItemDto.class);
  }

  public Item mapToEntity(ItemDto itemDto) {
    return mapperConfig.modelMapper().map(itemDto, Item.class);
  }

}
