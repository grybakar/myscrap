package com.devbridge.sourcery.myscrap.dto.mapper;

import com.devbridge.sourcery.myscrap.dto.ItemDto;
import com.devbridge.sourcery.myscrap.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemMapper {


  ItemDto toItemDto(Item item);

  @Mapping(target = "classificators", ignore = true)
  @Mapping(target = "categories", ignore = true)
  @Mapping(target = "advertisements", ignore = true)
  Item toItemEntity(ItemDto itemDto);


}
